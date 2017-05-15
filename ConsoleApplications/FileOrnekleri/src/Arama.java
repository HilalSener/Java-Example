
/*
1 - Sonuc Listesinde Boyutlar
Büyüklüğe Göre Listenecek

1KB 1024 BYTE
1MB 1024 KB
1GB 1024 MB

2 - Eğer Sonuc Listesinde Gösterilecek Dosyanın
Tam Yol Uzunluğu 42 Karakterden Uzunsa
Dosyanın Adını, Kısaysa, Dosyanın Tam YOlunu
Göstereceksiniz

3 - Arama Sonucundaki File Instance'lari
Eğer Bir Dosyayı Gösteriyorsa
DOSYA (DOSYA UZANTISI) ŞEklinde Gösterilecek

a.txt Dosya (TXT)
Tast Klasor
Aqweasda.mp3 Dosya (MP3)
*/

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Arama 
{
    /**
     * Kullanıcıdan Başlangıç Klasorunu,
     * Ve Dosya Isminde Gececek Arama Değerini Alın
     * Daha Sonra, Bu Arama Sonucuna Uyan Tüm Dosya Ve Klasorleri
     * Belli Bir Formatta Listeleyin
     * 
     * #        Dosya Adı               Türü                Boyut
     * 1        C:\Users\araba.txt      Dosya               1152
     * 2        C:\Users\test\java.txt  Dosya               17824
     * 3        C:\Users\archive        Klasor              0
     */
    
    public static Scanner oku = new Scanner(System.in);
    public static String val = "";
    public static ArrayList<File> rL = new ArrayList<>();
    
    public static void showSonuc()
    {
        //Eğer arama sonucu yoksa
        if(rL.isEmpty())
            System.out.println("İstenilen kriterlerde dosya bulunamadı.");
        else  
        {
            String f = "%3d\t%-50s\t%15s\t%10s\n";
            // ArrayListte Toplanan Her Dosyayı
            for (int i = 0; i < rL.size(); i++) {
                File dosya = rL.get(i);
                String ext = "";
                
                if (dosya.isFile())
                {
                    String ad = dosya.getName();
                    if (ad.lastIndexOf('.') > 0)
                    {
                        ext = ad.substring(ad.lastIndexOf('.')).toUpperCase();
                    }
                    
                }
                
                String dN = "";
                String ad = dosya.getName();
                
                if (ad.length() < 40)
                    dN = ad;
                
                else
                {
                    dN = ad.substring(0,37)+"...";
                }
                
                System.out.printf(
                        f, 
                        (i + 1), 
                        dN, 
                        (dosya.isFile() ? "Dosya ("+ext+")" : "Klasor"),
                        getSize(dosya));
            }
        }
    }
    
    public static void ara(File f)
    {
        //Eğer f bir klasörse
        if(f.isDirectory())
        {
            File altDosyalar[] = f.listFiles();
            
            //kriterler uyuyor mu kontrol et
            if(f.getName().contains(val))
                rL.add(f);
            
            //alt dosyalar array i, f nin içi boşsa null gelecektir
            //Eğer null gelirse array i dolaşamam
            if(altDosyalar != null)
            {
                //klasörün içindeki tm dosyaları tekrar
                //ara methoduna tek tek yolla
                for (File altDosya : altDosyalar) {
                    ara(altDosya);
                }
            }
        }
        //Eğer f bir dosya ise
        else
        {
            //kriterler uyuyor mu kontrol et
            if(f.getName().contains(val))
                rL.add(f);
        }
        
        //Klasörün  içindeki alt doyaları al
        
        //Dosyaların her birini dosya mı klasör mü diye kontrol et
        //Eğer dosya ise işlemi yap
        //Klasör ise, onunda altındaki dosyaların bu kontrollerden 
        //Geçmesi için 
    }
    
    public static String getSize(File f)
    {
        double x = (double) f.length();
        String[] s = {"Byte", "KB", "MB", "TB"};
        int cnt = 0;
        while(x > 1024)
        {
            x/=1024.0;
            cnt++;
        }
        
        return String.format("%.2f %s", x, s[cnt]);
    }
    
    public static void main(String[] args) 
    {
        System.out.println("Başlangıç klasörü: ");
        File f = new File(oku.next());
        System.out.println("Aranacak Değer: ");
        val = oku.next();
   
        System.out.println("Arama başlatıldı");
        ara(f);
        System.out.println("Arama bitti");
        showSonuc();
    }
}

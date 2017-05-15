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
            String f = "%3d\t%-50s\t%6s\t%10d\n";
            for (int i = 0; i < rL.size(); i++) {
                File dosya = rL.get(i);
                System.out.printf(
                        f, 
                        (i + 1), 
                        dosya.getAbsolutePath(), 
                        (dosya.isFile() ? "Dosya" : "Klasor"), 
                        dosya.length());
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
    
    public static void boyut(int x)
    {
        int cnt = 0;
        while(x > 1024)
        {
            x/=1024;
            cnt++;
        }
        if(cnt == 0)
            System.out.println(x + " BYTE");
        if(cnt == 1)
             System.out.println(x + " KB");
        if(cnt == 2)
            System.out.println(x + " MB");
        if(cnt == 3)
            System.out.println(x + " GB");
        if(cnt == 4)
            System.out.println(x + " TB");
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

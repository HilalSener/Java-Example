/*
Telefon Defteri;
Cihazınızdaki Her Kayıt İçin
Bir Ad Olmalı

Bir Kayıt İçin Birden Fazla Telefon Numarası Olabilir

Uygulamanız Calistiginda, Rehberiniz Bos Olacak
Uygulamanızdan Menu Yardimiyla,
Kayitlari Listele / Ekle / Sil / Güncelle / Arama
İşlemlerini Yapacaksınız
Kayıtları Eklerken Ad ve 1 Telefon Numarası
Alacaksınız.
Bir Kayıta 2. 3. ... Numaraları Eklemek İçin
O Kayıtı Güncellemelisiniz
Güncelleyi Seçince Bir Alt Menude
- Adı Güncelle,
- Numara Ekle
- Sil
- Güncelle

Seçenekleri Çıkacak.


*/

package TelefonRehberi;

import java.util.ArrayList;
import java.util.Scanner;

public class Rehber
{
    public static Scanner oku = new Scanner(System.in);
    public static ArrayList<Kayit> kayitListesi = new ArrayList<>();
    
    public static int showMenu()
    {
        System.out.println("1 - Kayıtları Listele");
        System.out.println("2 - Ekle");
        System.out.println("3 - Sil");
        System.out.println("4 - Güncelle");
        System.out.println("5 - Arama");
        System.out.println("6 - Çıkış");
        System.out.print("Seçiminiz [1 - 6]: ");
        return oku.nextInt();
    }
    
    public static void main(String[] args)
    {
        while(true)
        {
            int secim = showMenu();
            
            if(secim < 0 || secim > 6)
            {
                System.out.println("\n***Hatalı Seçim***\n");
            }
            if(secim == 1)
            {
                if(kayitListesi.isEmpty())
                {
                    System.out.println("*** Rehber Boş ***");
                }
                else
                {
                    for (Kayit k : kayitListesi) {
                        System.out.println(k);
                    }
                }
            }
            if(secim == 2)
            {
                System.out.print("Ad: ");
                String ad = oku.next();
                
                System.out.print("Telefon: ");
                String tel = oku.next();
                
                Kayit yeniKayit = new Kayit(ad, tel);
                kayitListesi.add(yeniKayit);
            }
            if(secim == 3)
            {
                String s = "%3d\t%-10s\t%s\n";
                for (int i = 0; i < kayitListesi.size(); i++) {
                    Kayit k = kayitListesi.get(i);
                    System.out.printf(s, i, k.ad, k.numaralar.toString());
                }
                
                System.out.println("Hangi kayıt silinsin (Index' e göre 0 -" + (kayitListesi.size()-1) + " ): ");
                int ndx = oku.nextInt();
                kayitListesi.remove(ndx);
            }
            if(secim == 4)
            {
                String s = "%3d\t%-10s\t%s\n";
                for (int i = 0; i < kayitListesi.size(); i++) {
                    Kayit k = kayitListesi.get(i);
                    System.out.printf(s, i, k.ad, k.numaralar.toString());
                }
                
                System.out.println("Hangi kayıt güncellensin (Index' e göre 0 -" + (kayitListesi.size()-1) + " ): ");
                int ndx = oku.nextInt();
                Kayit secilenKayit = kayitListesi.get(ndx);
                
                System.out.println("1 - Adı Güncelle");
                System.out.println("2 - Numara Ekle");
                System.out.println("3 - Sil");
                System.out.println("4 - Güncelle");
                System.out.print("Seçiminiz [1 - 4]: ");
                int altSecim = oku.nextInt(); 
                
                if(altSecim == 1)
                {
                    System.out.println("Yeni ad: ");
                    secilenKayit.ad = oku.next();
                    
                    kayitListesi.set(ndx, secilenKayit);
                }
                if(altSecim == 2)
                {
                    System.out.println("Yeni numara: ");
                }
            }
            if(secim == 6) break;
        }
    }
}

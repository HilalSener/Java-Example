package TelefonRehberi;

import java.util.ArrayList;
import java.util.Scanner;

public class Rehber
{
    public static Scanner oku = new Scanner(System.in);
    public static ArrayList<Kayit> kayitListesi = new ArrayList<>();
    
    public int showMenu()
    {
        System.out.println("1 - Kayıtları Listele");
        System.out.println("2 - Ekle");
        System.out.println("3 - Sil");
        System.out.println("4 - Güncelle");
        System.out.println("5 - Arama");
        System.out.println("6 - Çıkış");
        int sec = oku.nextInt();
        return sec;
    }
    
    public int GuncelleMenu()
    {
        System.out.println("1 - Adı Güncelle");
        System.out.println("2 - Numara Ekle");
        System.out.println("3 - Sil");
        System.out.println("4 - Güncelle");
        int islem = oku.nextInt();
        return islem;
    }
    
    public static void main(String[] args)
    {
        while(true)
        {
            Rehber r = new Rehber();
            int secim = r.showMenu();
            
            if(secim == 1)
            {
                
            }
        }
    }
}

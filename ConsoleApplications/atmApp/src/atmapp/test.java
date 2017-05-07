package atmapp;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner oku = new Scanner(System.in);
        System.out.print("Şifrenizi giriniz: ");
        int sifre = oku.nextInt();
        
        musteri m = new musteri();
        boolean isOk = m.login(sifre);
        
        while(isOk)
        {
            int secim = m.showMenu();
            if(secim == 1)
            {
                System.out.print("Çekmek istediğiniz tutarı giriniz: ");
                double para = oku.nextDouble();
                System.out.println(m.paraCekme(para) + " TL çekildi.");
            }
            if(secim == 2)
            {
                System.out.print("Yatırmak istediğiniz tutarı giriniz: ");
                double para = oku.nextDouble();
                System.out.println(m.paraYatirma(para) + " TL yatırıldı.");
            }
            if(secim == 3)
            {
                System.out.println("Toplam bakiyeniz " + m.bakiyeSorgulama() + " TL");
            }
        }
    }
}

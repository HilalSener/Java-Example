package atmapp;

import java.util.Scanner;

public class musteri {
    public int pass;
    public static int bakiye = 0;
    
    public musteri()
    {
        pass = 1234;
    }
    
    public static Scanner oku = new Scanner(System.in);
    public int showMenu()
    {
        System.out.println("1 - Para Çekme");
        System.out.println("2 - Para Yatırma");
        System.out.println("3- Bakiye Sorgulama");
        System.out.print("İşlem türünü seçiniz [1 - 3]: ");
        int secim = oku.nextInt();
        return secim;
    }
    
    public boolean login(int _pass)
    {
        boolean isOk = false;
        if(pass == _pass)
        {
            System.out.println("Login işlemi başarılı");
            isOk = true;
        }
        else
        {
            System.out.println("Yanlış şifre girişi.");
        }
        return isOk;
    }
    
    public double paraCekme(double para)
    {
        bakiye -= para;
        return bakiye;
    }
    
    public double paraYatirma(double para)
    {
        bakiye += para;
        return bakiye;
    }
    
    public double bakiyeSorgulama()
    {
        return bakiye;
    }
}

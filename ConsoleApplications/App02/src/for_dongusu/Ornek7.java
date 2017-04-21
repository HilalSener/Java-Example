/*
Kullanıcıdan 1 Sayı Alın, Aldığınız Sayının Faktoryel Değerini Bulun
 */
package for_dongusu;

import java.util.Scanner;

public class Ornek7 
{
    public static void main(String[] args) 
    {
        Scanner oku = new Scanner(System.in);
        
        System.out.print("Bir sayı giriniz: ");
        int sayi = oku.nextInt();
        
        int faktoryel = 1;
        for(int i=1; i<=sayi; i++)
        {
            faktoryel*=i;
        }
        System.out.println(faktoryel);
    }
}

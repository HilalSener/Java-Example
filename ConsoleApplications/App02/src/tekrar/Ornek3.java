/*
Kullanıcıdan 2 kenar değeri alıp
Kenar değerlerine göre karenin alan ve çevresi veya 
diktörtgenin alan ve çevresini hesaplayan program
 */
package tekrar;

import java.util.Scanner;

public class Ornek3 
{
    public static void main(String[] args) 
    {
         Scanner oku = new Scanner(System.in);   
         
         System.out.print("1. Kenarı giriniz: ");
         int a = oku.nextInt();
         
         System.out.print("2. Kenarı giriniz: ");
         int b = oku.nextInt();
         
         int alan;
         int cevre;
         if(a == b)
         {
             alan = a * b;
             cevre = 2*a + 2*b;
             System.out.println("Karenin alanı: " + alan + ", Çevresi: " + cevre);
         }
         else
             alan = a * b;
             cevre = 2*a + 2*b;
             System.out.println("Diktörgenin alanı: " + alan + ", Çevresi: " + cevre);
    }
}

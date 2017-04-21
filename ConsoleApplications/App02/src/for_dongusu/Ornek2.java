/*
Kullanıcıdan 5 sayı al, toplam ve ortalamasını bul
 */
package for_dongusu;

import java.util.Scanner;

public class Ornek2 
{
    public static void main(String[] args) 
    {
           Scanner oku = new Scanner(System.in); 
           double toplam = 0, ort = 0;
           
           for(int i=0; i<5; i++)
           {
               System.out.println("Sayı: ");
               double s = oku.nextDouble();
               toplam += s;
           }
           
           ort = toplam/5;
           System.out.println("Toplam: " + toplam);
           System.out.println("Ortalama: " + ort);
    }
}

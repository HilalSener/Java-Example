/*
Kullanıcıdan 1 Sayı Alın, Bu Sayının Asal Olup Olmadığını Bulun

1. Yaklaşım : Asal Sayıların 2 Tam Böleni Vardır. 1 ve Kendisi
N Sayısı için 1,2,3,4,5....,n-1,n tüm sayıları n sayısını kalansız bölüyor mu
diye kontrol edin, kalansız bölen her bir sayı için sayac değerini 1 arttırın
eğer sayac degeri 2 cikiyorsa sayi asaldir.

2. yaklasim :
1 ve sayının kendisi dişinda arada kalan tüm sayıları
örneğin 7 için 2,3,4,5,6 n sayısını kalansız bölüyor mu diye kontrol edin
eğer bi tane sayı n'i kalansız bölüyorsa, n sayisi asal değildir.

<= 1 sayilar asal değildir 
 */
package for_dongusu;

import java.util.Scanner;

public class Ornek6 
{
    public static void main(String[] args)
    {
        Scanner oku = new Scanner(System.in);
        
        System.out.print("Bir sayı giriniz: ");
        int sayi = oku.nextInt();
        
        boolean asalmi = true;
        int sayac = 0; 
        for(int i=2; i<sayi; i++)
        {
            if(sayi % i == 0)
            {
                asalmi = false;
                System.out.println("Sayı asal değil!");
            }
        }
    }
}

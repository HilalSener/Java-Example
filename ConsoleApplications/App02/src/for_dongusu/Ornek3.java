/*
Kullanıcıdan 2 Sayı Alın (n1 ve n2)
n1 ve n2 dahil olmak üzere, n1 ve n2 arasındaki tüm sayıların toplamını ve ortalamasını ekrana bastırın
 */
package for_dongusu;

import java.util.Scanner;

public class Ornek3 
{
    public static void main(String[] args) 
    {
        Scanner oku = new Scanner(System.in); 
        
        System.out.print("n1: ");
        int n1 = oku.nextInt();
        
        System.out.print("n2: ");
        int n2 = oku.nextInt();
        
        double toplam=0, ort=0;
        for(int i=n1; i<=n2; i++)
        {
            toplam+=i;
            ort = toplam/((n2 + n1)-1);
        }
        System.out.println("Toplam: " + toplam);
        System.out.println("Ort: " + ort);
    }
}

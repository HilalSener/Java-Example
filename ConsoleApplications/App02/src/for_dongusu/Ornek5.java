/*
kullanıcıya kaç sayı gireceğini sorun
sonra bu sayıları kullanıcıdan alın
kullanıcının girdiği sayıların arasından en büyük ve en küçük olanı bastırın
 */
package for_dongusu;

import java.util.Scanner;

public class Ornek5
{
    public static void main(String[] args)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        Scanner oku = new Scanner(System.in);
        System.out.println("Kaç sayı girilecek: ");
        int kacTane = oku.nextInt();
        
        for(int i=0; i<kacTane; i++)
        {
            System.out.println("Sayı: ");
            int n = oku.nextInt();
            
            if(n < min) min = n;
            if(n > max) max = n;
        }
        System.out.println("Max: " + max + "\nMin: " + min);
    }
}

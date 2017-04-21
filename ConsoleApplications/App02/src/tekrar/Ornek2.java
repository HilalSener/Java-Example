/*
 Kullanıcıdan alınan kenarlar ile üçgen yapılabliyor mu bakan program
 */
package tekrar;

import java.util.Scanner;

public class Ornek2 
{
    public static void main(String[] args) 
    {
        Scanner oku = new Scanner(System.in);
        
        System.out.println("A kenarı: ");
        int a = oku.nextInt();
        
        System.out.println("B kenarı: ");
        int b = oku.nextInt();
        
        System.out.println("C kenarı: ");
        int c = oku.nextInt();
        
        //Her kenarın toplamı, 3. kenardan büyük ya da 
        //3.kenara eşit olmalı
        if(a+b >=c && b+c >=a && a+c>=b)
            System.out.println("Bu kenarlar değerleri ok");
        else
            System.out.println("Bu değerler ile üçgen yapılamaz!");
    }
}

/*
Kullanıcıdan bir yarıçap değeri alıp yarıçapı r olan dairenin alan ve çevresini
hesaplatan program
*/
import java.util.Scanner;

public class DaireAlanCevreHesaplama 
{
    public static void main(String[] args) 
    {
        double pi = 3.14;
        Scanner oku = new Scanner(System.in);
        System.out.print("Dairein yarı çapını giriniz: ");
        int r = oku.nextInt();
        
        double alan = pi * (r*r);
        double cevre = pi * r;
        
        System.out.printf("%-10s %10.4f\n", "Dairenin alanı: ", alan);
        System.out.printf("%-10s %10.4f\n", "Dairenin çevresi: ", cevre);
    }
}

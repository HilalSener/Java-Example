
import java.util.Scanner;

public class TryCatchVeScannerOrnek 
{
    public static void main(String[] args)
    {
        Scanner oku = new Scanner(System.in);
        
        try
        {
            System.out.print("A sayısı:");
            int a = oku.nextInt();
            System.out.print("B sayısı:");
            int b = oku.nextInt();
            System.out.println("2 sayının toplamı: " + (a+b));
        }
        catch(Exception Hata)
        {
            System.out.println("Sayı girişinde bir hata var. Program durdu!");
        }
        
        System.out.println("Program bitti");
    }
}

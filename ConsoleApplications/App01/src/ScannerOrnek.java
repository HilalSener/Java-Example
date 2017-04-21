
import java.util.Scanner;

public class ScannerOrnek 
{
    public static void main(String[] args) 
    {
        Scanner oku = new Scanner(System.in);
        System.out.print("A sayısı:");
        int a = oku.nextInt();
        System.out.print("B sayısı:");
        int b = oku.nextInt();
        System.out.println("2 sayının toplamı: " + (a+b));
        
        /*
        try ... catch
        Bİr hatayla karşılaşıldığında, yapılacak işlemleri belirtmek için
        ve uygulamanın düzgün şekilde devam etmesi için kullanılır.
        */
    }
}
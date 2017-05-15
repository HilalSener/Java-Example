
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * text file dan sayıları okuyup her türlü matematiksel işlemi yapan program.
 */
public class Soru1 
{
    public static ArrayList<Integer> cift = new ArrayList<>();
    public static ArrayList<Integer> tek = new ArrayList<>();
    public static int toplam = 0;
    public static int carpma = 1;
    public static int total(int sayi)
    {
        toplam += sayi;
        return toplam;
    }
    
    public static int multiplication(int sayi)
    {
        carpma *= sayi;
        return carpma;
    }
    
    public static void main(String[] args) 
    {
        File f = new File("C:\\Users\\HilalSener\\Desktop\\sayilar.txt");
        try 
        {
            Scanner oku = new Scanner(f, "UTF-8");
            while(oku.hasNextInt())
            {
                int okunan = oku.nextInt();
                toplam = total(okunan);
                carpma = multiplication(okunan);
                if(okunan % 2 == 0)
                    cift.add(okunan);
                else
                    tek.add(okunan);
            }
            System.out.println(toplam);
            System.out.println(carpma);
            System.out.println(cift);
            System.out.println(tek);

            oku.close();
        } catch (Exception e) 
        {
            System.out.println("Hata : "+e.toString());
        }
    }
}

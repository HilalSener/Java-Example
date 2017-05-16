
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class App03 
{
    public static File f = new File("C:\\Users\\HilalSener\\Desktop\\sayilar.txt");
    public static ArrayList<Integer> cift = new ArrayList<>();
    public static ArrayList<Integer> tek = new ArrayList<>();
    
    public static void main(String[] args) 
    {
        try 
        {
            Scanner oku = new Scanner(f, "UTF-8");
            while(oku.hasNext())
            {
                int okunan = oku.nextInt();
                if(okunan % 2 == 0)
                {
                    cift.add(okunan);
                }
                else
                {
                    tek.add(okunan);
                }
                
                PrintWriter ciftYaz = new PrintWriter("C:\\Users\\HilalSener\\Desktop\\cift.txt", "UTF-8");
                ciftYaz.println(cift);
                
                PrintWriter tekYaz = new PrintWriter("C:\\Users\\HilalSener\\Desktop\\tek.txt", "UTF-8");
                tekYaz.println(tek);
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}

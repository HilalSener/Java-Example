
import java.io.File;
import java.util.Scanner;

public class DosyaOkuma2
{
    public static void main(String[] args) 
    {
        try
        {
            File f = new File("C:/Users/HilalSener/Desktop/nums.txt");
            int total = 0;
            
            Scanner oku = new Scanner(f, "UTF-8");
            while (oku.hasNextInt())
                total += oku.nextInt();
            
            oku.close();
            System.out.println(total);
        } catch (Exception e) { e.printStackTrace(); }
    }
}

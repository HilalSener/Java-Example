
import java.io.File;
import java.util.Scanner;


public class DosyaOkuma1
{
    public static void main(String[] args)
    {
        File f = new File("C:/Users/HilalSener/Desktop/test.txt");
        try
        {
            Scanner oku = new Scanner(f, "UTF-8");
            
            // Dosyada Okunacak Satır Olduğu Sürece
            while (oku.hasNextLine())
            {
                // Bir Satır Oku
                String line = ""+oku.nextLine();
                System.out.println(line);
            }
            // Dosya Okuyucuyu Kapat
            oku.close();
            
        } 
        catch (Exception e)
        {
            System.out.println("Hata : "+e.toString());
        }
    }
}

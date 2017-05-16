
import java.io.File;
import java.io.PrintWriter;

public class App02 {
    public static void dosyaOlustur()
    {
        File f = new File("C:\\Users\\HilalSener\\Desktop\\sayilar.txt");
        
        try 
        {
            PrintWriter yaz = new PrintWriter(f, "UTF-8");
            for (int i = 0; i < 10000; i++) {
                int r = (int) (1 + Math.random() * 100000);
                yaz.println(r);
            }
            
            yaz.close();
        } catch (Exception e) 
        {
             e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) 
    {
        dosyaOlustur();
    }
}

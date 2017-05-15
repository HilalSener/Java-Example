
import java.io.File;

public class test {
    public static void main(String[] args) 
    {
        File f1 = new File("C:\\Users\\HilalSener\\Desktop\\Hilal\\Sener");
        File f2 = new File(f1, "hello.txt");
        try 
        {
           // boolean varMiF = f1.createNewFile();
            boolean varMiD = f1.mkdirs();
            f2.createNewFile();
        } catch (Exception e) 
        {
            System.out.println("Dosya oluşturma hatası : " + e.toString());
        }
        
        f1.renameTo(f2);
        System.out.println(f1.exists());
    }
}

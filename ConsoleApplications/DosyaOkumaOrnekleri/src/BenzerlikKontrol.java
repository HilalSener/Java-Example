
import java.io.File;
import java.util.Scanner;

public class BenzerlikKontrol 
{
    public static File f1 = new File("dosya1.txt");
    public static File f2 = new File("dosya2.txt");
    public static void main(String[] args) 
    {
        if(!f1.exists() && !f2.exists())
                System.out.println("Kayıt bulunamadı!");
        
        try {
            Scanner oku = new Scanner(f1, "UTF-8");
            Scanner oku2 = new Scanner(f2, "UTF-8");
            int cnt = 0, same = 0;
            
            while(oku.hasNext())
            {
                String okunan = oku.next();
                String okunan2 = oku2.next();
                if(okunan.equals(okunan2))
                {
                    cnt++;
                    same++;
                }
            }
            
            oku.close();
            oku2.close();
            
            double ratio = (same*100.0) / cnt;
            System.out.printf("Benzerlik Orani : %.2f%%n",ratio);
        } 
        catch (Exception e) 
        {
            System.out.println("Hata : "+e.toString());
        }
    }
}

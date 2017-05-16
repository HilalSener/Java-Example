
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
    public static File dataFile = new File("kayit.txt");
    public static ArrayList<Kayit> kL = new ArrayList<>();
    public static void main(String[] args) 
    {
        //Eğer kayit.txt yoksa programı kapat
        if(!dataFile.exists())
        {
            System.out.println("kayit.txt yok");
            return;
        }
        
        
        try 
        {
            //Dosya okuyucuyu aç
            Scanner s = new Scanner(dataFile, "UTF-8");
            //Dosyada okunacak satır olduğu sürece
            while(s.hasNextLine())
            {
                //bir satır veriyi oku
                String rec = s.nextLine();
                //hsener;12345;hilal@mail.com  ---> kayit.txt verisi
                //okuduğun veri ile yeni bir kayıt instance ı oluştur.
                Kayit k = new Kayit(rec);
                //instance ı ArrayList e ekle
                kL.add(k);
            }
            
            s.close();
            System.out.println(kL.size() + " Kayıt yüklendi.");
            for (Kayit rec : kL) {
                System.out.println(rec);
            }
        } catch (Exception e) 
        {
            System.err.println("Dosya okuma hatası: " + e);
        }
    }
}


import java.io.File;
import java.io.PrintWriter;

public class App01 {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\HilalSener\\Desktop\\output.txt");
        
        // PrintWriter, Konsola Veri Yazar Gibi,
        // Bağlandığı Kaynağa Veri Yazmayı Sağlayan Sınıftır

        try 
        {
            //Dosya yazıcıyı aç.
            PrintWriter yaz = new PrintWriter(f, "UTF-8");
            yaz.println("Merhaba");
            for (int i = 0; i < 10; i++) {
                yaz.println(Math.random());
            }
            
            //Dosyayı kaydet ve kapat
            yaz.close();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
}
}

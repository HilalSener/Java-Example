
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Yaz1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f = new File("C:/users/HilalSener/Desktop/java.pdf");
        FileInputStream fis = new FileInputStream(f);
        
        PdfReader reader = new PdfReader(fis);
        PdfDocument doc = new PdfDocument(reader);
        int sayfaSayisi = doc.getNumberOfPages();
        
        //System.out.println("Page Count: " + sayfaSayisi);
        
        for (int i = 1; i <= sayfaSayisi; i++) {
            PdfPage sayfa = doc.getPage(i);
            String yazi = PdfTextExtractor.getTextFromPage(sayfa);
            System.out.println(yazi);
        }
    }
}

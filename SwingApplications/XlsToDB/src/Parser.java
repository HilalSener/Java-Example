
import java.io.File;
import jxl.Sheet;
import jxl.Workbook;


public class Parser {
    public static void main(String[] args) throws Exception{
        DB db = new DB();
        
        File f = new File("C:/Users/HilalSener/Desktop/data.xls");
        Workbook wb = Workbook.getWorkbook(f);
        
        Sheet sayfa1 = wb.getSheet(0);
        StringBuilder sb = new StringBuilder();
        String tabloAdi = sayfa1.getName();
        
        sb.append("create table if not exists " + tabloAdi + "(");
        
        //Her bir satır için
        for (int i = 0; i < sayfa1.getRows(); i++) {
            //Her bir kolon için
            for (int j = 0; j < sayfa1.getColumns(); j++) {
                sayfa1.getCell(j, i).getContents();
            }
        }
    }
}

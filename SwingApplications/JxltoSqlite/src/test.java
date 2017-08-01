
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class test {
    Connection c;
    Statement s;
    ResultSet rs;
    
    String conn = "jdbc:sqlite://C:/Users/HilalSener/Desktop/Deneme.db";
    
    public static File f = new File("C:/Users/HilalSener/Desktop/data.xls");
        
    public static Workbook wb;
    public test() throws Exception
    {
        Class.forName("org.sqlite.JDBC");
        
        c = DriverManager.getConnection(conn);
        System.out.println("Veritabanı açıldı.");
    }
    
    public void createDB() throws Exception
    {
        wb = Workbook.getWorkbook(f);
        Sheet sayfa = wb.getSheet(0);
        String table= "";
        for (int i = 0; i < sayfa.getRows(); i++) {
            for (int j = 0; j < sayfa.getColumns(); j++) {
                Cell cell = sayfa.getCell(j,i); //(column, row)
                table += cell.getContents().trim() + " ";
            }
            if(sayfa.getRows() != i + 1)
            {
                table += ",";
            }
            else
                table += " ";
        }
        
        String comm = String.format("create table Kisiler (" + table + ")");
        System.out.println(comm);
        s = c.createStatement();
        s.execute(comm);
    }
    
    public static void main(String[] args) throws Exception
    {
        test t = new test();
        t.createDB();
        
        /*
        wb = Workbook.getWorkbook(f);
        Sheet sayfa = wb.getSheet(1);
        System.out.println("Sayfa Adı: " + sayfa.getName());
        
        for (int i = 0; i < sayfa.getRows(); i++) {
            for (int j = 0; j < sayfa.getColumns(); j++) {
                Cell c = sayfa.getCell(j,i); //(column, row)
                System.out.println(c.getContents());
            }
        }
        */
    }
}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    Connection c;
    Statement s;
    ResultSet rs;
    String cs = "jdbc:sqlite://C:/Users/HilalSener/Desktop/Test.db";
    
    public int id;
    public String filmAd;
    public String tur;
    public int sure;
    public int imdb;
    
    public DBConnection() throws Exception
    {
        Class.forName("org.sqlite.JDBC");
        
        c = DriverManager.getConnection(cs);
    }
    
    public ResultSet getMovies() throws Exception
    {
        s = c.createStatement();
        rs = s.executeQuery("select * from Filmler");
        
        return rs;
    }
    
    public ResultSet getMovie(int id) throws Exception
    {
        s = c.createStatement();
        rs = s.executeQuery("select * from Filmler where id = " + id);
        
        return rs;
    }
    
    public void addMovie(int id, String filmAd, String tur, int sure, int imdb) throws Exception
    {
        s = c.createStatement();
        String sql = String.format("insert into Filmler(id, filmAd, tur, sure, imdb) "
                + "values (%d, '%s', '%s', %d, %d);", id, filmAd, tur, sure, imdb);
        System.out.println(sql);
        
        s.execute(sql);
    }
    
    public void delMovie(int id) throws Exception
    {
        s = c.createStatement();
        s.execute("delete from Filmler where id = " + id);
    }
}

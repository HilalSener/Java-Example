import java.sql.*;

public class DB {
    public String conn = "jdbc:/sqlite://TEST.DB";
    Connection c;
    
    public DB() throws Exception
    {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection(conn);
    }
    
    public void g(String sql) throws Exception
    {
        System.out.println("SQL: " + sql);
        c.createStatement().execute(sql);
    }
}

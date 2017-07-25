
package render;

import java.sql.*;

public class DB 
{
    Connection c;
    
    public DB() throws Exception
    {
        Class.forName("org.gjt.mm.mysql.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost/pastie", "root", "");
    }
    
    public void execute(String sql) throws Exception
    {
        Statement s = c.createStatement();
        s.closeOnCompletion();
        s.execute(sql);
        s.close();
    }
    
    public ResultSet query(String sql) throws Exception
    {
        Statement s = c.createStatement();
        s.closeOnCompletion();
        ResultSet rs = s.executeQuery(sql);
        return rs;
    }
}

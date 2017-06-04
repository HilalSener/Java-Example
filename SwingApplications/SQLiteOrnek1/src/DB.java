/*
    Bir veritabanına bağlanırken, Javanın sağladığı sql sınıfını kullanın.
*/

import java.sql.*;

public class DB 
{
    //Veritabanı bağlantısını açan instance
    Connection c;
    
    //Veritabanında bir sorgu çalıştırmanızı sağlayan instance
    Statement s;
    
    //Statement ile çalıştırılmış geriye veri dönen bir sorgu(Pragma, select)
    //Sonucunda gelen datayı tutan instance
    ResultSet rs;
    
    //Bağlantı özelliklerini tanımlayan Connection String
    String cS= "jdbc:sqlite://C:/Users/HilalSener/Desktop/Test.db";
    
    public DB() throws Exception
    {
        //SQLite kütüphanesinde driver sınıfını belleğe yükle
        Class.forName("org.sqlite.JDBC");
        
        //Veritabanı bağlantısını aç
        c = DriverManager.getConnection(cS);
        System.out.println("Veritabanı açıldı.");
    }
    
    //Veritabanına kişi eklemek için method
    public void addKisi(String ad) throws Exception
    {
        //Bağlantı üzerinden bir statement oluştur
        s = c.createStatement();
        //insert into kisi(ad) values('Emre');
        String sql = String.format("insert into kisi(ad) values('%s');", ad);
        System.out.println("SQL: " + sql);
        
        //Açılan statement Instance' ı ile bu sorguyu veritabanında çalıştır.
        s.execute(sql);
    }
    
    public void delKisi(int id) throws Exception
    {
        s = c.createStatement();
        s.execute("delete from kisi where id =" + id);
    }
    
    public void updateKisi(int id, String ad) throws Exception
    {
        //update kisi set ad = 'Can' where id = 12;
        String sql = String.format("update kisi set ad = '%s' where id = %d", ad, id);
        
        System.out.println("SQL: " + sql);
        s = c.createStatement();
        s.execute(sql);
    }
    
    public ResultSet getKisiler() throws Exception
    {
        //return c.createStatement().executeQuery("select * from Kisi");
        s = c.createStatement();
        rs = s.executeQuery("select * from Kisi");
        
        return rs;
    }
    
    public ResultSet getKisi(int id) throws Exception
    {
        s = c.createStatement();
        rs = s.executeQuery("select * from Kisi where id =" + id);
        return rs;
    }
    
    public static void main(String[] args) throws Exception {
        DB db = new DB();
        
        //db.addKisi("Gökhan");
        //db.delKisi(1);
        //db.updateKisi(5, "Hilal");
        ResultSet sonuc = db.getKisiler();
        
        //ResultSet teki sonuçları dolaş
        while(sonuc.next())
        {
            //1. kolonun değerini int olarak al
            int id = sonuc.getInt("id");
            //Adı ad olan kolonun değerini String olarak al
            String ad = sonuc.getString("ad");
            System.out.println(id + " - " + ad);
        }
        
        ResultSet rs = db.getKisi(3);
        while(rs.next())
        {
            System.out.println(rs.getString("id") + " - " + rs.getString("ad"));
        }
        
        /*
            ResultSet' in yapısına erişebildiğimiz Nesne: ResultSetMetaData' dır.
        */
        
       rs = db.getKisiler();
       ResultSetMetaData md = rs.getMetaData();
       int donenKolonSayisi = md.getColumnCount();
       System.out.println("MetaData --> " + donenKolonSayisi + " Kolon");
       for (int i = 0; i < donenKolonSayisi; i++)
       {
           String kolonAdi = md.getColumnLabel(i + 1);
           int tip = md.getColumnType(i + 1);
           System.out.println("Kolon #" + i + " --> " + kolonAdi + " Tür: " + tip);
       }
    }
}

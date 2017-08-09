package emircivas.sqliterehber;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper
{
    SQLiteDatabase db;

    // /data/data/emircivas.sqliterehber/databases/mydb.db
    public DB(Context c)
    {
        // Context,
        // Veritabanı Dosyası Yolu
        // CursorFactory null
        // Veritabanı Versionu (STD 3)
        super(c,
              c.getDatabasePath("test.db").getAbsolutePath(),
              null,
              3);

        // DB'yi Aç Kapat
        getWritableDatabase().close();
    }

    public ArrayList<ContentValues> get(String tabloAdi)
    {
        String sql  ="select * from "+tabloAdi;
        ArrayList<ContentValues> al = new ArrayList<>();
        db = getWritableDatabase();
        Cursor c  = db.rawQuery(sql, null);
        int colCnt =  c.getColumnCount();
        String kolonAdlari[] = c.getColumnNames();

        while (c.moveToNext())
        {
            ContentValues cv = new ContentValues();
            for (int i = 0; i<kolonAdlari.length; i++)
                cv.put(kolonAdlari[i], c.getString(i));

            al.add(cv);
        }

        c.close();
        db.close();
        return al;

    }

    public ArrayList<Kisi> getKisiler()
    {
        db = getWritableDatabase();
        ArrayList<Kisi> al = new ArrayList<>();
        Cursor c = db.rawQuery("select * from kisiler", null);
        while (c.moveToNext())
        {
            Kisi k = new Kisi(c);
            al.add(k);
        }
        c.close();
        db.close();
        return al;
    }

    public ContentValues getKisi(String id)
    {
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();

            Cursor c = db
                    .rawQuery("select * from kisiler where "+
                          "id = "+id, null);

            while (c.moveToNext())
            {
                cv.put("id", c.getInt(0));
                cv.put("ad", c.getString(1));
                cv.put("soyad", c.getString(2));
                cv.put("tel", c.getString(3));
            }

            c.close(); // Cursor KAPANACAK!
        db.close();
        return cv;
    }

    public void addKisi(String ad, String soyad, String tel)
    {
        // 1 DB'yi AÇ
        db = getWritableDatabase();
        String sql = "insert into kisiler (ad,soyad,tel) values ('%s', '%s', '%s')";
        sql = String.format(sql, ad, soyad, tel);

        Log.e("x","INS : "+sql);
        db.execSQL(sql);

        // DB'yi Kapat
        db.close();
    }

    public void delKisi(String id)
    {
        db = getWritableDatabase();
        String sql  ="delete from kisiler where id = "+id;
        Log.e("x","DEL : "+sql);
        db.execSQL(sql);
        db.close();
    }

    public void updKisi(String id, String ad, String soyad, String tel)
    {
        db  =getWritableDatabase();
        Object[] fields = {ad, soyad, tel, id};
        String sql  = "update kisiler set ad  = ?, soyad = ?, "+
                      "tel = ? where id = ?";
        db.execSQL(sql, fields);
        Log.e("x","UPD : "+sql);
        db.close();
    }

    // Uygulama Ilk Calistiginda, DB Olusturmak Icin
    // Kullanilan Method
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        Log.e("x","DB::onCreate Calisti");

        // id, ad, soyad, tel;
        String sql = "create table kisiler ("+
                     "id integer primary key autoincrement, "+
                     "ad text,"+
                     "soyad text, "+
                     "tel text );";

        Log.e("x","SQL : "+sql);

        sqLiteDatabase.execSQL(sql);
    }
    // Guncelleme Yaptiginda Calisir
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                          int oldVersion, int newVersion)
    {

    }
}

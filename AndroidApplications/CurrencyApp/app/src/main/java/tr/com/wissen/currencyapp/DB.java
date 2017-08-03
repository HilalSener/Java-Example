package tr.com.wissen.currencyapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB extends SQLiteOpenHelper
{
    SQLiteDatabase db;

    public DB(Context c) {
        super(c,c.getDatabasePath("currency.db").getAbsolutePath(), null, 3);

        getWritableDatabase().close();
    }

    public void addCurrency(CharSequence code, CharSequence currency, CharSequence buying, CharSequence selling)
    {
        // 1 DB'yi AÇ
        db = getWritableDatabase();
        String sql = "insert into kurlar (code,currency, buying, selling) values ('%s', '%s', '%s', '%s')";
        sql = String.format(sql, code, currency, buying, selling);

        Log.e("x","INS : "+sql);
        db.execSQL(sql);

        // DB'yi Kapat
        db.close();
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("x","DB::onCreate Calisti");

        String sql = "create table kurlar ("+
                "id integer primary key autoincrement, "+
                "code text,"+
                "currency text, "+
                "buying text, "+
                "selling text );";

        Log.e("x","SQL : "+sql);

        sqLiteDatabase.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

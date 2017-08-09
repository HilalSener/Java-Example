package emircivas.sqliterehber;

import android.database.Cursor;

public class Kisi
{
    public int id;
    public String ad, soyad, tel;

    public Kisi(Cursor c)
    {
        id = c.getInt(0);
        ad = c.getString(1);
        soyad = c.getString(2);
        tel = c.getString(3);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

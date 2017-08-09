package tr.com.wissen.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Shared Preferences uygulamanız içerisnde kullanılan küçük verileri
 * key value şeklinde tutmanızı sağlayan ve bunları uygulamanın özel klasörü altında
 * Bir xml de tutan bir yapıdır.
 */

public class SharedPrefs {
    //xml dosyasını okumak için
    SharedPreferences sp;

    //xml dosyasına veri yazmak için
    SharedPreferences.Editor edit;

    public SharedPrefs(Context c)
    {
        //XML okuyucuyu aç
        sp = PreferenceManager.getDefaultSharedPreferences(c);

        //XML yazıcıyı aç
        edit = sp.edit();
    }

    public int getAcilisSayisi()
    {
        //XML de açılış count altındaki integer sayıyı getir
        //Eğer böyle bir anahtar yoksa 1 değerini getir
        int cnt = sp.getInt("acilis_cnt", 1);
        return cnt;
    }

    public void incAcilisSayisi()
    {
        int curr = getAcilisSayisi();
        edit.putInt("acilis_cnt", curr+1);
        edit.commit();
    }
}

package tr.com.wissen.listviewwithjson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //DATASOURCE
    JSONArray dS = new JSONArray();

    ListView lv;
    LayoutInflater li;
    BaseAdapter ba;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        li = LayoutInflater.from(MainActivity.this);
        lv = (ListView)findViewById(R.id.lv);

        ba = new BaseAdapter() {

            public int getCount() { return dS.length(); }


            public Object getItem(int i) { return null; }


            public long getItemId(int i) { return 0; }


            public View getView(int i, View view, ViewGroup viewGroup) {
                if(view == null) view = li.inflate(R.layout.urun, null);

                TextView tvAd = (TextView)view.findViewById(R.id.urun_adi);
                TextView tvFiyat = (TextView) view.findViewById(R.id.urun_fiyati);
                ImageView iv = (ImageView) view.findViewById(R.id.urun_resim);

                try {
                    JSONObject jo = dS.getJSONObject(i);
                    tvAd.setText(jo.getString("ad"));
                    tvFiyat.setText(jo.getString("fiyat"));
                    String resimURL = jo.getString("url");
                    Picasso.with(MainActivity.this).load(resimURL).into(iv);
                }
                catch (Exception e) { Log.e("x", "Err: " + e);}

                return view;
            }
        };

        lv.setAdapter(ba);

        fetchData();
    }

    public void fetchData()
    {
        new AsyncTask<String, String, String>()
        {
            protected String doInBackground(String... strings) {
                try {
                    String jsonStr = Jsoup
                            .connect("http://connect.reeder.com.tr/service.php")
                            .timeout(30000)
                            .ignoreContentType(true)
                            .userAgent("Mozilla")
                            .get().text().trim();

                    dS = new JSONArray(jsonStr);
                    Log.e("x", "Urun Sayısı: " +dS.length());
                }
                catch (Exception e){ Log.e("x", "Data Fetch Error: " + e);}
                return  null;
            }

            protected void onPostExecute(String s) {
                ba.notifyDataSetChanged();
            }
        }.execute();
    }
}

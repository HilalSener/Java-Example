package tr.com.wissen.dhrss;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    LayoutInflater li;
    BaseAdapter ba;
    SwipeRefreshLayout srl;
    Elements dS = new Elements();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        srl = (SwipeRefreshLayout)findViewById(R.id.srl);

        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                fetchData();
            }
        });

        lv = (ListView)findViewById(R.id.lv);
        li = LayoutInflater.from(MainActivity.this);
        ba = new BaseAdapter() {
            public int getCount() { return dS.size(); }

            public Object getItem(int i) {
                return null;
            }

            public long getItemId(int i) {
                return 0;
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                if(view == null) view = li.inflate(R.layout.haber, null);
                TextView t = (TextView)view.findViewById(R.id.baslik);
                ImageView iv = (ImageView)view.findViewById(R.id.logo);

                t.setText(dS.get(i).select("title").text());

                String resimURL = dS.get(i).select("enclosure").attr("url");

                Picasso.with(MainActivity.this)
                        .load(resimURL)
                        .into(iv);

                return  view;
            }
        };

        lv.setAdapter(ba);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String haberLinki = dS.get(i).select("guid").text();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(haberLinki));
                startActivity(intent);
                //startActivity(Intent.createChooser(intent, "Birlikte  Aç"));

            }
        });

        fetchData();
    }

    public void  fetchData()
    {
        new AsyncTask<String, String, String>()
        {
            protected String doInBackground(String... strings) {
                try {
                    dS = Jsoup
                            .connect("http://donanimhaber.com/rss/tum/")
                            .timeout(30000)
                            .userAgent("Mozilla")
                            .get().select("item");

                    Log.e("x", "Haber sayısı: " + dS.size());
                }
                catch (Exception e) { Log.e("x", "Err: " +e); }
                return null;
            }

            protected void onPostExecute(String s) {
                ba.notifyDataSetChanged();
                srl.setRefreshing(false);
            }
        }.execute();
    }
}

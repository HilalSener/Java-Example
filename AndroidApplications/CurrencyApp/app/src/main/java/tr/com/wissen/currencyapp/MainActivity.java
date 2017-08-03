package tr.com.wissen.currencyapp;

import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

        //int screenWitdth = getWindowManager().getDefaultDisplay().getWidth();
        lv = (ListView)findViewById(R.id.lv);
        li = LayoutInflater.from(MainActivity.this);
        ba = new BaseAdapter() {
            public int getCount() { return dS.size(); }

            public Object getItem(int i) { return null; }

            public long getItemId(int i) { return 0; }

            public View getView(int i, View view, ViewGroup viewGroup) {
                if(view == null)
                    view = li.inflate(R.layout.currency, null);

                TextView tcode = (TextView)view.findViewById(R.id.code);
                TextView tcurrency = (TextView)view.findViewById(R.id.currency);
                TextView tbuying = (TextView)view.findViewById(R.id.buying);
                TextView tselling = (TextView)view.findViewById(R.id.selling);

                if(tcode.getText() != "" && tcurrency.getText() != "" && tbuying.getText() != "" && tselling.getText() != "")
                {
                    tcode.setText(dS.get(i).select("Currency").attr("CurrencyCode"));
                    tcurrency.setText(dS.get(i).select("Isim").text());
                    tbuying.setText(dS.get(i).select("ForexBuying").text());
                    tbuying.setText(dS.get(i).select("ForexSelling").text());
                }

                DB db = new DB(MainActivity.this);
                db.addCurrency(tcode.getText(), tcurrency.getText(), tbuying.getText(), tselling.getText());

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
                    dS = Jsoup
                            .connect("http://tcmb.gov.tr/kurlar/today.xml")
                            .timeout(30000)
                            .userAgent("Mozilla")
                            .get().select("Currency");

                    Log.e("x", "Kur sayısı: " + dS.size());
                }
                catch (Exception e) { Log.e("x", "Err: " + e);}
                return null;
            }

            protected void onPostExecute(String s) {
                ba.notifyDataSetChanged();
                srl.setRefreshing(false);
            }
        }.execute();
    }
}

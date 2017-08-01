package tr.com.wissen.listview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class LVWithBaseAdapter extends AppCompatActivity{
    ListView lv;
    String data[][] = new String[100][3];
    String img1 = "https://cdn1.iconfinder.com/data/icons/android-ui/154/android-settings-128.png";
    String img2 = "https://cdn0.iconfinder.com/data/icons/Android-R2-png/128/Settings-Android-R.png";
    String img3 = "http://icons.iconarchive.com/icons/dtafalonso/android-l/128/Play-Games-icon.png";

    BaseAdapter ba;

    LayoutInflater li;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);

        li = LayoutInflater.from(LVWithBaseAdapter.this);

        for (int i = 0; i < 100; i++)
        {
            String img = "";

            if(i >= 0 && i <=33)
                img = img1;

            if (i >= 33 && i <= 66)
                img = img2;

            if (i >= 66 && i < 100)
                img = img3;

            data[i] = new String[]{"Kisi" + i, "Mail" + i, img};
        }

        ba = new BaseAdapter() {
            // Listede Kaç Item Gösterilecek
            @Override
            public int getCount() {
                return data.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                if(view == null)
                {
                    Log.e("x","ListView Yeni Olusturuluyor, View Bos Geldi");
                    view = li.inflate(R.layout.item, null);
                }
                else
                {
                    Log.e("x","Daha Onceden Olusturulmus Bir View Geldi");
                }

                TextView tv1 = (TextView) view.findViewById(R.id.item_baslik);
                TextView tv2 = (TextView) view.findViewById(R.id.item_aciklama);

                tv1.setText(data[i][0]);
                tv2.setText(data[i][1]);

                ImageView iv = (ImageView)view.findViewById(R.id.item_logo);
                Picasso.with(LVWithBaseAdapter.this)
                        .load(data[i][2])
                        .into(iv);

                return view;
            }
        };

        lv.setAdapter(ba);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                String kayit[]= data[i];
                data[i][1] += " Seçildi";
                // Listeyi Değişiklikten Sonra Yenile
                ba.notifyDataSetChanged();
                Log.e("x","Tıklanan : "+kayit[0]+" "+kayit[1]);

            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("x","LongClicked @"+i);

                // İşlem Dialogu Goster
                AlertDialog.Builder adb = new AlertDialog.Builder(LVWithBaseAdapter.this);
                adb.setTitle("Ne Yapılsın");
                adb.setMessage("Yapılacak İşlemi Seçin");
                adb.setPositiveButton("Sil", null);
                adb.setNegativeButton("Güncelle", null);
                adb.show();

                return true;
            }
        });
    }
}

package emircivas.sqliterehber;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener
{
    DB db;
    ArrayList<Kisi> dS = new ArrayList<>();
    ListView lv;
    LayoutInflater li;
    BaseAdapter ba;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DB(MainActivity.this);
        li = LayoutInflater.from(MainActivity.this);
        lv = (ListView) findViewById(R.id.lv);
        ba = new BaseAdapter() {
            @Override
            public int getCount() {
                return dS.size();
            }

            @Override
            public Object getItem(int i) {
                return dS.get(i);
            }

            @Override
            public long getItemId(int i)
            {
                return dS.get(i).id;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup)
            {
                if (view == null)
                    view = li.inflate(R.layout.kisi_item, null);

                TextView tvAd = (TextView) view.findViewById(R.id.tvAd);
                TextView tvId = (TextView) view.findViewById(R.id.tvId);
                TextView tvTel= (TextView) view.findViewById(R.id.tvTel);
                Kisi k = dS.get(i);
                tvAd.setText(k.ad+" "+k.soyad);
                tvId.setText(""+k.id);
                tvTel.setText(k.tel);

                return view;
            }
        };
        lv.setAdapter(ba);

        lv.setOnItemLongClickListener(MainActivity.this);
        lv.setOnItemClickListener(MainActivity.this);

    }


    protected void onResume()
    {
        super.onResume();
        dS = db.getKisiler();
        ba.notifyDataSetChanged();

        lv.setVisibility(dS.isEmpty() ? View.GONE : View.VISIBLE);
    }


    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add("Ekle")
                .setIcon(android.R.drawable.ic_menu_add)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        String ad = ""+item.getTitle();
        if (ad.equals("Ekle"))
            startActivity(new Intent(MainActivity.this, Ekle.class));
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l)
    {
        // OPT 1
        final int id = dS.get(pos).id;
/*
        // OPT 2
        Kisi k = (Kisi) ba.getItem(pos);
        id = k.id;

        // OPT 3
        id = (int) l;
*/
        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        adb.setTitle("Silme Onayı")
                .setMessage("Emin misiniz ?")
                .setNegativeButton("Hayır",  null)
                .setPositiveButton("Evet", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                          db.delKisi(""+id);
                        dialogInterface.dismiss();
                        onResume();
                    }
                });

        adb.show();
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int id = dS.get(i).id;
        Intent intent = new Intent(MainActivity.this, Duzenle.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}

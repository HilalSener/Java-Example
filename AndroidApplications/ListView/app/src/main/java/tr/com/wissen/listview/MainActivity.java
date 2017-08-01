package tr.com.wissen.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String kisiler[] = new String[10000];
    ListView lv;

    LayoutInflater li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i<10000; i++)
            kisiler[i] = "" + Math.random();

        lv = (ListView)findViewById(R.id.lv);

        ArrayAdapter<String> aa = new ArrayAdapter<String>
                (
                  MainActivity.this,
                  android.R.layout.simple_list_item_1,
                  android.R.id.text1,
                  kisiler
                );

        lv.setAdapter(aa);
    }
}

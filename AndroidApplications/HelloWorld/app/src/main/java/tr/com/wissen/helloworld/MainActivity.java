package tr.com.wissen.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ekranda hangi layout xml gösterilecek
        setContentView(R.layout.activity_main);
        Log.e("Hello World", "onCreate çalıştı");

        //xml den id si etAd olan view ı buraya bir EditText Instance ı olarak çek
        et = (EditText) findViewById(R.id.etAd);

    }

    //onStart metodu, onCreate ten sonra çalışan metoddur
    protected void onStart()
    {
        super.onStart();
        Log.e("Hello World", "onStart çalıştı");
    }

    //onResume metodu, onStart tan sonra çalışan metoddur.
    protected void onResume()
    {
        super.onResume();
        Log.e("Hello World", "onResume çalıştı");
    }

    //onPause uygulama durdurulurken ilk çalışan metoddur.
    protected void onPause() {
        super.onPause();
        Log.e("Hello World", "onPause çalıştı");
    }

    //onStop metodu onResume dan sonra çalışır
    protected void onStop() {
        super.onStop();
        Log.e("Hello World", "onStop çalıştı");
    }

    //onDestroy uygulama tamamen kapatılırken çalışır
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Hello World", "onDestroy çalıştı");
    }

    //menü seçenekleri oluşturmak için onCreateOptionsMenu methodu override edilir
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("About Us")
                .setIcon(R.drawable.info)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        menu.add("Exit")
                .setIcon(R.drawable.icon)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        String ad = item.getTitle().toString();
        if(ad.equals("About Us"))
        {
            //Uyarı Metni Goster
            Toast.makeText(MainActivity.this, "About Us :)", Toast.LENGTH_SHORT).show();
        }
        if(ad.equals("Exit"))
        {
            //Activity i kapat
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void islemYap(View view) {
    }
}

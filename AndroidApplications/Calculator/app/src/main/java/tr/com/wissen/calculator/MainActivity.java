package tr.com.wissen.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText s1, s2, sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = (EditText)findViewById(R.id.sayi1);
        s2 = (EditText)findViewById(R.id.sayi2);
        sonuc = (EditText)findViewById(R.id.txtsonuc);
    }

    public void topla(View view) {
        int sayi1 = Integer.parseInt(s1.getText().toString());
        int sayi2 = Integer.parseInt(s2.getText().toString());

        sonuc.setText((sayi1 + sayi2) + "");
    }

    public void cikart(View view) {
        int sayi1 = Integer.parseInt(s1.getText().toString());
        int sayi2 = Integer.parseInt(s2.getText().toString());

        sonuc.setText((sayi1 - sayi2) + "");
    }

    public void carp(View view) {
        int sayi1 = Integer.parseInt(s1.getText().toString());
        int sayi2 = Integer.parseInt(s2.getText().toString());

        sonuc.setText((sayi1 * sayi2) + "");
    }

    public void bol(View view) {
        int sayi1 = Integer.parseInt(s1.getText().toString());
        int sayi2 = Integer.parseInt(s2.getText().toString());

        if(sayi2 != 0)
            sonuc.setText((sayi1 / sayi2) + "");
        else
            Toast.makeText(MainActivity.this, "Sıfıra bölünemez", Toast.LENGTH_SHORT).show();
    }
}

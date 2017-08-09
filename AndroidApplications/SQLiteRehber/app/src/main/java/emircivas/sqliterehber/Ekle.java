package emircivas.sqliterehber;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Ekle extends AppCompatActivity {

    EditText etAd, etSoyad, etTel;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);

        etAd = (EditText) findViewById(R.id.tvAd);
        etSoyad = (EditText) findViewById(R.id.tvSoyad);
        etTel = (EditText) findViewById(R.id.tvTel);

        // ALERT DIALOG : http://paste.ubuntu.com/25225257/
    }

    public void doOp(View view)
    {
        String ad = etAd.getText().toString();
        String soyad = etSoyad.getText().toString();
        String tel = etTel.getText().toString();

        if (ad.isEmpty() || soyad.isEmpty() || tel.isEmpty())
        {
            Toast.makeText(Ekle.this, "Bilgiler Eksik",
                    Toast.LENGTH_SHORT) .show();
            return;
        }

        DB db = new DB(Ekle.this);
        db.addKisi(ad, soyad, tel);
        finish();
    }
}

package emircivas.sqliterehber;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Duzenle extends AppCompatActivity {

    EditText etAd, etSoyad, etTel;
    int recId = 0;
    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duzenle);

        etAd = (EditText) findViewById(R.id.tvAd);
        etSoyad = (EditText) findViewById(R.id.tvSoyad);
        etTel = (EditText) findViewById(R.id.tvTel);
        db = new DB(Duzenle.this);

        recId = getIntent().getExtras().getInt("id");

        ContentValues cv = db.getKisi(""+recId);

        etAd.setText(cv.getAsString("ad"));
        etSoyad.setText(cv.getAsString("soyad"));
        etTel.setText(cv.getAsString("tel"));
    }

    public void doOp(View view)
    {
        String ad = etAd.getText().toString();
        String soyad = etSoyad.getText().toString();
        String tel = etTel.getText().toString();

        if (ad.isEmpty() || soyad.isEmpty() || tel.isEmpty())
        {
            Toast.makeText(Duzenle.this, "Bilgiler Eksik",
                    Toast.LENGTH_SHORT) .show();
            return;
        }

        db.updKisi(""+recId, ad, soyad, tel);
        finish();
    }
}

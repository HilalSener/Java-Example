package emircivas.googlesearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity
{

    EditText et;
    RadioGroup rg;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et);
        rg = (RadioGroup) findViewById(R.id.rg);
    }

    public void doSearch(View view)
    {
        /*
https://www.google.com.tr/search?source=lnms&q=numan
https://www.google.com.tr/search?source=lnms&q=numan&tbm=vid
https://www.google.com.tr/search?source=lnms&q=numan&tbm=isch
https://www.google.com.tr/search?source=lnms&q=numan&tbm=nws
         */
        String val = et.getText().toString();
        String adr = "https://www.google.com.tr/search?source=lnms&q=";
        if (val.isEmpty())      return;


        int secilenRBId = rg.getCheckedRadioButtonId();
        if (secilenRBId == R.id.rbTumu)     adr += val;
        if (secilenRBId == R.id.rbResim)    adr += val+"&tbm=isch";
        if (secilenRBId == R.id.rbVideo)    adr += val+"&tbm=vid";
        if (secilenRBId == R.id.rbHaber)    adr += val+"&tbm=nws";

        Intent i = new Intent(MainActivity.this, WebGoster.class);
        i.putExtra("acilacak_adres", adr);
        startActivity(i);

    }
}

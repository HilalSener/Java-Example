package tr.com.wissen.imageviewwithpicasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String adr = "https://s-media-cache-ak0.pinimg.com/originals/bb/12/a5/bb12a58e87a4ff662b13903a197dce64.jpg";
        ImageView iv = (ImageView)findViewById(R.id.iv);

        Picasso.with(MainActivity.this)
                .load(adr)
                .placeholder(android.R.drawable.ic_menu_info_details)
                .error(android.R.drawable.ic_delete)
                .into(iv);
    }
}

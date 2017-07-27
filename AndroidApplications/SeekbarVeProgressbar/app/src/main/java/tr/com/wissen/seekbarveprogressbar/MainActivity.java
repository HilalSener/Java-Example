package tr.com.wissen.seekbarveprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;
    SeekBar sb;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar)findViewById(R.id.pb);
        //progress bar stil i değiştir
        sb = (SeekBar)findViewById(R.id.sb);
        tv = (TextView)findViewById(R.id.tv);

        // Progress Ve SeekBar2ın Max Değerini Ata
        pb.setMax(100);
        sb.setMax(100);

        // SeekBar'a Change Listener Ata
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * SeekBar Değeri Her Değiştirildiğinde
             * Bu Method Çalışır
             * @param seekBar SeekBar
             * @param i Yeni Değer
             * @param b Bu Değişiklik Kullanıcı Tarafından Mı Yapıldı
             */
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv.setText("" + i);
                pb.setProgress(i);
            }

            /**
             * SeekBar Değerini Değiştirmek İçin
             * Parmağımızla İlk Bastığımız An
             * @param seekBar
             */
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "On Start Tracking", Toast.LENGTH_SHORT).show();
            }

            /**
             * SeekBar Değerini Değiştirdikten Sonra
             * Parmağımızı SeekBar'dan Çektiğimiz An
             * @param seekBar
             */
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "On Stop Tracking", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void doOp(View view) {
        int curr = pb.getProgress();
        Toast.makeText(MainActivity.this, "Curr val:"+curr, Toast.LENGTH_SHORT).show();
    }

    public void doOp2(View view) {
        int r = (int)(Math.random()*sb.getMax());
        sb.setProgress(r);
    }
}

package emircivas.googlesearch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebGoster extends AppCompatActivity
{
    String lastURL = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView web = new WebView(WebGoster.this);
        setContentView(web);

        web.getSettings().setJavaScriptEnabled(true);

        web.setWebViewClient(new WebViewClient()
        {
            public void onPageFinished(WebView view, String url)
            {
                Log.e("x","Yükleme Tamamlandı : "+url);
                lastURL = url;
            }
        });

        String adres = getIntent().getExtras().getString("acilacak_adres");
        web.loadUrl(adres);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Paylas")
                .setIcon(android.R.drawable.ic_menu_share)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String ad = ""+item.getTitle();
        if (ad.equals("Paylas"))
        {
            String fbUrl = "https://www.facebook.com/sharer/sharer.php?u="+lastURL;
            Intent fbI = new Intent(Intent.ACTION_VIEW, Uri.parse(fbUrl));
            startActivity(fbI);
        }
        return super.onOptionsItemSelected(item);
    }
}

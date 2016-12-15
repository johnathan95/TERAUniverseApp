package com.example.johna.terauniverse.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.johna.terauniverse.R;

public class FBActivity extends AppCompatActivity {
    private WebView myWebView;
    private Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("FBActivity.onStart");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);
        myToolbar = (Toolbar) findViewById(R.id.toolbar3);

        myWebView = (WebView) findViewById(R.id.webviewFB);
        myWebView.setWebViewClient(new MyBrowser());

        myWebView.getSettings().setLoadsImagesAutomatically(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        Intent intent = getIntent();
        switch (intent.getIntExtra(MainActivity.EXTRA_TERA, MainActivity.DEFAULT_SIZE)) {
            case MainActivity.TERA_FB:
                myWebView.loadUrl("https://facebook.com/TeraUniverse");
                myToolbar.setLogo(R.drawable.btn_fb);
                myToolbar.setTitle(R.string.m_facebook);
                break;
            case MainActivity.TERA_INSTA:
                myWebView.loadUrl("http://instagram.com/tera_universe");
                myToolbar.setLogo(R.drawable.btn_insta);
                myToolbar.setTitle(R.string.m_instagram);
                break;
            case MainActivity.TERA_WEB:
                myWebView.loadUrl("https://www.tera-universe - wixsite.com");
                myToolbar.setLogo(R.drawable.btn_web);
                myToolbar.setTitle(R.string.m_web);
                break;
            case MainActivity.TERA_TWITTER:
                myWebView.loadUrl("http://twitter.com/universe_tera");
                myToolbar.setLogo(R.drawable.btn_twitter);
                myToolbar.setTitle(R.string.m_twitter);
                break;
            default:
                myWebView.loadUrl("null");
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

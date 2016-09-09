package com.songdongwan.progresswebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {


private ProgressBar progressbar;
private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressbar= (ProgressBar) findViewById(R.id.myProgressBar);
        webView= (WebView) findViewById(R.id.myWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                if (newProgress == 100) {
                    progressbar.setVisibility(View.INVISIBLE);
                    progressbar.setVisibility(View.GONE);
                } else {
                    if (View.INVISIBLE == progressbar.getVisibility()) {
                        progressbar.setVisibility(View.VISIBLE);
                    }
                    progressbar.setProgress(newProgress);
                }

                super.onProgressChanged(view, newProgress);


            }
        });

        webView.loadUrl("https://sdongwan.github.io");


    }
}

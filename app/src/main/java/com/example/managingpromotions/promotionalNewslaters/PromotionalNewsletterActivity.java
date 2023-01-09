package com.example.managingpromotions.promotionalNewslaters;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.managingpromotions.R;

public class PromotionalNewsletterActivity extends AppCompatActivity {

    private static final String URL_ELECLERC = "https://leclerc.pl/gazetki/";
    private static final String URL_GROSZEK = "https://groszek.com.pl/gazetka/?leaflet=1";
    private static final String URL_CARREFOUR = "https://www.carrefour.pl/promocje/gazetka-promocyjna";

    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promotional_newsletter_activity);
        initComponents();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        webView.loadUrl(URL_ELECLERC);
    }

    private void initComponents() {
        webView = findViewById(R.id.webView);
    }
}

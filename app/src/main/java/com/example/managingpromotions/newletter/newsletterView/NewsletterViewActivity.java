package com.example.managingpromotions.newletter.newsletterView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.managingpromotions.R;
import com.github.barteksc.pdfviewer.PDFView;

public class NewsletterViewActivity extends AppCompatActivity {

    private PDFView pdfView;
    private final NewsletterPresenterImpl newsletterPresenter;

    public NewsletterViewActivity() {
        this.newsletterPresenter = new NewsletterPresenterImpl(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsletter_activity);
        initComponents();

        Intent intent = getIntent();
        Long newsletterId = intent.getLongExtra("newsletterId", 0);
        newsletterPresenter.getNewsLetterById(newsletterId);
    }

    public void loadNewsletterToPdfWebView(String pdfInBase64) {
        byte[] pdfAsBytes = Base64.decode(pdfInBase64, 0);
        pdfView.fromBytes(pdfAsBytes).load();
    }


    public void displayMessage(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_LONG).show();
    }

    private void initComponents() {
        pdfView = findViewById(R.id.pdfView);
    }
}

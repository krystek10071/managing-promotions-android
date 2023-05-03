package com.example.managingpromotions.newletter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.model.LetterNewsletterResponseDTO;
import com.example.managingpromotions.newletter.newsletterView.NewsletterViewActivity;
import com.example.managingpromotions.newletter.presenter.NewsletterGridPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class NewsletterGridActivity extends AppCompatActivity implements NewsletterGridRowAdapter.ButtonClickListener {

    private static final int COUNT_BUTTON_IN_ROWS = 2;

    private final NewsletterGridPresenterImpl newsletterGridPresenter;
    private final List<LetterNewsletterResponseDTO> newsletterResponseDTOList = new ArrayList<>();

    private RecyclerView recyclerView;

    private NewsletterGridRowAdapter gridRowAdapter;

    public NewsletterGridActivity() {
        newsletterGridPresenter = new NewsletterGridPresenterImpl(this);
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newletter_grid_activity);
        newsletterGridPresenter.getNewsletterList();

        recyclerView = findViewById(R.id.grid_with_buttons_for_newspapers);
        recyclerView.setLayoutManager(new GridLayoutManager(this, COUNT_BUTTON_IN_ROWS));

        gridRowAdapter = new NewsletterGridRowAdapter(this, newsletterResponseDTOList, this);
        recyclerView.setAdapter(gridRowAdapter);
    }

    public void setRecyclerView(List<LetterNewsletterResponseDTO> newsletterResponseDTOS) {

        newsletterResponseDTOList.addAll(newsletterResponseDTOS);
        gridRowAdapter.notifyItemChanged(newsletterResponseDTOS.size());
    }

    @Override
    public void openActivityWithNewsletter(Long id) {
        Intent intent = new Intent(this, NewsletterViewActivity.class);
        intent.putExtra("newsletterId", id);

        startActivity(intent);
    }

    public void displayMessage(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_LONG).show();
    }
}

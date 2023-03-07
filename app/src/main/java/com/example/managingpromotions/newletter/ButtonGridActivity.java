package com.example.managingpromotions.newletter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;

import java.util.ArrayList;

public class ButtonGridActivity extends AppCompatActivity implements NewsletterGridRowAdapter.ButtonClickListener {

    private final ArrayList<String> buttonLabels = new ArrayList<>();
    private RecyclerView recyclerView;

    public ButtonGridActivity() {
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newletter_grid_activity);

        buttonLabels.add("button1");
        buttonLabels.add("button 2");
        buttonLabels.add("button 3");
        buttonLabels.add("button 4");
        buttonLabels.add("button 5");

        recyclerView = findViewById(R.id.grid_with_buttons_for_newspapers);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        NewsletterGridRowAdapter adapter = new NewsletterGridRowAdapter(this, buttonLabels, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onButtonClick(String label) {
        // do something when button is clicked
    }
}

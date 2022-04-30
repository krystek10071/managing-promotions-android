package com.example.managingpromotions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.managingpromotions.addGrocery.activity.AddGroceryListActivityView;

public class MainActivity extends AppCompatActivity {

    private Button addGroceryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    @Override
    protected void onResume() {
        super.onResume();

        addGroceryList.setOnClickListener(view -> {
            Intent addGroceryListIntent = new Intent(this, AddGroceryListActivityView.class);
            startActivity(addGroceryListIntent);
        });
    }

    private void initComponents() {
        addGroceryList = findViewById(R.id.addGroceryList);
    }
}
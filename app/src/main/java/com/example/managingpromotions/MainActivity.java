package com.example.managingpromotions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.managingpromotions.addGrocery.activity.AddGroceryListActivityView;
import com.example.managingpromotions.cheapestShopping.groceryList.activity.CheapestShoppingActivity;
import com.example.managingpromotions.promotionalNewslaters.PromotionalNewsletterActivity;

public class MainActivity extends AppCompatActivity {

    private Button addGroceryList, cheapestShoppingButton, promotionalNewsletterButton;

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

        cheapestShoppingButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, CheapestShoppingActivity.class);
            startActivity(intent);
        });

        promotionalNewsletterButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, PromotionalNewsletterActivity.class);
            startActivity(intent);
        });
    }

    private void initComponents() {
        addGroceryList = findViewById(R.id.addGroceryList);
        cheapestShoppingButton = findViewById(R.id.cheapestShoppingButton);
        promotionalNewsletterButton = findViewById(R.id.promotionalNewsletterButton);
    }
}
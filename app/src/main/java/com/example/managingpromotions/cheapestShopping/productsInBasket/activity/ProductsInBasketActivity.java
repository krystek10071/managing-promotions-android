package com.example.managingpromotions.cheapestShopping.productsInBasket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.MainActivity;
import com.example.managingpromotions.R;
import com.example.managingpromotions.cheapestShopping.bestShopResult.model.CheapestShoppingReponse;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ParsedProductDTO;

import java.util.List;

public class ProductsInBasketActivity extends AppCompatActivity {
    private RecyclerView productsBasketRecyclerView;
    private Button goToMainActivityButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_in_basket_activity);

        CheapestShoppingReponse cheapestShoppingResponseRv = (CheapestShoppingReponse) getIntent().getSerializableExtra("productsInBasket");
        List<ParsedProductDTO> parsedProductDTOS = cheapestShoppingResponseRv.getProducts();

        initComponents();

        ProductsInBasketAdapter productsInBasketAdapter = new ProductsInBasketAdapter(this, parsedProductDTOS);
        productsBasketRecyclerView.setAdapter(productsInBasketAdapter);
        productsBasketRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();

        goToMainActivityButton.setOnClickListener(view ->
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void initComponents() {
        productsBasketRecyclerView = findViewById(R.id.products_in_basket_rv);
        goToMainActivityButton = findViewById(R.id.goToMainActivityButton);
    }
}

package com.example.managingpromotions.cheapestShopping.productsInBasket.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.cheapestShopping.bestShopResult.model.CheapestShoppingReponse;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ParsedProductDTO;

import java.util.List;

public class ProductsInBasketActivity extends AppCompatActivity {

    private TextView textViewShopName;
    private Button buttonGoToStoreWebsite;
    private RecyclerView productsBasketRecyclerView;
    private ProductsInBasketAdapter productsInBasketAdapter;
    private CheapestShoppingReponse cheapestShoppingResponseRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_in_basket_activity);

        cheapestShoppingResponseRv = (CheapestShoppingReponse) getIntent().getSerializableExtra("productsInBasket");
        List<ParsedProductDTO> parsedProductDTOS = cheapestShoppingResponseRv.getProducts();

        initComponents();

        productsInBasketAdapter = new ProductsInBasketAdapter(this, parsedProductDTOS);
        productsBasketRecyclerView.setAdapter(productsInBasketAdapter);
        productsBasketRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initComponents() {
        textViewShopName = findViewById(R.id.textViewShopName);
        productsBasketRecyclerView = findViewById(R.id.products_in_basket_rv);
        // buttonGoToStoreWebsite = findViewById(R.id.buttonGoToStore);
    }
}

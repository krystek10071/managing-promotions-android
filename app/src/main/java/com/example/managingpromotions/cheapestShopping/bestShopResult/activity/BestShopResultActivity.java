package com.example.managingpromotions.cheapestShopping.bestShopResult.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.managingpromotions.R;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ProductParsedFromShopDTO;

import java.util.ArrayList;
import java.util.List;

public class BestShopResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<ProductParsedFromShopDTO> productParsed = new ArrayList<>();

        setContentView(R.layout.best_shop_result_activity);
        productParsed = (List<ProductParsedFromShopDTO>) getIntent().getSerializableExtra("selectedProductsToCalculate");


    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
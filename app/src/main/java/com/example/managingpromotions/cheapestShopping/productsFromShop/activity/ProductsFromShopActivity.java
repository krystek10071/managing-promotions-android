package com.example.managingpromotions.cheapestShopping.productsFromShop.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;
import android.widget.Toast;

import com.example.managingpromotions.R;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ProductParsedFromShopDTO;
import com.example.managingpromotions.cheapestShopping.productsFromShop.presenter.ProductsFromShopPresenter;

import java.util.List;

public class ProductsFromShopActivity extends AppCompatActivity {

    private TextView testTextViewTab2;
    private ProductsFromShopPresenter productsFromShopPresenter;
    private List<ProductParsedFromShopDTO> productParsedFromShopDTOS;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.products_from_shop_activity);

        productsFromShopPresenter = new ProductsFromShopPresenter(this);
        //todo implement fetch Grocery List id
        productsFromShopPresenter.getProductsFromShop(1L);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
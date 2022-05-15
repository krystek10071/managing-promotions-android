package com.example.managingpromotions.cheapestShopping.productsFromShop.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ParsedProductDTO;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ProductParsedFromShopDTO;
import com.example.managingpromotions.cheapestShopping.productsFromShop.presenter.ProductsFromShopPresenter;

import java.util.ArrayList;
import java.util.List;

public class ProductsFromShopActivity extends AppCompatActivity {

    private Button nextButton;
    private TextView testTextViewTab2;
    private RecyclerView recyclerView;
    private ProductsFromShopAdapter productsFromShopAdapter;
    private ProductsFromShopPresenter productsFromShopPresenter;
    private List<ProductParsedFromShopDTO> productParsedFromShopDTOS;
    private List<ParsedProductDTO> productsParsedFromShopsRv;
    private List<Boolean> checkBoxStateArray;
    private int changedShopPosition;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.products_from_shop_activity);

        initComponents();

        productsFromShopPresenter = new ProductsFromShopPresenter(this);
        //todo implement fetch Grocery List id
        productsFromShopPresenter.getProductsFromShop(1L);
        checkBoxStateArray = new ArrayList<>(productsParsedFromShopsRv.size());

        productsFromShopAdapter = new ProductsFromShopAdapter(this, productsParsedFromShopsRv, checkBoxStateArray);

        recyclerView.setAdapter(productsFromShopAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initComponents() {
        changedShopPosition = 0;
        productParsedFromShopDTOS = new ArrayList<>();
        productsParsedFromShopsRv = new ArrayList<>();
        recyclerView = findViewById(R.id.products_from_shops_rv);
        nextButton = findViewById(R.id.nextButton);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void setRecyclerView(List<ProductParsedFromShopDTO> productParsedFromShopDTOResponse) {

        this.productParsedFromShopDTOS = productParsedFromShopDTOResponse;

        if (productParsedFromShopDTOResponse.get(changedShopPosition) != null) {
            productsParsedFromShopsRv = productParsedFromShopDTOS.get(changedShopPosition).getProducts();
        }

        productsFromShopAdapter.notifyItemChanged(productsParsedFromShopsRv.size());
    }
}
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

    private Button buttonNext;
    private TextView textViewShopName;
    private RecyclerView recyclerView;
    private ProductsFromShopAdapter productsFromShopAdapter;
    private List<ProductParsedFromShopDTO> productParsedFromShopDTOS;
    private List<ParsedProductDTO> productsParsedFromShopsRv;
    private List<Boolean> checkBoxStateArray;
    private int changedShopPosition;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.products_from_shop_activity);

        initComponents();

        ProductsFromShopPresenter productsFromShopPresenter = new ProductsFromShopPresenter(this);
        checkBoxStateArray = new ArrayList<>(productsParsedFromShopsRv.size());
        productsFromShopAdapter = new ProductsFromShopAdapter(this, productsParsedFromShopsRv, checkBoxStateArray);
        recyclerView.setAdapter(productsFromShopAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //todo implement fetch Grocery List id
        productsFromShopPresenter.getProductsFromShop(1L);
    }

    private void initComponents() {
        changedShopPosition = 0;
        productParsedFromShopDTOS = new ArrayList<>();
        productsParsedFromShopsRv = new ArrayList<>();
        recyclerView = findViewById(R.id.products_from_shops_rv);
        textViewShopName = findViewById(R.id.textViewShopName);
        buttonNext = findViewById(R.id.nextButton);
    }

    @Override
    protected void onResume() {
        super.onResume();

        buttonNext.setOnClickListener(view ->
        {
            changedShopPosition++;
            ProductParsedFromShopDTO productParsedFromShopDTO = productParsedFromShopDTOS.get(changedShopPosition);

            updateRecyclerView(productParsedFromShopDTO);
        });
    }

    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void setRecyclerView(List<ProductParsedFromShopDTO> productParsedFromShopDTOResponse) {

        productParsedFromShopDTOS.addAll(productParsedFromShopDTOResponse);

        if (productParsedFromShopDTOResponse.get(changedShopPosition) != null) {

            productsParsedFromShopsRv.clear();
            productsParsedFromShopsRv.addAll(productParsedFromShopDTOS.get(changedShopPosition).getProducts());

            //setCheckBoxArray
            productsParsedFromShopsRv.forEach(product -> {
                checkBoxStateArray.add(false);
            });
        }

        textViewShopName.setText(productParsedFromShopDTOS.get(changedShopPosition).getShopName());
        productsFromShopAdapter.notifyItemChanged(productsParsedFromShopsRv.size());
    }

    private void updateRecyclerView(ProductParsedFromShopDTO productParsedFromShopDTO) {

        if (productParsedFromShopDTO != null) {
            productsParsedFromShopsRv.clear();

            textViewShopName.setText(productParsedFromShopDTO.getShopName());

            if (productParsedFromShopDTO.getProducts() != null) {
                productsParsedFromShopsRv.addAll(productParsedFromShopDTO.getProducts());

                //setCheckBoxArray
                productsParsedFromShopsRv.forEach(product -> {
                    checkBoxStateArray.add(false);
                });
            }
        }

        productsFromShopAdapter.notifyItemChanged(productsParsedFromShopsRv.size());
    }
}
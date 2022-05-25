package com.example.managingpromotions.cheapestShopping.bestShopResult.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.cheapestShopping.bestShopResult.model.CheapestShoppingReponse;
import com.example.managingpromotions.cheapestShopping.bestShopResult.presenter.BestShopResultPresenter;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ProductParsedFromShopDTO;

import java.util.ArrayList;
import java.util.List;

public class BestShopResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BestShopResultAdapter bestShopResultAdapter;
    private BestShopResultPresenter bestShopResultPresenter;
    private List<CheapestShoppingReponse> cheapestShoppingReponse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.best_shop_result_activity);

        List<ProductParsedFromShopDTO> productParsed =
                (List<ProductParsedFromShopDTO>) getIntent().getSerializableExtra("selectedProductsToCalculate");

        initComponents();
        recyclerView.setAdapter(bestShopResultAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bestShopResultPresenter.calculateCostOfPurchases(productParsed);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initComponents() {
        recyclerView = findViewById(R.id.best_shop_result_rv);
        cheapestShoppingReponse = new ArrayList<>();
        bestShopResultAdapter = new BestShopResultAdapter(this, cheapestShoppingReponse);
        bestShopResultPresenter = new BestShopResultPresenter(this);
    }

    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void setRecyclerView(List<CheapestShoppingReponse> cheapestShoppingResponse) {
        cheapestShoppingReponse.addAll(cheapestShoppingResponse);

        bestShopResultAdapter.notifyItemChanged(cheapestShoppingReponse.size());
        recyclerView.refreshDrawableState();
    }
}
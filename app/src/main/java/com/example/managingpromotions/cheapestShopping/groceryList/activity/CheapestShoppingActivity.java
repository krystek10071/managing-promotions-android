package com.example.managingpromotions.cheapestShopping.groceryList.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.cheapestShopping.groceryList.presenter.GroceryListPresenterImpl;
import com.example.managingpromotions.cheapestShopping.productsFromShop.activity.ProductsFromShopActivity;
import com.example.managingpromotions.model.GroceryListResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class CheapestShoppingActivity extends AppCompatActivity {

    private Button buttonNext;
    private RecyclerView recyclerView;
    private GroceryListAdapter groceryListAdapter;
    private GroceryListPresenterImpl groceryListPresenter;
    private List<GroceryListResponseDTO> groceryListResponseDTOList;
    private List<Boolean> checkBoxStateArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_list_activity);

        init();

        groceryListPresenter = new GroceryListPresenterImpl(this);

        groceryListPresenter.getGroceryLists();
        checkBoxStateArray = new ArrayList<>(groceryListResponseDTOList.size());

        groceryListAdapter = new GroceryListAdapter(this, groceryListResponseDTOList, checkBoxStateArray);
        recyclerView.setAdapter(groceryListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        //set Grocery List elements
        groceryListPresenter.getGroceryLists();

        buttonNext.setOnClickListener(view -> {
            Intent intent = new Intent(this, ProductsFromShopActivity.class);
            startActivity(intent);
        });
    }

    private void init() {
        groceryListResponseDTOList = new ArrayList<>();
        recyclerView = findViewById(R.id.fragment_grocery_list_rv);
        buttonNext = findViewById(R.id.nextButton);
    }

    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void setRecyclerView(List<GroceryListResponseDTO> groceryListResponseDTOS) {

        groceryListResponseDTOList.addAll(groceryListResponseDTOS);

        groceryListResponseDTOS.forEach(groceryListResponseDTO -> {
            checkBoxStateArray.add(false);
        });

        groceryListAdapter.notifyItemChanged(groceryListResponseDTOS.size());
    }
}

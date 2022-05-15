package com.example.managingpromotions.cheapestShopping.productsFromShop.presenter;

import android.util.Log;

import com.example.managingpromotions.cheapestShopping.productsFromShop.activity.ProductsFromShopActivity;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ProductParsedFromShopDTO;
import com.example.managingpromotions.clientHttp.APIClient;
import com.example.managingpromotions.clientHttp.GroceryListAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsFromShopPresenter {

    private final GroceryListAPI groceryListAPI;
    private final ProductsFromShopActivity productsFromShopActivity;

    public ProductsFromShopPresenter(ProductsFromShopActivity productsFromShopActivity) {
        this.productsFromShopActivity = productsFromShopActivity;
        groceryListAPI = APIClient.getClient().create(GroceryListAPI.class);
    }

    public void getProductsFromShop(Long groceryListId) {

        Call<List<ProductParsedFromShopDTO>> callProductParsedFromShop =
                groceryListAPI.getProductsFromShops(groceryListId);

        callProductParsedFromShop.enqueue(new Callback<List<ProductParsedFromShopDTO>>() {
            @Override
            public void onResponse(Call<List<ProductParsedFromShopDTO>> call, Response<List<ProductParsedFromShopDTO>> response) {
                if (!response.isSuccessful()) {

                    String errorMassage = "ERROR HTTP CODE: " + response.code();
                    Log.i("ERROR", errorMassage);
                    productsFromShopActivity.displayMessage(errorMassage);
                } else {
                    if (response.body() != null) {
                        productsFromShopActivity.setRecyclerView(response.body());
                    } else {
                        String message = "Value body is null";
                        Log.i("ERROR", message);
                        productsFromShopActivity.displayMessage(message);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ProductParsedFromShopDTO>> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });
    }
}

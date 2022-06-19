package com.example.managingpromotions.cheapestShopping.groceryList.presenter;

import android.util.Log;

import com.example.managingpromotions.cheapestShopping.groceryList.activity.CheapestShoppingActivity;
import com.example.managingpromotions.model.GroceryListResponseDTO;
import com.example.managingpromotions.clientHttp.APIClient;
import com.example.managingpromotions.clientHttp.GroceryListAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroceryListPresenterImpl {

    private final CheapestShoppingActivity cheapestShoppingActivity;
    private final GroceryListAPI groceryListAPI;

    public GroceryListPresenterImpl(CheapestShoppingActivity cheapestShoppingActivity) {
        this.cheapestShoppingActivity = cheapestShoppingActivity;
        this.groceryListAPI = APIClient.getClient().create(GroceryListAPI.class);
    }

    public void getGroceryLists() {

        Call<List<GroceryListResponseDTO>> getGroceryList = groceryListAPI.getGroceryLists();

        getGroceryList.enqueue(new Callback<List<GroceryListResponseDTO>>() {
            @Override
            public void onResponse(Call<List<GroceryListResponseDTO>> call,
                                   Response<List<GroceryListResponseDTO>> response) {

                if (!response.isSuccessful()) {

                    String errorMassage = "ERROR HTTP CODE: " + response.code();
                    Log.i("ERROR", errorMassage);
                    cheapestShoppingActivity.displayMessage(errorMassage);
                } else {
                    if (response.body() != null) {
                        cheapestShoppingActivity.setRecyclerView(response.body());
                    } else {
                        String message = "Value body is null";
                        Log.i("ERROR", message);
                        cheapestShoppingActivity.displayMessage(message);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<GroceryListResponseDTO>> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });
    }
}

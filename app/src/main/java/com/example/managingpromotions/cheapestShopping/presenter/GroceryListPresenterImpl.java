package com.example.managingpromotions.cheapestShopping.presenter;

import android.util.Log;

import com.example.managingpromotions.cheapestShopping.GroceryListFragment;
import com.example.managingpromotions.model.GroceryListResponseDTO;
import com.example.managingpromotions.network.APIClient;
import com.example.managingpromotions.network.GroceryListAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroceryListPresenterImpl {

    private final GroceryListFragment groceryListFragment;
    private final GroceryListAPI groceryListAPI;

    public GroceryListPresenterImpl(GroceryListFragment groceryListFragment) {
        this.groceryListFragment = groceryListFragment;
        this.groceryListAPI = APIClient.getClient().create(GroceryListAPI.class);
    }

    public void getGroceryLists(){

        Call<List<GroceryListResponseDTO>> getGroceryList = groceryListAPI.getGroceryLists();

        getGroceryList.enqueue(new Callback<List<GroceryListResponseDTO>>() {
            @Override
            public void onResponse(Call<List<GroceryListResponseDTO>> call,
                                   Response<List<GroceryListResponseDTO>> response) {

                if(!response.isSuccessful()){

                    String errorMassage = "ERROR HTTP CODE: " + response.code();
                    Log.i("ERROR", errorMassage);
                    groceryListFragment.displayMessage(errorMassage);
                }else{
                    if(response.body() != null){
                        groceryListFragment.setRecyclerView(response.body());
                    }
                    else {
                        String message = "Value body is null";
                        Log.i("ERROR", message);
                        groceryListFragment.displayMessage(message);
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

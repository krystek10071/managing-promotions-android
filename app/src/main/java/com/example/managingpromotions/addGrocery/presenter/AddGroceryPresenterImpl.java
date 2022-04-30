package com.example.managingpromotions.addGrocery.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.managingpromotions.addGrocery.activity.AddGroceryListActivityView;
import com.example.managingpromotions.addGrocery.model.CreateIdResponseDTO;
import com.example.managingpromotions.addGrocery.model.GroceryListDTO;
import com.example.managingpromotions.addGrocery.model.GroceryListResponseDTO;
import com.example.managingpromotions.network.APIClient;
import com.example.managingpromotions.network.GroceryListAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddGroceryPresenterImpl {

    private AddGroceryListActivityView addGroceryListActivityView;
    private GroceryListAPI groceryListAPI;


    public AddGroceryPresenterImpl(AddGroceryListActivityView addGroceryListActivityView) {
        this.addGroceryListActivityView = addGroceryListActivityView;
    }

    public void saveGroceryList(GroceryListDTO groceryListDTO) {

        groceryListAPI = APIClient.getClient().create(GroceryListAPI.class);
        //todo implement get UserNameFromToken
        groceryListDTO.setUserLogin("kris");

        Call<CreateIdResponseDTO> callAddGroceryList = groceryListAPI.createGroceryList(groceryListDTO);

        callAddGroceryList.enqueue(new Callback<CreateIdResponseDTO>() {
            @Override
            public void onResponse(Call<CreateIdResponseDTO> call, Response<CreateIdResponseDTO> response) {
                if (!response.isSuccessful()){

                    String errorMassage = "ERROR HTTP CODE: " + response.code();
                    Log.i("ERROR", errorMassage);
                    addGroceryListActivityView.displayMessage(errorMassage);
                }else {
                    CreateIdResponseDTO createIdResponseDTO = response.body();
                }
            }

            @Override
            public void onFailure(Call<CreateIdResponseDTO> call, Throwable t) {
                Log.i("ERROR", t.getMessage());
            }
        });
    }
}

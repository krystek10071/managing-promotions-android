package com.example.managingpromotions.addGrocery.presenter;

import android.util.Log;

import com.example.managingpromotions.addGrocery.activity.AddGroceryListActivityView;
import com.example.managingpromotions.model.CreateIdResponseDTO;
import com.example.managingpromotions.model.GroceryListDTO;
import com.example.managingpromotions.clientHttp.APIClient;
import com.example.managingpromotions.clientHttp.GroceryListAPI;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddGroceryPresenterImpl {

    private final AddGroceryListActivityView addGroceryListActivityView;


    public AddGroceryPresenterImpl(AddGroceryListActivityView addGroceryListActivityView) {
        this.addGroceryListActivityView = addGroceryListActivityView;
    }

    public void saveGroceryList(GroceryListDTO groceryListDTO) {

        GroceryListAPI groceryListAPI = APIClient.getClient().create(GroceryListAPI.class);
        //todo implement get UserNameFromToken
        groceryListDTO.setUserLogin("kris");
        Call<CreateIdResponseDTO> callAddGroceryList = groceryListAPI.createGroceryList(groceryListDTO);

        callAddGroceryList.enqueue(new Callback<CreateIdResponseDTO>() {
            @Override
            public void onResponse(Call<CreateIdResponseDTO> call, Response<CreateIdResponseDTO> response) {
                if (!response.isSuccessful()) {

                    String errorMassage = "ERROR HTTP CODE: " + response.code();
                    Log.i("ERROR", errorMassage);
                    addGroceryListActivityView.displayMessage(errorMassage);
                } else {
                    CreateIdResponseDTO createIdResponseDTO = response.body();
                    String message = "Pomyślnie dodano nową listę zakupów o id: " +
                            Objects.requireNonNull(createIdResponseDTO).getId();

                    addGroceryListActivityView.displayMessage(message);
                }
            }

            @Override
            public void onFailure(Call<CreateIdResponseDTO> call, Throwable t) {
                Log.i("ERROR", t.getMessage());
            }
        });
    }
}

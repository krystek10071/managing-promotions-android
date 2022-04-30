package com.example.managingpromotions.network;

import com.example.managingpromotions.addGrocery.model.CreateIdResponseDTO;
import com.example.managingpromotions.addGrocery.model.GroceryListDTO;
import com.example.managingpromotions.addGrocery.model.GroceryListResponseDTO;
import com.example.managingpromotions.addGrocery.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GroceryListAPI {

    @POST("/api/v1/grocery-list/")
    Call<CreateIdResponseDTO> createGroceryList(@Body GroceryListDTO groceryListDTO);

    @GET("api/v1/grocery-list/kris")
    Call<List<GroceryListResponseDTO>> getGroceryLists();
}

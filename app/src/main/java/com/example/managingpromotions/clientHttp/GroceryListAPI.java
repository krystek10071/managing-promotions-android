package com.example.managingpromotions.clientHttp;

import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ProductParsedFromShopDTO;
import com.example.managingpromotions.model.CreateIdResponseDTO;
import com.example.managingpromotions.model.GroceryListDTO;
import com.example.managingpromotions.model.GroceryListResponseDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GroceryListAPI {

    @POST("/api/v1/grocery-list/")
    Call<CreateIdResponseDTO> createGroceryList(@Body GroceryListDTO groceryListDTO);

    @GET("/api/v1/grocery-list/{groceryList}/product-shop")
    Call<List<ProductParsedFromShopDTO>> getProductsFromShops(@Query("groceryListId") Long groceryListId);

    @GET("/api/v1/grocery-list/kris")
    Call<List<GroceryListResponseDTO>> getGroceryLists();

}

package com.example.managingpromotions.clientHttp;

import com.example.managingpromotions.cheapestShopping.bestShopResult.model.CheapestShoppingReponse;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ProductParsedFromShopDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ShopAPI {
    @POST("api/v1/shops/best-shop")
    Call<List<CheapestShoppingReponse>> getCheapestShoppingResponse(@Body List<ProductParsedFromShopDTO> productParsedFromShopDTOS);
}

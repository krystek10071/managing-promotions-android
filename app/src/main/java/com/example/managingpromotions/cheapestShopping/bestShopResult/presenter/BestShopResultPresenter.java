package com.example.managingpromotions.cheapestShopping.bestShopResult.presenter;

import android.util.Log;

import com.example.managingpromotions.cheapestShopping.bestShopResult.activity.BestShopResultActivity;
import com.example.managingpromotions.cheapestShopping.bestShopResult.model.CheapestShoppingReponse;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ProductParsedFromShopDTO;
import com.example.managingpromotions.clientHttp.APIClient;
import com.example.managingpromotions.clientHttp.ShopAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BestShopResultPresenter {

    private final ShopAPI shopAPI;
    private final BestShopResultActivity bestShopResultActivity;

    public BestShopResultPresenter(BestShopResultActivity bestShopResultActivity) {
        this.shopAPI = APIClient.getClient().create(ShopAPI.class);
        ;
        this.bestShopResultActivity = bestShopResultActivity;
    }


    public void calculateCostOfPurchases(List<ProductParsedFromShopDTO> productParsed) {

        Call<List<CheapestShoppingReponse>> callCheapestShoppingResponse =
                shopAPI.getCheapestShoppingResponse(productParsed);

        callCheapestShoppingResponse.enqueue(new Callback<List<CheapestShoppingReponse>>() {
            @Override
            public void onResponse(Call<List<CheapestShoppingReponse>> call, Response<List<CheapestShoppingReponse>> response) {
                if (!response.isSuccessful()) {

                    String errorMassage = "ERROR HTTP CODE: " + response.code();
                    Log.i("ERROR", errorMassage);
                    bestShopResultActivity.displayMessage(errorMassage);
                } else {
                    if (response.body() != null) {
                        bestShopResultActivity.setRecyclerView(response.body());
                    } else {
                        String message = "Value body is null";
                        Log.i("ERROR", message);
                        bestShopResultActivity.displayMessage(message);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CheapestShoppingReponse>> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });
    }
}

package com.example.managingpromotions.cheapestShopping.bestShopResult.presenter;

import com.example.managingpromotions.cheapestShopping.bestShopResult.activity.BestShopResultActivity;
import com.example.managingpromotions.clientHttp.APIClient;
import com.example.managingpromotions.clientHttp.ShopAPI;

public class BestShopResultPresenter {

    private ShopAPI shopAPI;
    private BestShopResultActivity bestShopResultActivity;

    public BestShopResultPresenter(ShopAPI shopAPI, BestShopResultActivity bestShopResultActivity) {
        this.shopAPI = APIClient.getClient().create(ShopAPI.class);
        ;
        this.bestShopResultActivity = bestShopResultActivity;
    }


}

package com.example.managingpromotions.login.presenter;

import android.util.Log;

import com.example.managingpromotions.clientHttp.APIClient;
import com.example.managingpromotions.clientHttp.AccountAPI;
import com.example.managingpromotions.login.activity.LoginActivityView;
import com.example.managingpromotions.model.LoginCredentials;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivityPresenter {

    private static final String ERROR_MESSAGE = "Wystąpił problem z logowaniem sprawdź login lub hasło";
    private final LoginActivityView loginActivityView;

    public LoginActivityPresenter(LoginActivityView loginActivityView) {
        this.loginActivityView = loginActivityView;
    }

    public void loginToService(LoginCredentials loginCredentials) {

        AccountAPI accountAPI = APIClient.getClient().create(AccountAPI.class);

        Call<Void> callLogin = accountAPI.login(loginCredentials);

        callLogin.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {

                    String message = "Pomyślnie zalogowano do serwisu";
                    loginActivityView.displayMessage(message);
                    loginActivityView.invokeMainActivity();
                } else {
                    Log.e("ERROR", ERROR_MESSAGE);
                    loginActivityView.displayMessage(ERROR_MESSAGE);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });
    }
}

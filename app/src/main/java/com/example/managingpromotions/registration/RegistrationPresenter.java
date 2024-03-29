package com.example.managingpromotions.registration;

import android.util.Log;

import com.example.managingpromotions.clientHttp.APIClient;
import com.example.managingpromotions.clientHttp.AccountAPI;
import com.example.managingpromotions.model.RegistrationCredentials;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationPresenter {

    private static final String CREATED_ACCOUNT_MESSAGE = "Pomyślnie utworzono nowe konto";
    private final AccountAPI accountAPI;
    private final RegistrationActivityView registrationActivityView;


    public RegistrationPresenter(RegistrationActivityView registrationActivityView) {
        this.registrationActivityView = registrationActivityView;
        this.accountAPI = APIClient.getClient().create(AccountAPI.class);
    }

    public void createAccount(RegistrationCredentials registrationCredentials) {

        Call<Void> callRegistration = accountAPI.registration(registrationCredentials);

        callRegistration.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {


                if (response.isSuccessful()) {

                    registrationActivityView.displayMessage(CREATED_ACCOUNT_MESSAGE);
                    registrationActivityView.invokeLoginActivity();
                } else {

                    String errorMassage = "ERROR HTTP CODE: " + response.code();
                    Log.e("ERROR", errorMassage);
                    registrationActivityView.displayMessage(errorMassage);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });

    }
}

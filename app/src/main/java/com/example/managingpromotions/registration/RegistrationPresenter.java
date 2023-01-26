package com.example.managingpromotions.registration;

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

                registrationActivityView.displayMessage(CREATED_ACCOUNT_MESSAGE);

                registrationActivityView.invokeLoginActivity();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }
}

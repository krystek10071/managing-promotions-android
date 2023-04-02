package com.example.managingpromotions.clientHttp;

import com.example.managingpromotions.model.LoginCredentials;
import com.example.managingpromotions.model.RegistrationCredentials;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountAPI {

    @POST("/login")
    Call<Void> login(@Body LoginCredentials loginCredentials);

    @POST("/registration")
    Call<Void> registration(@Body RegistrationCredentials registrationCredentials);
}

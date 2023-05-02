package com.example.managingpromotions.clientHttp;

import com.example.managingpromotions.model.LetterNewsletterResponseDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LetterNewsletterAPI {

    @GET("/api/v1/newspapers")
    Call<List<LetterNewsletterResponseDTO>> getNewsLetterList();
}

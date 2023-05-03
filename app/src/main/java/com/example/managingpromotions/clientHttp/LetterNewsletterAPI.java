package com.example.managingpromotions.clientHttp;

import com.example.managingpromotions.model.LetterNewsletterFileDTO;
import com.example.managingpromotions.model.LetterNewsletterResponseDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LetterNewsletterAPI {

    @GET("/api/v1/newspapers")
    Call<List<LetterNewsletterResponseDTO>> getNewsLetterList();

    @GET("/api/v1/newspapers/{id}")
    Call<LetterNewsletterFileDTO> getNewsletter(@Path("id") Long id);
}

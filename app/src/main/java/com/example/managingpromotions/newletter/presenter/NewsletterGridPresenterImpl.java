package com.example.managingpromotions.newletter.presenter;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.managingpromotions.clientHttp.APIClient;
import com.example.managingpromotions.clientHttp.LetterNewsletterAPI;
import com.example.managingpromotions.model.LetterNewsletterResponseDTO;
import com.example.managingpromotions.newletter.NewsletterGridActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsletterGridPresenterImpl {

    private final NewsletterGridActivity newsletterGridActivity;
    private final LetterNewsletterAPI letterNewsletterAPI;


    public NewsletterGridPresenterImpl(NewsletterGridActivity newsletterGridActivity) {
        this.newsletterGridActivity = newsletterGridActivity;
        letterNewsletterAPI = APIClient.getClient().create(LetterNewsletterAPI.class);
    }

    public void getNewsletterList() {

        Call<List<LetterNewsletterResponseDTO>> callGetNewsletterList = letterNewsletterAPI.getNewsLetterList();

        callGetNewsletterList.enqueue(new Callback<List<LetterNewsletterResponseDTO>>() {
            @Override
            public void onResponse(@NonNull Call<List<LetterNewsletterResponseDTO>> call, @NonNull Response<List<LetterNewsletterResponseDTO>> response) {
                if (response.isSuccessful()) {
                    newsletterGridActivity.setRecyclerView(response.body());
                } else {
                    String errorMassage = "ERROR HTTP CODE: " + response.code();
                    Log.e("ERROR", errorMassage);
                    newsletterGridActivity.displayMessage(errorMassage);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<LetterNewsletterResponseDTO>> call, @NonNull Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });
    }
}

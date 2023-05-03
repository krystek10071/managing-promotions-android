package com.example.managingpromotions.newletter.newsletterView;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.managingpromotions.clientHttp.APIClient;
import com.example.managingpromotions.clientHttp.LetterNewsletterAPI;
import com.example.managingpromotions.model.LetterNewsletterFileDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsletterPresenterImpl {

    private final NewsletterViewActivity newsletterViewActivity;
    private final LetterNewsletterAPI letterNewsletterAPI;

    public NewsletterPresenterImpl(NewsletterViewActivity newsletterViewActivity) {
        this.newsletterViewActivity = newsletterViewActivity;
        letterNewsletterAPI = APIClient.getClient().create(LetterNewsletterAPI.class);
    }

    public void getNewsLetterById(Long id) {

        Call<LetterNewsletterFileDTO> callNewsletterFileDTO = letterNewsletterAPI.getNewsletter(id);

        callNewsletterFileDTO.enqueue(new Callback<LetterNewsletterFileDTO>() {
            @Override
            public void onResponse(@NonNull Call<LetterNewsletterFileDTO> call,
                                   @NonNull Response<LetterNewsletterFileDTO> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    String pdfInBase64 = response.body().getFile();
                    newsletterViewActivity.loadNewsletterToPdfWebView(pdfInBase64);
                } else {
                    String errorMassage = "ERROR HTTP CODE: " + response.code();
                    Log.e("ERROR", errorMassage);
                    newsletterViewActivity.displayMessage(errorMassage);
                }
            }

            @Override
            public void onFailure(Call<LetterNewsletterFileDTO> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });
    }
}

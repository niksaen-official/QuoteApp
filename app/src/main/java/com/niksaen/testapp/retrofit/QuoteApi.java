package com.niksaen.testapp.retrofit;

import com.niksaen.testapp.models.Quote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface QuoteApi {
    @GET("random")
    @Headers("Content-Type: application/json")
    Call<Quote> getQuote();
}

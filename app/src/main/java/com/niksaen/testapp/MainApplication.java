package com.niksaen.testapp;

import android.app.Application;

import com.niksaen.testapp.models.Quote;
import com.niksaen.testapp.models.UserData;
import com.niksaen.testapp.retrofit.QuoteApi;
import com.niksaen.testapp.save.LocalData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainApplication extends Application {
    UserData userData;
    LocalData localData;
    public QuoteApi quoteApi;

    public UserData getUserData() {return userData;}

    @Override
    public void onCreate() {
        super.onCreate();
        localData = new LocalData(this);
        this.userData = localData.getUserData();
        configureApi();
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
        localData.setUserData(this.userData);
    }
    private void configureApi(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.quotable.io/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        quoteApi = retrofit.create(QuoteApi.class);
    }
}

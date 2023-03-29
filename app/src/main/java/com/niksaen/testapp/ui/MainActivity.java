package com.niksaen.testapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.niksaen.testapp.MainApplication;
import com.niksaen.testapp.R;
import com.niksaen.testapp.databinding.ActivityMainBinding;
import com.niksaen.testapp.dialog.Dialog;
import com.niksaen.testapp.models.Quote;
import com.niksaen.testapp.retrofit.QuoteApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding ui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        String data = getString(R.string.hi) +
                ((MainApplication)getApplication()).getUserData().getFirstName() +
                " " +
                ((MainApplication)getApplication()).getUserData().getLastName();
        ui.userName.setText(data);
        getQuote(((MainApplication) getApplication()).quoteApi);
    }
    private void getQuote(QuoteApi api){
        Dialog dialog = new Dialog(this);

        Call<Quote> single = api.getQuote();
        single.enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                assert response.body() != null;
                dialog.show(response.body());
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
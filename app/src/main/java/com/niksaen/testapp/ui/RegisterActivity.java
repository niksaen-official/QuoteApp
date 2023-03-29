package com.niksaen.testapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.niksaen.testapp.MainApplication;
import com.niksaen.testapp.R;
import com.niksaen.testapp.databinding.ActivityRegisterBinding;
import com.niksaen.testapp.models.UserData;

public class RegisterActivity extends AppCompatActivity {

    String gender;
    boolean isFirstNameChanged = false,isLastNameChanged = false;
    ActivityRegisterBinding ui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        gender = getIntent().getStringExtra("gender");
        ui.firstNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isFirstNameChanged = !s.toString().isEmpty();
                updateUi();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        ui.lastNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isLastNameChanged = !s.toString().isEmpty();
                updateUi();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        ui.nextBtn.setOnClickListener(v -> {
            if(isFirstNameChanged && isLastNameChanged){
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                ((MainApplication)getApplication()).setUserData(
                        new UserData(
                                gender,
                                ui.firstNameInput.getText().toString(),
                                ui.lastNameInput.getText().toString(),
                                false));
                startActivity(intent);
                finish();
            }
        });
    }
    void updateUi(){
        if(isFirstNameChanged && isLastNameChanged)
            ui.nextBtn.setBackgroundTintList(RegisterActivity.this.getResources().getColorStateList(R.color.purple_500,getTheme()));
        else
            ui.nextBtn.setBackgroundTintList(RegisterActivity.this.getResources().getColorStateList(R.color.notActiveBtn,getTheme()));
    }
}
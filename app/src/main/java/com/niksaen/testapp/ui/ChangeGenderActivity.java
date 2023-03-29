package com.niksaen.testapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.niksaen.testapp.R;
import com.niksaen.testapp.databinding.ActivityChangeGenderBinding;
import com.niksaen.testapp.models.UserData;

public class ChangeGenderActivity extends AppCompatActivity {

    ActivityChangeGenderBinding ui;
    String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityChangeGenderBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());

        ui.male.setOnClickListener(v -> {
            gender = UserData.Gender.Male.name();
            ui.male.setBackgroundTintList(this.getResources().getColorStateList(R.color.purple_500,getTheme()));
            ui.female.setBackgroundTintList(this.getResources().getColorStateList(R.color.notActive,getTheme()));
            ui.nextBtn.setBackgroundTintList(this.getResources().getColorStateList(R.color.purple_500,getTheme()));
        });
        ui.female.setOnClickListener(v -> {
            gender = UserData.Gender.Female.name();
            ui.male.setBackgroundTintList(this.getResources().getColorStateList(R.color.notActive,getTheme()));
            ui.female.setBackgroundTintList(this.getResources().getColorStateList(R.color.purple_500,getTheme()));
            ui.nextBtn.setBackgroundTintList(this.getResources().getColorStateList(R.color.purple_500,getTheme()));
        });
        ui.nextBtn.setOnClickListener(v -> {
            if(!gender.equals("")){
                Intent intent = new Intent(ChangeGenderActivity.this,RegisterActivity.class);
                intent.putExtra("gender",gender);
                startActivity(intent);
                finish();
            }
        });
    }
}
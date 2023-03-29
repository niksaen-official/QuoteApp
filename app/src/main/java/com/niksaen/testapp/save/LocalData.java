package com.niksaen.testapp.save;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.niksaen.testapp.models.UserData;

public class LocalData {
    private SharedPreferences preferences;
    public LocalData(Context context){
        preferences = context.getSharedPreferences("localData",Context.MODE_PRIVATE);
    }
    public UserData getUserData(){
        UserData data = new Gson().fromJson(preferences.getString("userData",""),UserData.class);
        return data != null?data:new UserData("","","",true);
    }
    public void setUserData(UserData userData){
        preferences.edit().putString("userData",new Gson().toJson(userData)).apply();
    }
}

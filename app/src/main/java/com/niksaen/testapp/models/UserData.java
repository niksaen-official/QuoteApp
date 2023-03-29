package com.niksaen.testapp.models;

public class UserData {

    String gender;
    public String getGender() {return gender;}
    String firstName;
    public String getFirstName(){return firstName;}
    String lastName;
    public String getLastName(){return lastName;}
    Boolean isNew;
    public Boolean getIsNew(){return isNew;}
    public UserData(String gender, String firstName, String lastName,boolean isNew){
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isNew = isNew;
    }
    public enum Gender{
        Male,
        Female
    }
}
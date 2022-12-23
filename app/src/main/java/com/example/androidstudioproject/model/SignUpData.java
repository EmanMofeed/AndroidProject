package com.example.androidstudioproject.model;

import java.util.ArrayList;
import java.util.List;

public class SignUpData {
    private List<SignUp> data;



    public SignUpData(){

    }
    public List<SignUp> getData() {
        data = new ArrayList<>();
        data.add(new SignUp("EmanKhalaf", "eman@gmail.com", "123456789"));
        data.add(new SignUp("MayAwadallah", "may@gmail.com", "123456789"));
        data.add(new SignUp("TalaAlawneh", "tala@gmail.com", "123456789"));
        data.add(new SignUp("TmaraAlawi", "tamara@gmail.com", "123456789"));
        return data;
    }

    public void setData(SignUp signUp){
        List<SignUp> array = getData();
        array.add(signUp);
    }
}

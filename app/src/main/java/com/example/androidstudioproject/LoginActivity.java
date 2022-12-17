package com.example.androidstudioproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidstudioproject.model.SignUp;
import com.example.androidstudioproject.model.SignUpData;

import java.util.List;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private TextView textViewSignup ;
    private EditText inputEmail,inputPassword;
    private Button loginBtn;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide(); //<< this
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        setupViews();

        preferences=getSharedPreferences("UserInfo",0);

        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
    public void checkCredentials(){
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if(email.isEmpty() || !email.contains("@")){
            showError(inputEmail,"Email is not valid");
        }
        else if(password.isEmpty() || password.length()<7){
            showError(inputPassword,"Password must be 7 character");
        }else {
            checkUserInformation(email,password);
        }

    }
    private void checkUserInformation(String email,String password) {
        SignUpData signUpData = new SignUpData();
        List<SignUp> data = signUpData.getData();
        boolean flagEmail = false;
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getEmail().equals(email)){
                if(data.get(i).getPassword().equals(password)) {
                    startActivity(new Intent(LoginActivity.this, HomePageActivity.class));
                    flagEmail = true;
                    break;
                }else {
                    showError(inputPassword,"Wrong password");
                    flagEmail = true;
                    break;
                }

            }
        }
        if(!flagEmail){
            showError(inputEmail,"This email does not exist you need to signUp first");
        }
    }

    private void showError(EditText input, String error) {
        input.setError(error);
        input.requestFocus();
    }



    public void setupViews(){
        textViewSignup = findViewById(R.id.textViewSignUp);
        inputPassword = findViewById(R.id.inputPassword);
        inputEmail = findViewById(R.id.inputEmail);
        loginBtn = findViewById(R.id.btnLogin);
    }

    public void btnLogin(View view) {
        checkCredentials();
    }
}
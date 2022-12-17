package com.example.androidstudioproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private TextView textViewSignup ;
    private EditText inputEmail,inputPassword;
    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide(); //<< this
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        setupViews();
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
            startActivity(new Intent(LoginActivity.this,HomePageActivity.class));
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
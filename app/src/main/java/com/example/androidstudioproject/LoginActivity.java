package com.example.androidstudioproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.datatransport.runtime.dagger.Reusable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private TextView textViewSignup ;
    private EditText inputEmail,inputPassword;
    private Button loginBtn;
    FirebaseAuth FAth;
    String email,password;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide(); //<< this
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        setupViews();

        FAth = FirebaseAuth.getInstance();


        preferences=getSharedPreferences("UserInfo",0);

        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public boolean isValid(){
       boolean isValid = false,  isValidEmail =false, isValidPassword=false;
       if(TextUtils.isEmpty(email)){
           inputEmail.setError("Email is required");
           inputEmail.requestFocus();
       }else {
           if(email.matches(emailPattern)){
               isValidEmail =true;
           }else {
               inputEmail.setError("Invalid Email Address");
               inputEmail.requestFocus();
           }
        }
       if(TextUtils.isEmpty(password)){
           inputEmail.setError("Password is required");
           inputEmail.requestFocus();

       }else{
           isValidPassword = true;
       }
       isValid= isValidEmail&& isValidPassword;
       return isValid;
    }




    public void setupViews(){
        textViewSignup = findViewById(R.id.textViewSignUp);
        inputPassword = findViewById(R.id.inputPassword);
        inputEmail = findViewById(R.id.inputEmail);
        loginBtn = findViewById(R.id.btnLogin);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("EMAIL",inputEmail.getText().toString());
        outState.putString("PASSWORD",inputEmail.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        inputEmail.setText(savedInstanceState.getString("EMAIL","Eman@gmail.com"));
        inputPassword.setText(savedInstanceState.getString("PASSWORD","123456789"));
    }

    public void btnLogin(View view) {
        email = inputEmail.getText().toString().trim();
        password = inputPassword.getText().toString().trim();

        if(isValid()){

            FAth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        if(FAth.getCurrentUser().isEmailVerified()){
                            startActivity(new Intent(LoginActivity.this,HomePageActivity.class));
                        }else {
                            inputEmail.setError("You don't have account");
                        }
                    }
                }
            });
        }
        }
}
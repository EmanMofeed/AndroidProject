package com.example.androidstudioproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidstudioproject.model.SignUp;
import com.example.androidstudioproject.model.SignUpData;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private TextView textViewLogin ;
    private EditText inputUserName,inputPassword,inputEmail,inputConfirmPassword;
    private Button btnRegister;
    SignUpData signUpData = new SignUpData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide(); //<< this
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        setupViews();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCredentials();
            }
        });

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }

    private void checkCredentials() {
        String userName = inputUserName.getText().toString();
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String confirmPassword = inputConfirmPassword.getText().toString();

        if(userName.isEmpty() || userName.length()< 7){
            showError(inputUserName,"Your username is not valid");
        }
        else if(email.isEmpty() || !email.contains("@")){
            showError(inputEmail,"Email is not valid");
        }
        else if(password.isEmpty() || password.length()<7){
            showError(inputPassword,"Password must be 7 character");
        }
        else if (confirmPassword.isEmpty() || !confirmPassword.equals(password)){
            showError(inputConfirmPassword,"Password not match");
        }else {
            checkUserInformation(email);
        }


    }

    private void checkUserInformation(String email) {
        List<SignUp> data = signUpData.getData();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getEmail().equals(email)) {
                showError(inputPassword, "This user is already exist");
                break;
            } else {
                SignUp newUser = new SignUp(inputUserName.getText().toString(),inputEmail.getText().toString(),inputPassword.getText().toString());
                signUpData.setData(newUser);
                startActivity(new Intent(RegisterActivity.this, HomePageActivity.class));

            }
        }
    }



private void showError(EditText input, String error) {
        input.setError(error);
        //it will help us to show the error
        input.requestFocus();

    }

    public void setupViews(){
        textViewLogin = findViewById(R.id.alreadyHaveAccount);
        inputUserName = findViewById(R.id.inputUserName);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        inputEmail = findViewById(R.id.inputEmail);
        btnRegister = findViewById(R.id.btnRegister);
    }

}
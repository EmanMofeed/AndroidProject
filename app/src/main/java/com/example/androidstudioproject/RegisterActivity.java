package com.example.androidstudioproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private TextView textViewLogin ;
    private EditText inputUserName,inputPassword,inputEmail,inputConfirmPassword;
    private Button btnRegister;
    FirebaseAuth FAuth;
    DatabaseReference reference;
    FirebaseDatabase firebaseDatabase;
    String name,email,password,confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide(); //<< this
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        setupViews();
        reference = firebaseDatabase.getInstance().getReference("users");
        FAuth = FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = inputUserName.getText().toString().trim();
                email = inputEmail.getText().toString().trim();
                password = inputPassword.getText().toString().trim();
                confirmPassword = inputConfirmPassword.getText().toString().trim();

        if(isValid()){
            final ProgressDialog md = new ProgressDialog(RegisterActivity.this);
            md.setCancelable(false);
            md.setCanceledOnTouchOutside(false);
            md.setMessage("Registration in progress please wait....");
            md.show();

            FAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        HashMap<String, String> hashMap1 = new HashMap<>();
                        hashMap1.put("Name", name);
                        hashMap1.put("Email", email);
                        hashMap1.put("Password", password);
                        hashMap1.put("confPassword", confirmPassword);
                        FirebaseDatabase.getInstance().getReference("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(hashMap1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        md.dismiss();
                                        FAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                                    builder.setMessage("You Have Registered! Please Verify Your email");
                                                    builder.setCancelable(false);
                                                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialogInterface, int i) {
                                                            dialogInterface.dismiss();
                                                            startActivity(new Intent(RegisterActivity.this,HomePageActivity.class));

                                                        }
                                                    });
                                                    AlertDialog alertDialog = builder.create();
                                                    alertDialog.show();
                                                }else {
                                                    md.dismiss();
                                                }
                                            }
                                        });

                                    }
                                });

                    }
                }
            });
        }
            }
        });
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public boolean isValid(){
        boolean isValidName=false,isValidEmail = false,isValidPassword = false ,isValidConfPassword = false ;
        if(TextUtils.isEmpty(name)){
            inputUserName.setError("Enter Name!");
            inputUserName.requestFocus();
        }else {
            isValidName = true;
        }
        if(TextUtils.isEmpty(email)){
            inputUserName.setError("Email is Required");
            inputUserName.requestFocus();

        }else {
            if(email.matches(emailPattern)){
                isValidEmail = true ;
            }else {
                inputEmail.setError("Enter a valid email");
                inputUserName.requestFocus();

            }
        }

        if(TextUtils.isEmpty(password)){
            inputUserName.setError("Enter Password");
            inputUserName.requestFocus();

        }else {
            if(password.length()<8 ){
                inputPassword.setError("Password is weak");
                inputUserName.requestFocus();

            }else {
                isValidPassword = true;
            }
        }

        if(TextUtils.isEmpty(confirmPassword)){
            inputConfirmPassword.setError("Enter Password");
            inputUserName.requestFocus();

        }else {
            if(!password.equals(confirmPassword) ){
                inputPassword.setError("Password Doesn't match");
                inputUserName.requestFocus();

            }else {
                isValidConfPassword = true;
            }
        }
        boolean isValid = isValidName && isValidEmail && isValidPassword && isValidConfPassword;
        return isValid;
    }



    public void setupViews(){
        textViewLogin = findViewById(R.id.alreadyHaveAccount);
        inputUserName = findViewById(R.id.inputUserName);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        inputEmail = findViewById(R.id.inputEmail);
        btnRegister = findViewById(R.id.btnRegister);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("NAME",inputUserName.getText().toString());
        outState.putString("EMAIL",inputEmail.getText().toString());
        outState.putString("PASSWORD",inputPassword.getText().toString());
        outState.putString("PASSWORDCONFIRM",inputConfirmPassword.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        inputUserName.setText(savedInstanceState.getString("NAME","EmanKhalaf"));
        inputEmail.setText(savedInstanceState.getString("EMAIL","Eman@gmail.com"));
        inputPassword.setText(savedInstanceState.getString("PASSWORD","123456789"));
        inputConfirmPassword.setText(savedInstanceState.getString("PASSWORDCONFIRM","123456789"));

    }

}
package com.linex.google.assignment.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.linex.google.assignment.Databse.DBHandler;
import com.linex.google.assignment.R;

import java.util.Objects;

public class SignupActivity extends AppCompatActivity {

    private EditText textEmail, textPassword,textName,textDob,textMobile,textAddress;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Registration");


        textName = findViewById(R.id.editTextNameRegister);
        textDob = findViewById(R.id.editTextDateRegister);
        textMobile = findViewById(R.id.editTextMobileRegister);
        textAddress = findViewById(R.id.editTextAddressRegister);
        textEmail = findViewById(R.id.editTextTextEmailAddressRegister);
        textPassword = findViewById(R.id.editTextTextPasswordRegister);
        Button btnSignUp = findViewById(R.id.btnSignupRegister);
        Button btnLogin = findViewById(R.id.btnLoginRegister);

        dbHandler = new DBHandler(SignupActivity.this);

        btnLogin.setOnClickListener(view -> startActivity(new Intent(SignupActivity.this, LoginActivity.class)));

        btnSignUp.setOnClickListener(view -> {
            String name, dob, mobile, address, email, password;
            name = textName.getText().toString();
            dob = textDob.getText().toString();
            mobile = textMobile.getText().toString();
            address = textAddress.getText().toString();
            email = textEmail.getText().toString();
            password = textPassword.getText().toString();

            if(TextUtils.isEmpty(name)){
                Toast.makeText(this, "Please enter email address", Toast.LENGTH_SHORT).show();
                textName.setError("Required Name!!");
                textName.requestFocus();
            }else
            if(TextUtils.isEmpty(dob)  ){
                Toast.makeText(this, "Please enter date of birth", Toast.LENGTH_SHORT).show();
                textDob.setError("Required date of birth!!");
                textDob.requestFocus();
            }else
            if(TextUtils.isEmpty(mobile)){
                Toast.makeText(this, "Please enter Mobile", Toast.LENGTH_SHORT).show();
                textMobile.setError("Required Mobile!!");
                textMobile.requestFocus();
            }else
            if(mobile.length() > 10){
                Toast.makeText(this, "Please enter Mobile", Toast.LENGTH_SHORT).show();
                textMobile.setError("Required Mobile!!");
                textMobile.requestFocus();
            }else
            if(TextUtils.isEmpty(address)){
                Toast.makeText(this, "Please enter address", Toast.LENGTH_SHORT).show();
                textAddress.setError("Required Address!!");
                textAddress.requestFocus();
            }else

            if(TextUtils.isEmpty(email)){
                Toast.makeText(this, "Please enter email address", Toast.LENGTH_SHORT).show();
                textEmail.setError("Required Email Address");
                textEmail.requestFocus();
            }else
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(this, "Please enter email address", Toast.LENGTH_SHORT).show();
                textEmail.setError("Required Email Address");
                textEmail.requestFocus();
            }else
                if(password.length() < 6){
                Toast.makeText(this, "Please enter password !!", Toast.LENGTH_SHORT).show();
                textPassword.setError("Required password!!");
                textPassword.requestFocus();
            }else
                if(TextUtils.isEmpty(password)  ){
                Toast.makeText(this, "Please enter password !!", Toast.LENGTH_SHORT).show();
                textPassword.setError("Required password!!");
                textPassword.requestFocus();
            }else  {

                    dbHandler.addNewUser(name, dob, mobile, address, email, password);
                    Toast.makeText(this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                    textName.setText("");
                    textDob.setText("");
                    textMobile.setText("");
                    textAddress.setText("");
                    textEmail.setText("");
                    textPassword.setText("");

                }

        });
    }

}
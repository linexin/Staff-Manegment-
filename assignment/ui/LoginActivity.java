package com.linex.google.assignment.ui;

import static com.linex.google.assignment.Databse.DBHandler.TABLE_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.linex.google.assignment.Databse.DBHandler;
import com.linex.google.assignment.Activities.MainActivity;
import com.linex.google.assignment.R;
import com.linex.google.assignment.User.User;

import java.util.ArrayList;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private EditText textEmail, textPassword;
    private DBHandler dbHandler;
    private SQLiteDatabase sqLiteDatabase;
    private SQLiteOpenHelper sqLiteOpenHelper;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Login");

        textEmail = findViewById(R.id.editTextTextEmailAddress);
        textPassword = findViewById(R.id.editTextTextPassword);
        Button btnSignUp = findViewById(R.id.btnSignup);
        Button btnLogin = findViewById(R.id.btnLogin);

        dbHandler = new DBHandler(LoginActivity.this);
        sqLiteOpenHelper = new DBHandler(LoginActivity.this);
        sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase();

        btnSignUp.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, SignupActivity.class));
        });

        btnLogin.setOnClickListener(view -> {
            String email, password;
            email = this.textEmail.getText().toString();
            password = this.textPassword.getText().toString();


            if (TextUtils.isEmpty(email) ) {
                Toast.makeText(this, "Please enter email address", Toast.LENGTH_SHORT).show();
                this.textEmail.setError("Required Email Address");
                this.textEmail.requestFocus();
            } else if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter email address", Toast.LENGTH_SHORT).show();
                this.textPassword.setError("Required Email Address");
                this.textPassword.requestFocus();
            } else {

                loginUser(email, password);

            }
        });
    }

    private void loginUser(String email, String password) {

        cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "
                        + TABLE_NAME + " WHERE "
                        + DBHandler.EMAIL_COL + " =?  AND "
                        + DBHandler.PASSWORD_COL + " =? ",
                new String[]{email, password}
        );
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
            }
        }


    }


    }
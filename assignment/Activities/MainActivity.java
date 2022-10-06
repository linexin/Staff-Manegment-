package com.linex.google.assignment.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.linex.google.assignment.Adapter.usersAdapter;
import com.linex.google.assignment.Databse.DBHandler;
import com.linex.google.assignment.R;
import com.linex.google.assignment.User.User;
import com.linex.google.assignment.ui.LoginActivity;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> userArrayList;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Staff Information");


        userArrayList = new ArrayList<>();
        dbHandler = new DBHandler(MainActivity.this);

        userArrayList = dbHandler.usersData();

        com.linex.google.assignment.Adapter.usersAdapter usersAdapter = new usersAdapter(userArrayList, MainActivity.this);
        RecyclerView userRecyclerView = findViewById(R.id.recylerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        userRecyclerView.setLayoutManager(linearLayoutManager);

        userRecyclerView.setAdapter(usersAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            dbHandler.close();
            Toast.makeText(this, "Logout Successfully...", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }



}
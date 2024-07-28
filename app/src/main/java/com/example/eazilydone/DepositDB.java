package com.example.eazilydone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eazilydone.backend.APIClient;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DepositDB extends AppCompatActivity {


    private Button exitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depositdb);

        // Retrieve data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String deposit = intent.getStringExtra("amount");
        String pin = getIntent().getStringExtra("pin");
        String accountNumber = intent.getStringExtra("accountNumber");

        //exit button
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DepositDB.this, ThirdActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Log the received values
        Log.d("SendtoDB", "Received Name: " + name);
        Log.d("SendtoDB", "Received Deposit: " + deposit);
        Log.d("SendtoDB", "PIN: " + pin);
        Log.d("SendtoDB", "Account Number: " + accountNumber);


        // Set the values to TextViews
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView depositTextView = findViewById(R.id.depositTextView);
        TextView accountDetailsTextView = findViewById(R.id.accountDetailsTextView);



        nameTextView.setText("Name: " + name);
        depositTextView.setText("Deposit: " + deposit);
        accountDetailsTextView.setText("Account Number: " + accountNumber);




    }

}

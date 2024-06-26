package com.example.eazilydone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SendtoDB extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sendto_db);

            // Retrieve data from Intent
            Intent intent = getIntent();
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            String email = intent.getStringExtra("email");
            String deposit = intent.getStringExtra("deposit");
            String countryCode = intent.getStringExtra("countryCode");

            // Log the received values
            Log.d("SendtoDB", "Received Name: " + name);
            Log.d("SendtoDB", "Received Phone: " + phone);
            Log.d("SendtoDB", "Received Email: " + email);
            Log.d("SendtoDB", "Received Deposit: " + deposit);
            Log.d("SendtoDB", "Received Country Code: " + countryCode);

            // Set the values to TextViews
            TextView nameTextView = findViewById(R.id.nameTextView);
            TextView phoneTextView = findViewById(R.id.phoneTextView);
            TextView emailTextView = findViewById(R.id.emailTextView);
            TextView depositTextView = findViewById(R.id.depositTextView);
            TextView countryCodeTextView = findViewById(R.id.countryCodeTextView);

            nameTextView.setText(name);
            phoneTextView.setText(phone);
            emailTextView.setText(email);
            depositTextView.setText(deposit);
            countryCodeTextView.setText(countryCode);
        }

}

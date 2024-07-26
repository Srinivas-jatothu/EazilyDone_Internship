package com.example.eazilydone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;



public class AccountDetailsDB extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountdetailsdb);


        // Retrieve data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String accountNumber = intent.getStringExtra("accountNumber");
        String pin = intent.getStringExtra("pin");



        //exit button
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountDetailsDB.this, ThirdActivity.class);
                startActivity(intent);
                finish();
            }
        });




        Log.d("AccountDetailsDB", "Received Name: " + name);
        Log.d("AccountDetailsDB", "Received Account Number: " + accountNumber);
        Log.d("AccountDetailsDB", "Received PIN: " + pin);



        // Set the values to TextViews in the layout
        TextView nameTextView = findViewById(R.id.nameTextView1);
        nameTextView.setText(name);

        TextView accountNumberTextView = findViewById(R.id.accountDetailsTextView1);
        accountNumberTextView.setText(accountNumber);

        TextView pinTextView = findViewById(R.id.pinnumberTextView1);
        pinTextView.setText(pin);










    }

    //print the data


}

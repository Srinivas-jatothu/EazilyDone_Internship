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


public class AccountDetailsDB extends AppCompatActivity {


    private Button exitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountdetailsdb);

        // Retrieve data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");
        String deposit = intent.getStringExtra("deposit");
        String countryCode = intent.getStringExtra("countryCode");
        String dateTime = getIntent().getStringExtra("dateAndTime");
        String accounttype = getIntent().getStringExtra("accountType");
        String pin = getIntent().getStringExtra("pin");
        String accountNumber = getIntent().getStringExtra("accountNumber");

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

        // Log the received values
        Log.d("SendtoDB", "Received Name: " + name);
        Log.d("SendtoDB", "Received Phone: " + phone);
        Log.d("SendtoDB", "Received Email: " + email);
        Log.d("SendtoDB", "Received Deposit: " + deposit);
        Log.d("SendtoDB", "Received Country Code: " + countryCode);
        Log.d("SendtoDB", "PIN: " + pin);
        Log.d("SendtoDB", "Received Date and Time: " + dateTime);
        Log.d("SendtoDB", "Account Number: " + accountNumber);


        // Set the values to TextViews in the layout
        TextView nameTextView = findViewById(R.id.nameTextView);
      TextView phoneTextView = findViewById(R.id.phoneTextView);
       TextView emailTextView = findViewById(R.id.emailTextView);
        TextView depositTextView = findViewById(R.id.depositTextView);
        TextView accountTypeTextView = findViewById(R.id.accountTypeTextView);
        TextView accountNumberTextView = findViewById(R.id.accountDetailsTextView);




        Map<String,String>mp=new HashMap<>();
        mp.put("name",name);
        mp.put("accNo",accountNumber);
        mp.put("pin",pin);
        Log.d("AccountDetailsDB", "Request Body: " + new Gson().toJson(mp));
        Call<Map<String,String>> call = APIClient.Service().getAccountDetails(mp);
        call.enqueue(new Callback<Map<String, String>>() {
            @Override
            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                Map<String,String> res=response.body();
                Log.d("AccountDetailsDB", ""+res);
                if(response.isSuccessful()){
                    Log.d("AccountDetailsDB", "Successfully got account details");
                    Log.d("AccountDetailsDB", "Account Details: " + res);
                    //name=name, phone=1234, email=email@hi.com, deposit=100.0, accountType=saving, accountNo=1, pin=1234, countryCode=+91
                    // TODO:: these are variables that are being returned
                    // to use them use res.get("name") to get the name and similar checkout

                    //use the res and display in texviews
                    nameTextView.setText("Name: " + res.get("name"));
                    depositTextView.setText("Deposit: " + res.get("deposit"));
                    accountNumberTextView.setText("Account Number: " + res.get("accountNo"));
                    emailTextView.setText("Email: " + res.get("email"));
                    phoneTextView.setText("Phone: " + res.get("phone"));
                    accountTypeTextView.setText("Account Type: " + res.get("accountType"));


                    Toast.makeText(AccountDetailsDB.this, "Successfully got account details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.d("AccountDetailsDB", "Failed to get account details");
                    Toast.makeText(AccountDetailsDB.this, "Failed to get account details", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Map<String, String>> call, Throwable t) {

            }
        });


    }

}

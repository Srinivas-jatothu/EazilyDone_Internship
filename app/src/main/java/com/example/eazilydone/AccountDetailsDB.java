//package com.example.eazilydone;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.util.Log;
//
//
//
//public class AccountDetailsDB extends AppCompatActivity {
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.accountdetailsdb);
//
//
//        // Retrieve data from Intent
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//        String accountNumber = intent.getStringExtra("accountNumber");
//        String pin = intent.getStringExtra("pin");
//
//
//
//        //exit button
//        Button exitButton = findViewById(R.id.exitButton);
//        exitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AccountDetailsDB.this, ThirdActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//
//
//
//        Log.d("AccountDetailsDB", "Received Name: " + name);
//        Log.d("AccountDetailsDB", "Received Account Number: " + accountNumber);
//        Log.d("AccountDetailsDB", "Received PIN: " + pin);
//
//
//
//        // Set the values to TextViews in the layout
//        TextView nameTextView = findViewById(R.id.nameTextView1);
//        nameTextView.setText(name);
//
//        TextView accountNumberTextView = findViewById(R.id.accountDetailsTextView1);
//        accountNumberTextView.setText(accountNumber);
//
//        TextView pinTextView = findViewById(R.id.pinnumberTextView1);
//        pinTextView.setText(pin);
//
//
//
//
//
//
//
//
//
//
//    }
//
//    //print the data
//
//
//}






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
//        TextView phoneTextView = findViewById(R.id.phoneTextView);
//        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView depositTextView = findViewById(R.id.depositTextView);
//        TextView countryCodeTextView = findViewById(R.id.countryCodeTextView);
//        TextView dateTimeTextView = findViewById(R.id.dateTimeTextView);
//        TextView accountTypeTextView = findViewById(R.id.accountTypeTextView);
        TextView pinTextView = findViewById(R.id.pinnumberTextView);
        TextView accountNumberTextView = findViewById(R.id.accountDetailsTextView);




//the below code is to set the values to the textviews in the activity_sendto_db.xml
        nameTextView.setText("Name: " + name);
        //phoneTextView.setText("Phone: " + phone);
        //emailTextView.setText("Email: " + email);
        depositTextView.setText("Deposit: " + deposit);
        //countryCodeTextView.setText("Country Code: " + countryCode);
//        dateTimeTextView.setText("Date and Time: " + dateTime);
//        accountTypeTextView.setText("Account Type: " + accounttype);
        pinTextView.setText("PIN: " + pin);
        accountNumberTextView.setText("Account Number: " + accountNumber);
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

        // Set up the PIN submission logic
//        EditText pinEditText = findViewById(R.id.pinEditText);
//        Button submitPinButton = findViewById(R.id.submitPinButton);
//        Map<String,String> mp=new HashMap<>();
//        mp.put("name",name);
//        mp.put("phone",phone);
//        mp.put("countryCode",countryCode);
//        mp.put("mail",email);
//        mp.put("deposit",deposit);
//        mp.put("accType",accounttype);
//        Call<Map<String,String>> call= APIClient.Service().createAccount(mp);
//        call.enqueue(new Callback<Map<String, String>>() {
//            @Override
//            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
//                Log.d("TAG", "onResponse: "+response.body());
//                if(response.isSuccessful()){
//                    Toast.makeText(SendtoDB.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(SendtoDB.this, "Account Creation Failed", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Map<String, String>> call, Throwable t) {
//
//            }
//        });
//        submitPinButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String pin = pinEditText.getText().toString();
//
//                if (pin.length() == 4 && pin.matches("\\d+")) {
//                    Toast.makeText(SendtoDB.this, "PIN has been generated: " + pin, Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(SendtoDB.this, "Please enter a valid 4-digit PIN", Toast.LENGTH_SHORT).show();
//                }
//                //call new activity
//                Intent intent = new Intent(SendtoDB.this, SecondActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }


//    public void saveAccountDetails(String name, String accountNumber, String amount, String pin) {
//        // Implement the logic to save account details to the database here
//        // For example, you can use SQLite, Room, or any other database method
//
//        // This is just a placeholder. Add your actual database code here.
//        System.out.println("Saving account details...");
//        System.out.println("Name: " + name);
//        System.out.println("Account Number: " + accountNumber);
//        System.out.println("Deposit Amount: ₹" + amount);
//        System.out.println("PIN: " + pin);
//
//    }
}
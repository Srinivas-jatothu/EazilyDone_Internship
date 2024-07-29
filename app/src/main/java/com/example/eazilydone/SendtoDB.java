//package com.example.eazilydone;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.eazilydone.backend.APIClient;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//
//public class SendtoDB extends AppCompatActivity {
//
//    private Button exitButton;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sendto_db);
//
//        // Retrieve data from Intent
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//        String phone = intent.getStringExtra("phone");
//        String email = intent.getStringExtra("email");
//        String deposit = intent.getStringExtra("deposit");
//        String countryCode = intent.getStringExtra("countryCode");
//        String dateTime = getIntent().getStringExtra("dateAndTime");
//        String accounttype = getIntent().getStringExtra("accountType");
//        String pin = getIntent().getStringExtra("pin");
//
//        //exit button
//        Button exitButton = findViewById(R.id.exitButton);
//        exitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SendtoDB.this, ThirdActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        // Log the received values
//        Log.d("SendtoDB", "Received Name: " + name);
//        Log.d("SendtoDB", "Received Phone: " + phone);
//        Log.d("SendtoDB", "Received Email: " + email);
//        Log.d("SendtoDB", "Received Deposit: " + deposit);
//        Log.d("SendtoDB", "Received Country Code: " + countryCode);
//        Log.d("SendtoDB", "PIN: " + pin);
//        Log.d("SendtoDB", "Received Date and Time: " + dateTime);
//
//        // Set the values to TextViews
//        TextView nameTextView = findViewById(R.id.nameTextView);
//        TextView phoneTextView = findViewById(R.id.phoneTextView);
//        TextView emailTextView = findViewById(R.id.emailTextView);
//        TextView depositTextView = findViewById(R.id.depositTextView);
//        TextView countryCodeTextView = findViewById(R.id.countryCodeTextView);
//        TextView dateTimeTextView = findViewById(R.id.dateTimeTextView);
//        TextView accountTypeTextView = findViewById(R.id.accountTypeTextView);
//        TextView pinTextView = findViewById(R.id.pinnumberTextView);
//
//
//        nameTextView.setText("Name: " + name);
//        phoneTextView.setText("Phone: " + phone);
//        emailTextView.setText("Email: " + email);
//        depositTextView.setText("Deposit: " + deposit);
//        countryCodeTextView.setText("Country Code: " + countryCode);
//        dateTimeTextView.setText("Date and Time: " + dateTime);
//        accountTypeTextView.setText("Account Type: " + accounttype);
//        pinTextView.setText("PIN: " + pin);
//
//        // Set up the PIN submission logic
////        EditText pinEditText = findViewById(R.id.pinEditText);
////        Button submitPinButton = findViewById(R.id.submitPinButton);
//        Map<String,String> mp=new HashMap<>();
//        mp.put("name",name);
//        mp.put("phone",phone);
//        mp.put("countryCode",countryCode);
//        mp.put("mail",email);
//        mp.put("deposit",deposit);
//        mp.put("accType",accounttype);
//        mp.put("pin",pin);
//        Call<Map<String,String>> call= APIClient.Service().createAccount(mp);
//
//        final Long[] accountNumber = new Long[1];
//        call.enqueue(new Callback<Map<String, String>>() {
//            @Override
//            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
//                Log.d("TAG", "onResponse: "+response.body());
//                if(response.isSuccessful()){
//                    Toast.makeText(SendtoDB.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
//                    String accountNumberStr = response.body().get("accountNo");
//                    accountNumber[0] = Long.parseLong(accountNumberStr);
//                    Log.d("TAG", "onResponse: "+accountNumber[0]);
//                }
//                else{
//                    Toast.makeText(SendtoDB.this, "Account Creation Failed", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<Map<String, String>> call, Throwable t) {
//                Toast.makeText(SendtoDB.this, "Account Creation Failed Or Account Already exists", Toast.LENGTH_SHORT).show();
//            }
//        });
//
////        submitPinButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String pin = pinEditText.getText().toString();
////
////                if (pin.length() == 4 && pin.matches("\\d+")) {
////                    Toast.makeText(SendtoDB.this, "PIN has been generated: " + pin, Toast.LENGTH_SHORT).show();
////                } else {
////                    Toast.makeText(SendtoDB.this, "Please enter a valid 4-digit PIN", Toast.LENGTH_SHORT).show();
////                }
////                //call new activity
////                Intent intent = new Intent(SendtoDB.this, SecondActivity.class);
////                startActivity(intent);
////                finish();
////            }
////        });
//    }
//
//
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

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SendtoDB extends AppCompatActivity {

    private Button exitButton;
    private TextView cashAmountTextView; // Declare cashAmountTextView as a class member

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
        String dateTime = getIntent().getStringExtra("dateAndTime");
        String accounttype = getIntent().getStringExtra("accountType");
        String pin = getIntent().getStringExtra("pin");

        //exit button
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendtoDB.this, ThirdActivity.class);
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


        // Set the values to TextViews
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView phoneTextView = findViewById(R.id.phoneTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView depositTextView = findViewById(R.id.depositTextView);
        TextView countryCodeTextView = findViewById(R.id.countryCodeTextView);
        TextView dateTimeTextView = findViewById(R.id.dateTimeTextView);
        TextView accountTypeTextView = findViewById(R.id.accountTypeTextView);
        TextView pinTextView = findViewById(R.id.pinnumberTextView);


        nameTextView.setText("Name: " + name);
        phoneTextView.setText("Phone: " + phone);
        emailTextView.setText("Email: " + email);
        depositTextView.setText("Deposit: " + deposit);
        countryCodeTextView.setText("Country Code: " + countryCode);
        dateTimeTextView.setText("Date and Time: " + dateTime);
        accountTypeTextView.setText("Account Type: " + accounttype);
        pinTextView.setText("PIN: " + pin);

        // Set up the PIN submission logic
//        EditText pinEditText = findViewById(R.id.pinEditText);
//        Button submitPinButton = findViewById(R.id.submitPinButton);
        Map<String,String> mp=new HashMap<>();
        mp.put("name",name);
        mp.put("phone",phone);
        mp.put("countryCode",countryCode);
        mp.put("mail",email);
        mp.put("deposit",deposit);
        mp.put("accType",accounttype);
        mp.put("pin",pin);
        Call<Map<String,String>> call= APIClient.Service().createAccount(mp);

        final Long[] accountNumber = new Long[1];
        call.enqueue(new Callback<Map<String, String>>() {
            @Override
            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                Log.d("TAG", "onResponse: "+response.body());
                if(response.isSuccessful()){
                    Toast.makeText(SendtoDB.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                    String accountNumberStr = response.body().get("accountNo");
                    accountNumber[0] = Long.parseLong(accountNumberStr);
                    Log.d("TAG", "onResponse: AccountNumber "+accountNumber[0]);
                    // use this account number and show in textview accountnumberTextView
                    TextView accountNumberTextView = findViewById(R.id.accountnumberTextView);
                    accountNumberTextView.setText("Account Number: " + accountNumber[0]);
                }
                else{
                    Toast.makeText(SendtoDB.this, "Account Creation Failed", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Map<String, String>> call, Throwable t) {
                Toast.makeText(SendtoDB.this, "Account Creation Failed Or Account Already exists", Toast.LENGTH_SHORT).show();
            }
        });



    }


    public void saveAccountDetails(String name, String accountNumber, String amount, String pin) {
        // Implement the logic to save account details to the database here
        // For example, you can use SQLite, Room, or any other database method

        // This is just a placeholder. Add your actual database code here.
        System.out.println("Saving account details...");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Deposit Amount: ₹" + amount);
        System.out.println("PIN: " + pin);

    }
}
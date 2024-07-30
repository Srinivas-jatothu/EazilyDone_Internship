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


public class WithDrawDB extends AppCompatActivity {

    private TextView cashAmountTextView; // Declare cashAmountTextView as a class member

    private Button exitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.withdrawdb);

        // Retrieve data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String withDraw = intent.getStringExtra("amount");
        String pin = getIntent().getStringExtra("pin");
        String accountNumber = getIntent().getStringExtra("accountNumber");

        //exit button
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WithDrawDB.this, ThirdActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Log the received values
        Log.d("WithDrawDB", "Received Name: " + name);
        Log.d("WithDrawDB", "Received Deposit: " + withDraw);
        Log.d("WithDrawDB", "PIN: " + pin);
        Log.d("WithDrawDB", "Account Number: " + accountNumber);


        // Set the values to TextViews in the layout
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView depositTextView = findViewById(R.id.withdrawTextView);
        TextView accountTypeTextView = findViewById(R.id.accountTypeTextView);
        TextView accountNumberTextView = findViewById(R.id.accountDetailsTextView);




        Map<String,String>mp=new HashMap<>();
        mp.put("name",name);
        mp.put("accNo",accountNumber);
        mp.put("pin",pin);
        Log.d("WithDrawDB", "Request Body: " + new Gson().toJson(mp));
        Call<Map<String,String>> call = APIClient.Service().getAccountDetails(mp);
        call.enqueue(new Callback<Map<String, String>>() {
            @Override
            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                Map<String,String> res=response.body();
                Log.d("WithDrawDB", ""+res);
                if(response.isSuccessful()){
                    Log.d("WithDrawDB", "Successfully got account details");
                    Log.d("WithDrawDB", "Account Details: " + res);
                    //name=name, phone=1234, email=email@hi.com, deposit=100.0, accountType=saving, accountNo=1, pin=1234, countryCode=+91
                    // TODO:: these are variables that are being returned
                    // to use them use res.get("name") to get the name and similar checkout

                    //deduct the amount from the deposit
                    double deposit = Double.parseDouble(res.get("deposit"));
                    double withDraw1 = Double.parseDouble(withDraw);
                   double deposit_new = deposit - withDraw1;

                   //update the cash amount in the cash amount manager by adding the deposit new amount to the cash amount
                     CashAmountManager.getInstance().setCashAmount(withDraw1);

                    //use the res and display in texviews
                    nameTextView.setText("Name: " + res.get("name"));
                    depositTextView.setText("WithDrawl Amount : " + withDraw);
                    accountNumberTextView.setText("Account Number: " + res.get("accountNo"));
                    accountTypeTextView.setText("Account Type: " + res.get("accountType"));


                    Toast.makeText(WithDrawDB.this, "Successfully got account details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.d("WithDrawDB", "Failed to get account details");
                    Toast.makeText(WithDrawDB.this, "Failed to get account details", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Map<String, String>> call, Throwable t) {

            }
        });

        //update the cash amount
        updateCashAmount();


    }

    private void updateCashAmount() {
        if (cashAmountTextView != null) {
            cashAmountTextView.setText(String.valueOf(CashAmountManager.getInstance().getCashAmount()));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Update cash amount when returning to MainActivity
        updateCashAmount();
    }
}

package com.example.eazilydone;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eazilydone.backend.APIClient;
import com.google.gson.Gson;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepositDB extends AppCompatActivity {

    private Button exitButton;
    private TextView nameTextView;
    private TextView depositTextView;
    private TextView accountDetailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depositdb);

        // Retrieve data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String deposit = intent.getStringExtra("amount");
        String pin = intent.getStringExtra("pin");
        String accountNumber = intent.getStringExtra("accountNumber");

        // Exit button
        exitButton = findViewById(R.id.exitButton);
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

        Map<String, String> mp = new HashMap<>();
        mp.put("name", name);
        mp.put("accNo", accountNumber);
        mp.put("pin", pin);
        Log.d("AccountDetailsDB", "Request Body: " + new Gson().toJson(mp));

        Call<Map<String, String>> call = APIClient.Service().getAccountDetails(mp);
        call.enqueue(new Callback<Map<String, String>>() {
            @Override
            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                Map<String, String> res = response.body();
                Log.d("DepositDB", "" + res);
                if (response.isSuccessful()) {
                    Log.d("DepositDB", "Successfully got account details");
                    Log.d("DepositDB", "Account Details: " + res);

                    Toast.makeText(DepositDB.this, "Successfully got account details", Toast.LENGTH_SHORT).show();

                    String accountType = res.get("accountType");
                    String apiDeposit = res.get("deposit");
                    //store date
                    String date = "2021-09-01";

                    Log.d("DepositDB", "Account Type: " + accountType);
                    Log.d("DepositDB", "Deposit from API: " + apiDeposit);

                    // Call the calculation method with account type
                    double receivedDeposit = Double.parseDouble(deposit);
                    double apiDepositValue = Double.parseDouble(apiDeposit);
                    double result = calculateDeposit(receivedDeposit, apiDepositValue, accountType, date);

                    // Display the result or use it as needed
                    Log.d("DepositDB", "Calculation Result: " + result);
                    Toast.makeText(DepositDB.this, "Calculation Result: " + result, Toast.LENGTH_SHORT).show();

                } else {
                    Log.d("AccountDetailsDB", "Failed to get account details");
                    Toast.makeText(DepositDB.this, "Failed to get account details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Map<String, String>> call, Throwable t) {
                Log.e("DepositDB", "Error: " + t.getMessage());
                Toast.makeText(DepositDB.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Set the values to TextViews
        nameTextView = findViewById(R.id.nameTextView);
        depositTextView = findViewById(R.id.depositTextView);
        accountDetailsTextView = findViewById(R.id.accountDetailsTextView);

        nameTextView.setText("Name: " + name);
        depositTextView.setText("Deposit: " + deposit);
        accountDetailsTextView.setText("Account Number: " + accountNumber);
    }





    private double calculateDeposit(double receivedDeposit, double apiDeposit, String accountType, String date) {
        // Retrieve the local date and time from the local device
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTime = now.format(dateFormatter);

        // Parse the provided date string into a LocalDate object
        LocalDate providedDate = LocalDate.parse(date, dateFormatter);
        LocalDate currentDate = now.toLocalDate();

        // Calculate the difference in days between the provided date and the current date
        long daysDifference = ChronoUnit.DAYS.between(providedDate, currentDate);

        // Log the date provided as a parameter and the current local date and time
        Log.d("DepositDB", "Provided Date: " + date);
        Log.d("DepositDB", "Current Date and Time: " + formattedDateTime);
        Log.d("DepositDB", "Days Difference: " + daysDifference);

        // Define the interest rates for different savings accounts
        double interestRate;
        switch (accountType) {
            case "Premium Saving Account":
                interestRate = 0.06; // 6% interest rate
                break;
            case "Standard Saving Account":
                interestRate = 0.04; // 4% interest rate
                break;
            case "Foreign Currency Saving Account":
                interestRate = 0.03; // 3% interest rate
                break;
            default:
                interestRate = 0.0; // No interest for unknown account types
                break;
        }

        if (accountType.equals("Premium Current Account") ||
                accountType.equals("Standard Current Account") ||
                accountType.equals("Foreign Currency Current Account")) {
            // For current accounts, return the sum of received deposit and API deposit
            return receivedDeposit + apiDeposit;
        } else if (accountType.equals("Premium Saving Account") ||
                accountType.equals("Standard Saving Account") ||
                accountType.equals("Foreign Currency Saving Account")) {
            // Calculate interest for savings accounts
            double interest = calculateInterest(receivedDeposit, interestRate, daysDifference);
            // Return the total deposit including interest
            return receivedDeposit +  interest;
        } else {
            // Default case if the account type doesn't match any known types
            return receivedDeposit + apiDeposit;
        }
    }

    private double calculateInterest(double principal, double annualRate, long days) {
        // Calculate the interest using the simple interest formula
        double daysInYear = 365.0; // Approximate number of days in a year
        return principal * (annualRate / daysInYear) * days;
    }


}

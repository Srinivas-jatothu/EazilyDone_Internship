package com.example.eazilydone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AccountDetailsActivity extends AppCompatActivity {

    private EditText etName, etAccountNumber, etAmount, etPin;
    private CheckBox checkBox;
    private Button btnSubmit;
    private LinearLayout detailsLayout;
    private TextView tvDisplayName, tvDisplayAccountNumber, tvDisplayAmount, tvDisplayPin;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_details);

        etName = findViewById(R.id.etName);
        etAccountNumber = findViewById(R.id.etAccountNumber);
        etPin = findViewById(R.id.etPin);
        checkBox = findViewById(R.id.checkBox);
        btnSubmit = findViewById(R.id.btnSubmit);
        detailsLayout = findViewById(R.id.detailsLayout);
        tvDisplayName = findViewById(R.id.tvDisplayName);
        tvDisplayAccountNumber = findViewById(R.id.tvDisplayAccountNumber);
        tvDisplayAmount = findViewById(R.id.tvDisplayAmount);
        tvDisplayPin = findViewById(R.id.tvDisplayPin);
        scrollView = findViewById(R.id.scrollView);

        // Set up a delay for the welcome message
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.tvWelcomeMessage).setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
            }
        }, 5000); // 5 seconds delay

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    displayDetails();
                    sendDataToDatabase();
                }
            }
        });
    }

    private boolean validateInput() {
        if (etName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etAccountNumber.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please enter your account number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etAmount.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please enter deposit amount", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etPin.getText().toString().trim().length() != 4) {
            Toast.makeText(this, "Please enter a 4-digit PIN", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!checkBox.isChecked()) {
            Toast.makeText(this, "Please agree to the terms", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void displayDetails() {
        String name = etName.getText().toString().trim();
        String accountNumber = etAccountNumber.getText().toString().trim();
        String amount = etAmount.getText().toString().trim();
        String pin = etPin.getText().toString().trim();

        detailsLayout.setVisibility(View.VISIBLE);

        tvDisplayName.setText("Name: " + name);
        tvDisplayAccountNumber.setText("Account Number: " + accountNumber);
        tvDisplayAmount.setText("Deposit Amount: ₹" + amount);
        tvDisplayPin.setText("PIN: " + pin);

        scrollView.setVisibility(View.GONE); // Hide the form once details are displayed
    }

    private void sendDataToDatabase() {
        String name = etName.getText().toString().trim();
        String accountNumber = etAccountNumber.getText().toString().trim();
        String amount = etAmount.getText().toString().trim();
        String pin = etPin.getText().toString().trim();
        SendtoDB sendToDB = new SendtoDB();
        sendToDB.saveAccountDetails(name, accountNumber, amount, pin);
    }
}

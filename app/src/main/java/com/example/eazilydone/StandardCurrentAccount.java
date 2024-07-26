package com.example.eazilydone;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StandardCurrentAccount extends AppCompatActivity {
    private EditText accountHolderName, phoneNumber, email, initialDeposit;
    private Spinner countryCodeSpinner;
    private Button submitButton;


    protected void onCreate(Bundle savedInstanceState) {
        //print the log
        Log.d("RegularSavingsAccount", "onCreate() called");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.regular_savings_account_form);

        accountHolderName = findViewById(R.id.accountHolderName);
        phoneNumber = findViewById(R.id.phoneNumber);
        email = findViewById(R.id.email);
        initialDeposit = findViewById(R.id.initialDeposit);
        countryCodeSpinner = findViewById(R.id.countryCodeSpinner);
        submitButton = findViewById(R.id.submitButton);

        // Array of country codes
        String[] countryCodes = {"+91 (India)", "+1 (USA)", "+44 (UK)", "+61 (Australia)", "+81 (Japan)",
                "+86 (China)", "+49 (Germany)", "+33 (France)", "+55 (Brazil)", "+27 (South Africa)", "+94 (Sri Lanka)"};

        // Setting up the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryCodes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countryCodeSpinner.setAdapter(adapter);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String name = accountHolderName.getText().toString();
        String phone = phoneNumber.getText().toString();
        String emailText = email.getText().toString();
        String deposit = initialDeposit.getText().toString();
        String countryCode = countryCodeSpinner.getSelectedItem().toString();
        String accounttype = "Standard Current Account";

        // Perform validation and submission logic here
        if (name.isEmpty() || phone.isEmpty() || emailText.isEmpty() || deposit.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Show a success message
        Toast.makeText(this, "Form submitted successfully", Toast.LENGTH_SHORT).show();
    }
}

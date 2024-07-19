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

public class DepositActivity extends AppCompatActivity {

    private EditText etName, etAccountNumber, etAmount;
    private CheckBox checkBox;
    private Button btnSubmit;
    private LinearLayout detailsLayout;
    private TextView tvDisplayName, tvDisplayAccountNumber, tvDisplayAmount;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deposit);

        etName = findViewById(R.id.etName);
        etAccountNumber = findViewById(R.id.etAccountNumber);
        etAmount = findViewById(R.id.etAmount);
        checkBox = findViewById(R.id.checkBox);
        btnSubmit = findViewById(R.id.btnSubmit);
        detailsLayout = findViewById(R.id.detailsLayout);
        tvDisplayName = findViewById(R.id.tvDisplayName);
        tvDisplayAccountNumber = findViewById(R.id.tvDisplayAccountNumber);
        tvDisplayAmount = findViewById(R.id.tvDisplayAmount);
        scrollView = findViewById(R.id.scrollView);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    displayDetails();
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

        detailsLayout.setVisibility(View.VISIBLE);

        tvDisplayName.setText("Name: " + name);
        tvDisplayAccountNumber.setText("Account Number: " + accountNumber);
        tvDisplayAmount.setText("Deposit Amount: ₹" + amount);

        scrollView.setVisibility(View.GONE); // Hide the form once details are displayed
    }

}

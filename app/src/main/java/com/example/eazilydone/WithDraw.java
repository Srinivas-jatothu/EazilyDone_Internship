package com.example.eazilydone;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eazilydone.R;

public class WithDraw extends AppCompatActivity {

    private EditText etName, etAccountNumber, etPin, etAmount;
    private CheckBox checkBox;
    private LinearLayout detailsLayout;
    private TextView tvDisplayName, tvDisplayAccountNumber, tvDisplayPin, tvDisplayAmount;
    private CashAmountManager cashAmountManager;
    private TextView cashAmountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize CashAmountManager (if not already initialized)
        CashAmountManager.getInstance();

        setContentView(R.layout.withdraw);

        // Initialize UI elements
        etName = findViewById(R.id.etName);
        etAccountNumber = findViewById(R.id.etAccountNumber);
        etPin = findViewById(R.id.etPin);
        etAmount = findViewById(R.id.etAmount);
        checkBox = findViewById(R.id.checkBox);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        detailsLayout = findViewById(R.id.detailsLayout);
        tvDisplayName = findViewById(R.id.tvDisplayName);
        tvDisplayAccountNumber = findViewById(R.id.tvDisplayAccountNumber);
        tvDisplayPin = findViewById(R.id.tvDisplayPin);
        tvDisplayAmount = findViewById(R.id.tvDisplayAmount);

        // Set up the submit button click listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

    }

    private void submitForm() {
        String name = etName.getText().toString().trim();
        String accountNumber = etAccountNumber.getText().toString().trim();
        String pin = etPin.getText().toString().trim();
        String amountStr = etAmount.getText().toString().trim();  // Withdrawal amount

        if (validateInputs(name, accountNumber, pin, amountStr)) {
            // Display the details
            tvDisplayName.setText("Name: " + name);
            tvDisplayAccountNumber.setText("Account Number: " + accountNumber);
            tvDisplayPin.setText("PIN: " + pin);
            tvDisplayAmount.setText("Withdraw Amount: " + amountStr);

            // Show the details layout
            detailsLayout.setVisibility(View.VISIBLE);

            // Clear the input fields
            etName.setText("");
            etAccountNumber.setText("");
            etPin.setText("");
            etAmount.setText("");
            checkBox.setChecked(false);

            // Update the cash amount after withdrawal by adding this withdrawal amount to the CashAmountManager
            double amount = Integer.parseInt(amountStr);
            cashAmountManager.setCashAmount(amount);
            updateCashAmount();

        }
    }

    private boolean validateInputs(String name, String accountNumber, String pin, String amountStr) {
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(accountNumber)) {
            Toast.makeText(this, "Please enter your account number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(pin) || pin.length() != 4) {
            Toast.makeText(this, "Please enter a valid 4-digit PIN", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(amountStr)) {
            Toast.makeText(this, "Please enter the withdrawal amount", Toast.LENGTH_SHORT).show();
            return false;
        }
        int amount = Integer.parseInt(amountStr);
        if (amount % 100 != 0) {
            Toast.makeText(this, "Please enter an amount in multiples of 100", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!checkBox.isChecked()) {
            Toast.makeText(this, "Please agree to the notice", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    // Method to update cash amount in cash_amount_view.xml
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

//package com.example.eazilydone;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.ScrollView;
//import android.widget.TextView;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class DepositActivity extends AppCompatActivity {
//
//    private EditText etName, etAccountNumber, etAmount;
//    private CheckBox checkBox;
//    private Button btnSubmit;
//    private LinearLayout detailsLayout;
//    private TextView tvDisplayName, tvDisplayAccountNumber, tvDisplayAmount;
//    private ScrollView scrollView;
//
//    private TextView cashAmountTextView; // Declare cashAmountTextView as a class member
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.deposit);
//
//
//        // Initialize CashAmountManager (if not already initialized)
//        CashAmountManager.getInstance();
//
//        etName = findViewById(R.id.etName);
//        etAccountNumber = findViewById(R.id.etAccountNumber);
//        etAmount = findViewById(R.id.etAmount);
//        checkBox = findViewById(R.id.checkBox);
//        btnSubmit = findViewById(R.id.btnSubmit);
//        detailsLayout = findViewById(R.id.detailsLayout);
//        tvDisplayName = findViewById(R.id.tvDisplayName);
//        tvDisplayAccountNumber = findViewById(R.id.tvDisplayAccountNumber);
//        tvDisplayAmount = findViewById(R.id.tvDisplayAmount);
//        scrollView = findViewById(R.id.scrollView);
//        cashAmountTextView = findViewById(R.id.cashAmount);
//
//
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (validateInput()) {
//                    displayDetails();
//                }
//            }
//        });
//
//
//
//        // Update cash amount initially
//        updateCashAmount();
//    }
//    private boolean validateInput() {
//        if (etName.getText().toString().trim().isEmpty()) {
//            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if (etAccountNumber.getText().toString().trim().isEmpty()) {
//            Toast.makeText(this, "Please enter your account number", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if (etAmount.getText().toString().trim().isEmpty()) {
//            Toast.makeText(this, "Please enter deposit amount", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        //if the entered emoount is less than 1000 and greater than cash amount, then show a toast message insufficent balance
//        if (Integer.parseInt(etAmount.getText().toString().trim()) < 1000) {
//            Toast.makeText(this, "Minimum deposit amount is ₹1000", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if (Integer.parseInt(etAmount.getText().toString().trim()) > CashAmountManager.getInstance().getCashAmount()) {
//            Toast.makeText(this, "Insufficient balance", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if (!checkBox.isChecked()) {
//            Toast.makeText(this, "Please agree to the terms", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
//
//        //
//        return true;
//    }
//    private void displayDetails() {
//        String name = etName.getText().toString().trim();
//        String accountNumber = etAccountNumber.getText().toString().trim();
//        String amount = etAmount.getText().toString().trim();
//        //subtract the deposit amount from the cash amount in CashAmountManager class and update the cash amount in cash_amount_view.xml
//        CashAmountManager.getInstance().subtractCashAmount(Integer.parseInt(amount));
//
//        detailsLayout.setVisibility(View.VISIBLE);
//
//        tvDisplayName.setText("Name: " + name);
//        tvDisplayAccountNumber.setText("Account Number: " + accountNumber);
//        tvDisplayAmount.setText("Deposit Amount: ₹" + amount);
//
//        scrollView.setVisibility(View.GONE); // Hide the form once details are displayed
//    }
//
//    // Method to update cash amount in cash_amount_view.xml TextView
//    private void updateCashAmount() {
//        if (cashAmountTextView != null) {
//            cashAmountTextView.setText(String.valueOf(CashAmountManager.getInstance().getCashAmount()));
//        }
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        // Update cash amount when returning to MainActivity
//        updateCashAmount();
//    }
//
//}




package com.example.eazilydone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    private EditText etName, etAccountNumber, etAmount, etPin;
    private CheckBox checkBox;
    private Button btnSubmit;
    private LinearLayout detailsLayout;
    private TextView tvDisplayName, tvDisplayAccountNumber, tvDisplayAmount;
    private ScrollView scrollView;

    private TextView cashAmountTextView; // Declare cashAmountTextView as a class member

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deposit);

        // Initialize CashAmountManager (if not already initialized)
        CashAmountManager.getInstance();

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
        cashAmountTextView = findViewById(R.id.cashAmount);
        etPin = findViewById(R.id.etPin);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    //displayDetails();
                    sendDataToDatabase();
                }
            }
        });

        // Update cash amount initially
        updateCashAmount();
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
        int depositAmount = Integer.parseInt(etAmount.getText().toString().trim());
        if (depositAmount < 1000) {
            Toast.makeText(this, "Minimum deposit amount is ₹1000", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (depositAmount > CashAmountManager.getInstance().getCashAmount()) {
            Toast.makeText(this, "Insufficient balance", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!checkBox.isChecked()) {
            Toast.makeText(this, "Please agree to the terms", Toast.LENGTH_SHORT).show();
            return false;
        }

        String amount = etAmount.getText().toString().trim();
        // Subtract the deposit amount from the cash amount in CashAmountManager class
        CashAmountManager.getInstance().subtractCashAmount(Integer.parseInt(amount));
        Log.d("DepositActivity", "Cash Amount after deposit: " + CashAmountManager.getInstance().getCashAmount());

        return true;
    }

    private void displayDetails() {
        String name = etName.getText().toString().trim();
        String accountNumber = etAccountNumber.getText().toString().trim();
        String amount = etAmount.getText().toString().trim();

        // Subtract the deposit amount from the cash amount in CashAmountManager class
        CashAmountManager.getInstance().subtractCashAmount(Integer.parseInt(amount));
        Log.d("DepositActivity", "Cash Amount after deposit: " );

        detailsLayout.setVisibility(View.VISIBLE);

        tvDisplayName.setText("Name: " + name);
        tvDisplayAccountNumber.setText("Account Number: " + accountNumber);
        tvDisplayAmount.setText("Deposit Amount: ₹" + amount);


        scrollView.setVisibility(View.GONE); // Hide the form once details are displayed

        // Update cash amount display
        updateCashAmount();
    }

    //function to send the data to the database
    private void sendDataToDatabase() {
        String name = etName.getText().toString().trim();
        String accountNumber = etAccountNumber.getText().toString().trim();
        String amount = etAmount.getText().toString().trim();

        // Log the data
        Log.d("DepositActivity", "Name: " + name);
        Log.d("DepositActivity", "Account Number: " + accountNumber);
        Log.d("DepositActivity", "Deposit Amount: " + amount);
        Log.d("DepositActivity", "PIN: " + etPin.getText().toString().trim());

        // Send the data to the database
        // Code to send data to the database goes here
        Intent intent = new Intent(DepositActivity.this, DepositDB.class);
        intent.putExtra("name", name);
        intent.putExtra("accountNumber", accountNumber);
        intent.putExtra("amount", amount);
        intent.putExtra("pin", etPin.getText().toString().trim());
        startActivity(intent);
        finish();

    }

    // Method to update cash amount in cash_amount_view.xml TextView
    private void updateCashAmount() {
        if (cashAmountTextView != null) {
            cashAmountTextView.setText(String.valueOf(CashAmountManager.getInstance().getCashAmount()));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Update cash amount when returning to DepositActivity
        updateCashAmount();
    }
}

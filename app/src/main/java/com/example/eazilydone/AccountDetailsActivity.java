package com.example.eazilydone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eazilydone.AccountDetailsDB;

public class AccountDetailsActivity extends AppCompatActivity {

    private EditText etName, etAccountNumber, etAmount, etPin;
    private CheckBox checkBox;
    private Button btnSubmit;
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
        scrollView = findViewById(R.id.scrollView);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
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

    private void sendDataToDatabase() {
        String name = etName.getText().toString().trim();
        String accountNumber = etAccountNumber.getText().toString().trim();
        String pin = etPin.getText().toString().trim();

        //log the data
        Log.d("AccountDetailsActivity", "Name: " + name);
        Log.d("AccountDetailsActivity", "Account Number: " + accountNumber);
        Log.d("AccountDetailsActivity", "PIN: " + pin);


        Intent intent = new Intent(AccountDetailsActivity.this, AccountDetailsDB.class);
        intent.putExtra("name", name);
        intent.putExtra("accountNumber", accountNumber);
        intent.putExtra("pin", pin);
        startActivity(intent);
    }
}

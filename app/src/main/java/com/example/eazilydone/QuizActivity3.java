package com.example.eazilydone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity3 extends AppCompatActivity {

    private CashAmountManager cashAmountManager;
    private TextView cashAmountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        // Initialize CashAmountManager (if not already initialized)
        cashAmountManager = CashAmountManager.getInstance();

        // Retrieve the cash amount from the Intent
        int cashAmount = getIntent().getIntExtra("cashAmount", 0); // Default to 0 if not found

        // Find the EditText and display the cash amount
        cashAmountEditText = findViewById(R.id.cashAmount);
        cashAmountEditText.setText(String.valueOf(cashAmount));

        // Add the cash amount to CashAmountManager
        cashAmountManager.setCashAmount(cashAmount);

        // Find the finish button and set an onClick listener
        Button finishButton = findViewById(R.id.finish);
        finishButton.setOnClickListener(v -> {
            // Example: Increment cash amount by 10 (adjust as per your logic)
            cashAmountManager.incrementCashAmount(10);

            // Display "Hello" message when the button is clicked
            Toast.makeText(QuizActivity3.this, "Hello", Toast.LENGTH_SHORT).show();

            // Call Leaderboard activity
            startActivity(new Intent(QuizActivity3.this, SecondActivity.class));
        });
    }
}

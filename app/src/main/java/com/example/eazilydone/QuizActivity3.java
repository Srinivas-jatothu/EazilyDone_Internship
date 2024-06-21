package com.example.eazilydone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity3 extends AppCompatActivity {

    private EditText cashAmountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        // Retrieve the cash amount from the Intent
        int cashAmount = getIntent().getIntExtra("cashAmount", 0); // Default to 0 if not found

        // Find the EditText and display the cash amount
        cashAmountEditText = findViewById(R.id.cashAmount);
        cashAmountEditText.setText(String.valueOf(cashAmount));

        // Find the finish button and set an onClick listener
        Button finishButton = findViewById(R.id.finish);
        finishButton.setOnClickListener(v -> {


            // Display "Hello" message when the button is clicked
            Toast.makeText(QuizActivity3.this, "Hello", Toast.LENGTH_SHORT).show();
            //call leaderboard activity
            startActivity(new Intent(QuizActivity3.this, LeaderBoard.class));


        });
    }
}

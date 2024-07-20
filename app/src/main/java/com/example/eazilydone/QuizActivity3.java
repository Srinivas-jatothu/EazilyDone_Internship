package com.example.eazilydone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eazilydone.DTO.ScoreDTO;
import com.example.eazilydone.backend.APIClient;
import com.example.eazilydone.data.playerData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//TODO :: I just hard-cored the name as John, need to get the info playerData need to know and store it in the data flow.
public class QuizActivity3 extends AppCompatActivity {

    private CashAmountManager cashAmountManager;
    private TextView cashAmountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        Log.d("TAG", "onCreate: from Q3");
        // Initialize CashAmountManager (if not already initialized)
        cashAmountManager = CashAmountManager.getInstance();

        // Retrieve the cash amount from the Intent
        int cashAmount = getIntent().getIntExtra("cashAmount", 0); // Default to 0 if not found

        // Find the EditText and display the cash amount
        cashAmountEditText = findViewById(R.id.cashAmount);
        cashAmountEditText.setText(String.valueOf(cashAmount));

        // Add the cash amount to CashAmountManager
        cashAmountManager.setCashAmount(cashAmount);
        playerData pd= playerData.getInstance(QuizActivity3.this);
//        Map<String,String> mp=new HashMap<>();
//        mp.put("name","John");
//        mp.put("email",pd.getEmail());
//        mp.put("score",cashAmount);
//        //current time in localDataTime format
//        mp.put("timestamp",LocalDateTime.now());
        Log.d("TAGFOR", "onCreate: "+pd.getEmail()+" "+cashAmount);
        ScoreDTO scoreDTO = new ScoreDTO("John", pd.getEmail(), cashAmount);
        Log.d("TAG2", "onCreate: "+LocalDateTime.now());
        Call<Map<String, String>> call = APIClient.Service().addScore(scoreDTO);
        call.enqueue(new Callback<Map<String, String>>() {
            @Override
            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                if(response.isSuccessful()){
                    for(Map.Entry<String,String> entry:response.body().entrySet()){
                        Log.d("Response",entry.getKey()+" "+entry.getValue());
                    }
                    Toast.makeText(QuizActivity3.this, "Score added to leaderboard", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(QuizActivity3.this, "Failed to add score to leaderboard", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Map<String, String>> call, Throwable t) {
                Log.e("RetrofitError", "Error sending score: " + t.getMessage());
                Toast.makeText(QuizActivity3.this, "Failed to add score to leaderboard2", Toast.LENGTH_SHORT).show();
            }
        });
        // Find the finish button and set an onClick listener
        Button finishButton = findViewById(R.id.finish);
        finishButton.setOnClickListener(v -> {
            // Example: Increment cash amount by 10 (adjust as per your logic)
            //cashAmountManager.incrementCashAmount(10);

            // Display "Hello" message when the button is clicked
            Toast.makeText(QuizActivity3.this, "Hello", Toast.LENGTH_SHORT).show();

            // Call Leaderboard activity
            startActivity(new Intent(QuizActivity3.this, LeaderBoard.class));
        });
    }
}

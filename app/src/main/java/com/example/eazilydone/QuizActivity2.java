package com.example.eazilydone;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity2 extends AppCompatActivity {
    private TextView timerTextView;
    private TextView questionTextView;
    private Button option1, option2, option3, option4, next;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 15000; // 15 seconds
    private int currentQuestionIndex = 0;
    private boolean optionSelected = false;
    private boolean isEnglish = true; // Default language is English


    private String[] questions = {
            "What is the main purpose of a budget?",
            "What is the difference between stocks and bonds?",
            "What does ROI stand for?",
            "What is the role of a central bank in an economy?",
            "What is inflation?",
            "What is the purpose of diversification in investment?",
            "What is GDP?",
            "What is a mutual fund?",
            "What is the function of a credit score?",
            "What is the time value of money?"
    };

    private String[][] options = {
            // Options for "What is the main purpose of a budget?"
            {"To plan and manage spending", "To track income", "To calculate taxes", "To invest in stocks"},

            // Options for "What is the difference between stocks and bonds?"
            {"Stocks represent ownership, while bonds are debt securities", "Stocks have higher risk than bonds", "Stocks are only traded on weekdays", "Bonds are more liquid than stocks"},

            // Options for "What does ROI stand for?"
            {"Return On Investment", "Revenue On Income", "Ratio Of Investment", "Risk Of Investment"},

            // Options for "What is the role of a central bank in an economy?"
            {"To regulate interest rates and monetary policy", "To supervise commercial banks", "To set fiscal policy", "To manage public debt"},

            // Options for "What is inflation?"
            {"A decrease in the purchasing power of money", "An increase in the value of assets", "A rise in interest rates", "A decrease in unemployment"},

            // Options for "What is the purpose of diversification in investment?"
            {"To spread risk across different assets", "To focus investments in one sector", "To maximize returns", "To minimize taxes"},

            // Options for "What is GDP?"
            {"Gross Domestic Product", "Gross Domestic Price", "General Development Process", "Government Development Policy"},

            // Options for "What is a mutual fund?"
            {"A pool of funds managed by professionals", "A type of stock exchange", "A government agency", "A financial regulation"},

            // Options for "What is the function of a credit score?"
            {"To assess creditworthiness for borrowing", "To determine eligibility for insurance", "To evaluate investment opportunities", "To calculate taxes"},

            // Options for "What is the time value of money?"
            {"The principle that a dollar today is worth more than a dollar in the future", "The concept of saving money over time", "The idea that money grows through investment", "The interest rate on loans"}
    };


    private String[] romanisedSinhalaQuestions = {
            "1. Budget ekak genada mukuth pradhana lakshya?",
            "2. Stocks saha bonds walata wenwima mokakda?",
            "3. ROI kiyannada mokadda?",
            "4. Maadhya bankuwak artha shastrayaka muladarma mokakda?",
            "5. Inflation kiyannada mokakda?",
            "6. Investment ekak karanata diversification genada mukuth prayojana?",
            "7. GDP kiyannada mokadda?",
            "8. Mutual fund kiyannada mokadda?",
            "9. Credit score ekak genada mukuth muladarma?",
            "10. Time value of money kiyannada mokadda?"
    };

    private String[][] romanisedSinhalaOptions =
            {
                    // Options for "Budget ekak genada mukuth pradhana lakshya?"
                    {"Wiyadam wedihimata sanda wiyadam karanna hekiya", "Adayum lakwima", "Badda gananaya kirima", "Stocks wala investment karanawa"},

                    // Options for "Stocks saha bonds walata wenwima mokakda?"
                    {"Stocks walin piyawara labena bawa, bonds araksha patreni", "Stocks wala risk wediyen bond wala", "Stocks kewwath rawume denne", "Bonds ithin thurunu wena bawa"},

                    // Options for "ROI kiyannada mokadda?"
                    {"Return On Investment", "Revenue On Income", "Ratio Of Investment", "Risk Of Investment"},

                    // Options for "Maadhya bankuwak artha shastrayaka muladarma mokakda?"
                    {"Padi araksha yuthu sadahasa saha maadhya artha shastraya pabandhawa", "Vyapara banku niyojana kara", "Rajya dharmaya niyojana kara", "Janatha nidhanaya paripalanaya kara"},

                    // Options for "Inflation kiyannada mokakda?"
                    {"Mudalayak diya galawimaya", "Araksha milaya wawenawa", "Ithuru lipi padi peramun wawenawa", "Wiyadam welawe adu wenawa"},

                    // Options for "Investment ekak karanata diversification genada mukuth prayojana?"
                    {"Vibhinna assa galapena wiwida kramaya", "Ekama kshetraya wiskam karanawa", "Prathyasha laba wedihimata karanawa", "Badda adu wenawa"},

                    // Options for "GDP kiyannada mokadda?"
                    {"Gross Domestic Product", "Gross Domestic Price", "General Development Process", "Government Development Policy"},

                    // Options for "Mutual fund kiyannada mokadda?"
                    {"Wisidamana pudgalayange mudalayak", "Stocks parisarayak", "Rajaya amathi sewaya", "Aarthika pabanduma"},

                    // Options for "Credit score ekak genada mukuth muladarma?"
                    {"Usas sadarana karanaya aduwana hekiyawa", "Insurance wiliyam patha karanna hoda", "Investment sawanayak balaanna", "Badda ganana kirima"},

                    // Options for "Time value of money kiyannada mokadda?"
                    {"Adha dolarinagathaya wayak kalaaya", "Kaaleen nidhanaya wiskam kalaaya", "Mudalayak araksha kalaya", "Loan padiya"}
            };



    private int[] correctAnswers = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private List<String> selectedQuestions;
    private List<String[]> selectedOptions;
    private List<Integer> selectedCorrectAnswers;

    private List<String> selectedRomanisedSinhalaQuestions;
    private List<String[]> selectedRomanisedSinhalaOptions;

    private int cashAmount = 0; // Initial cash amount
    private TextView cashAmountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        timerTextView = findViewById(R.id.timerTextView);
        questionTextView = findViewById(R.id.question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        next = findViewById(R.id.nextquestionbutton);
        cashAmountEditText = findViewById(R.id.cashAmount);
        // Initialize cash amount display
        updateCashAmountDisplay();



        //randomize questions
        selectRandomQuestions();

        //print questions and options to log both in English and Sinhala

        for (int i = 0; i < 5; i++) {
            Log.d("TAG", "onCreate: "+selectedQuestions.get(i));
            Log.d("TAG", "onCreate: "+selectedRomanisedSinhalaQuestions.get(i));
            for (int j = 0; j < 4; j++) {
                Log.d("TAG", "onCreate: "+selectedOptions.get(i)[j]);
                Log.d("TAG", "onCreate: "+selectedRomanisedSinhalaOptions.get(i)[j]);
            }
        }



        // Display the first question
        displayQuestion();

        // Set onClickListener for options
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle option selection
                handleOptionSelection(option1);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOptionSelection(option2);
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOptionSelection(option3);
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOptionSelection(option4);
            }
        });

        // Set onClickListener for next button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move to the next question or activity
                moveToNextQuestion();
            }
        });


        Button swapLanguageButton = findViewById(R.id.SwapLanguage);
        swapLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEnglish = !isEnglish; // Toggle the language flag
                displayQuestion(); // Refresh the question display with the new language
            }
        });

        Handler h=new Handler();
        Runnable r= new Runnable() {
            @Override
            public void run() {
                //print timeLeftInMillis
                Log.d("TAG", "run in runnable: "+timeLeftInMillis);


                if ( timeLeftInMillis==0){

                    Log.d("TAG", "run: came to option not Selected");
                    // User did not select an option within the time limit
                    // Hide all views except for LinearLayout
                    questionTextView.setVisibility(View.GONE);
                    option1.setVisibility(View.GONE);
                    option2.setVisibility(View.GONE);
                    option3.setVisibility(View.GONE);
                    option4.setVisibility(View.GONE);
                    next.setVisibility(View.GONE);

                    // Display "Timed out" message in the result TextView
                    TextView resultTextView = findViewById(R.id.resultTextView);
                    resultTextView.setText("Timed out");


                    // Display the result in LinearLayout
                    LinearLayout resultLayout = findViewById(R.id.result);
                    resultLayout.setVisibility(View.VISIBLE);

                    // Set onClickListener for the button inside LinearLayout to move to QuizActivity3
                    Button nextButton = resultLayout.findViewById(R.id.nextResult);


                    nextButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Hide the result layout
                            resultLayout.setVisibility(View.GONE);
                            // Navigate to QuizActivity3
                            //log entering to QuizActivity3
                            Log.d("TAG", "run: entering to QuizActivity3 because of time out");
                            Intent intent = new Intent(QuizActivity2.this, QuizActivity3.class);
                            startActivity(intent);
                            finish(); // Optional, to close QuizActivity2
                        }
                    });


                }

                else{
                    h.postDelayed(this, 16);
                }

            }
        };
        h.post(r);

    }

    private void updateCashAmountDisplay() {
        cashAmountEditText.setText(String.valueOf(cashAmount));
    }
    private void startTimer() {
        timeLeftInMillis = 15000; // Reset time left to initial value

        if (countDownTimer != null) {
            Log.d("TAG", "startTimer: hiii"+timeLeftInMillis);
            countDownTimer.cancel(); // Stop the existing timer
        }

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                // Timer finished, handle accordingly
                timeLeftInMillis = 0;
                updateCountdownText();
                // Implement your logic when the timer finishes
            }
        }.start();
    }

    private void updateCountdownText() {
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format("%02d:%02d", seconds / 60, seconds % 60);
        timerTextView.setText(timeLeftFormatted);
    }

    private void resetOptions(Button option) {
        // Reset background color
        option.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));

        // Reset selected state
        option.setSelected(false);

        // Reset font style and size
        option.setTypeface(null, Typeface.NORMAL);
        option.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10); // Initial text size
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void displayQuestion() {
        // Reset background color, selected state, font style, and size of all options
        resetOptions(option1);
        resetOptions(option2);
        resetOptions(option3);
        resetOptions(option4);

        if (currentQuestionIndex < selectedQuestions.size()) {
            updateQuestionText();
            // Reset optionSelected flag
            optionSelected = false;
            // Start or reset the timer
            startTimer();
        } else {
            //print cash amount earned upto know
            Log.d("TAG", "displayQuestion: Cash amount earned upto know: "+cashAmount);
            // No more questions, navigate to QuizActivity3
            Intent intent = new Intent(QuizActivity2.this, QuizActivity3.class);
            //pass the cash amount to the QuizActivity3
            intent.putExtra("cashAmount", cashAmount);
            startActivity(intent);
            finish(); // Optional, to close QuizActivity2
        }
    }

    private void updateQuestionText() {
        if (currentQuestionIndex < selectedQuestions.size()) {
            // Display the current question and options based on the current language
            if (isEnglish) {
                questionTextView.setText(selectedQuestions.get(currentQuestionIndex));
                option1.setText(selectedOptions.get(currentQuestionIndex)[0]);
                option2.setText(selectedOptions.get(currentQuestionIndex)[1]);
                option3.setText(selectedOptions.get(currentQuestionIndex)[2]);
                option4.setText(selectedOptions.get(currentQuestionIndex)[3]);
            } else {
                questionTextView.setText(selectedRomanisedSinhalaQuestions.get(currentQuestionIndex));
                option1.setText(selectedRomanisedSinhalaOptions.get(currentQuestionIndex)[0]);
                option2.setText(selectedRomanisedSinhalaOptions.get(currentQuestionIndex)[1]);
                option3.setText(selectedRomanisedSinhalaOptions.get(currentQuestionIndex)[2]);
                option4.setText(selectedRomanisedSinhalaOptions.get(currentQuestionIndex)[3]);
            }
        }
    }

    private void handleOptionSelection(Button option) {

        optionSelected = true;

        Log.d("TAG", "handleOptionSelection: came to handleOptionSelection");
        // Reset all options to enabled state
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);

        // Reset font style and size of all options
        option1.setTypeface(null, Typeface.NORMAL);
        option2.setTypeface(null, Typeface.NORMAL);
        option3.setTypeface(null, Typeface.NORMAL);
        option4.setTypeface(null, Typeface.NORMAL);
        option1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10); // Initial text size
        option2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        option3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        option4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

        // Reset background color of all options
        option1.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));
        option2.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));
        option3.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));
        option4.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));

        // Reset selected state of all options
        option1.setSelected(false);
        option2.setSelected(false);
        option3.setSelected(false);
        option4.setSelected(false);

        // Set font style and size for selected option
        option.setTypeface(null, Typeface.BOLD_ITALIC);
        option.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12); // Increased text size by 2sp

        // Highlight selected option
        option.setSelected(true);

        // Set background color for selected option
        option.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));


    }

    private void moveToNextQuestion() {
        optionSelected = false;
        //startTimer();
        // Check if there are more questions
        if (currentQuestionIndex < questions.length) {
            // Check if user has selected an option
            if (option1.isSelected() || option2.isSelected() || option3.isSelected() || option4.isSelected()) {
                // Check if user's selection matches the correct answer
                boolean isCorrect = false;
                switch (currentQuestionIndex) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        isCorrect = option1.isSelected() && correctAnswers[currentQuestionIndex] == 0 ||
                                option2.isSelected() && correctAnswers[currentQuestionIndex] == 1 ||
                                option3.isSelected() && correctAnswers[currentQuestionIndex] == 2 ||
                                option4.isSelected() && correctAnswers[currentQuestionIndex] == 3;
                        break;
                }

                // Display message based on correctness
                if (isCorrect) {
                    // Set text for the result TextView
                    TextView resultTextView = findViewById(R.id.resultTextView);
                    resultTextView.setText("Correct Answer!\nYou have earned Rs. 1000!");


                    Toast.makeText(getApplicationContext(), "Correct Answer!", Toast.LENGTH_SHORT).show();
                    cashAmount += 1000; // Increase the cash amount by 1000 for correct answer
                    //print cash amount
                    Log.d("TAG", "Cash amount earned upto know: "+cashAmount);
                }
                else {
                    //print cash amount
                    Log.d("TAG", "Cash amount earned upto know: "+cashAmount);
                    // Set text for the result TextView
                    TextView resultTextView = findViewById(R.id.resultTextView);
                    resultTextView.setText("Wrong Answer!");
                    //Stop the timer
                    countDownTimer.cancel();

                    // Hide all views except for LinearLayout
                    questionTextView.setVisibility(View.GONE);
                    option1.setVisibility(View.GONE);
                    option2.setVisibility(View.GONE);
                    option3.setVisibility(View.GONE);
                    option4.setVisibility(View.GONE);
                    next.setVisibility(View.GONE);

                    // Display the result in LinearLayout
                    LinearLayout resultLayout = findViewById(R.id.result);
                    resultLayout.setVisibility(View.VISIBLE);

                    //print entering to QuizActivity3
                    Log.d("TAG", "moveToNextQuestion: entering to QuizActivity3 because of wrong answer");

                    // Set onClickListener for the button inside LinearLayout to move to QuizActivity3
                    Button nextButton = resultLayout.findViewById(R.id.nextResult);
                    nextButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Hide the result layout
                            resultLayout.setVisibility(View.GONE);
                            // Navigate to QuizActivity3
                            Intent intent = new Intent(QuizActivity2.this, QuizActivity3.class);
                            //pass the cash amount to the QuizActivity3
                            intent.putExtra("cashAmount", cashAmount);
                            startActivity(intent);
                            finish(); // Optional, to close QuizActivity2
                        }
                    });

                    return; // Return to prevent further execution
                }

                // Hide all views except for LinearLayout
                questionTextView.setVisibility(View.GONE);
                option1.setVisibility(View.GONE);
                option2.setVisibility(View.GONE);
                option3.setVisibility(View.GONE);
                option4.setVisibility(View.GONE);
                next.setVisibility(View.GONE);

                // Display the result in LinearLayout
                LinearLayout resultLayout = findViewById(R.id.result);
                resultLayout.setVisibility(View.VISIBLE);

                // Set onClickListener for the button inside LinearLayout to move to the next question
                Button nextButton = resultLayout.findViewById(R.id.nextResult);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Hide the result layout
                        resultLayout.setVisibility(View.GONE);
                        // Show all views except for LinearLayout
                        questionTextView.setVisibility(View.VISIBLE);
                        option1.setVisibility(View.VISIBLE);
                        option2.setVisibility(View.VISIBLE);
                        option3.setVisibility(View.VISIBLE);
                        option4.setVisibility(View.VISIBLE);
                        next.setVisibility(View.VISIBLE);

                        // Move to the next question
                        currentQuestionIndex++;
                        //reset time
                        startTimer();
                        // Display the next question
                        displayQuestion();
                    }
                });
            }
            else {
                // User has not selected any option
                Toast.makeText(getApplicationContext(), "Please select an option", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            //print entering to QuizActivity3
            Log.d("TAG", "moveToNextQuestion: entering to QuizActivity3");
            // No more questions, navigate to QuizActivity3
            Intent intent = new Intent(QuizActivity2.this, QuizActivity3.class);
            startActivity(intent);
            finish(); // Optional, to close QuizActivity2
        }
        // Display the updated cash amount
        updateCashAmountDisplay();

    }

    private void selectRandomQuestions() {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);

        selectedQuestions = new ArrayList<>();
        selectedRomanisedSinhalaQuestions = new ArrayList<>();
        selectedOptions = new ArrayList<>();
        selectedRomanisedSinhalaOptions = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int index = indices.get(i);
            selectedQuestions.add(questions[index]);
            selectedRomanisedSinhalaQuestions.add(romanisedSinhalaQuestions[index]);
            selectedOptions.add(options[index]);
            selectedRomanisedSinhalaOptions.add(romanisedSinhalaOptions[index]);
        }
    }

}

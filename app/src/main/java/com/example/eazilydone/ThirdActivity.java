package com.example.eazilydone;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eazilydone.chatbot.chatBotActivity;

public class ThirdActivity extends AppCompatActivity {

    private View buttonsContainer;
    private View createAccountLayout;
    private Button closeCreateAccountLayoutButton;
    private Button clickToCreateAccountButton;
    private TextView cashAmountTextView; // Declare cashAmountTextView as a class member


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        // Initialize CashAmountManager (if not already initialized)
        CashAmountManager.getInstance();

        buttonsContainer = findViewById(R.id.buttonsContainer);
        createAccountLayout = findViewById(R.id.createAccountLayout);
        closeCreateAccountLayoutButton = findViewById(R.id.closeCreateAccountLayoutButton);
        clickToCreateAccountButton = findViewById(R.id.clickToCreateAccountButton);

        cashAmountTextView = findViewById(R.id.cashAmount);
        Button accountDetailsButton = findViewById(R.id.accountDetailsButton);
        Button createAccountButton = findViewById(R.id.createAccountButton);
        Button depositButton = findViewById(R.id.depositButton);
        Button withdrawButton = findViewById(R.id.withdrawButton);
        Button chatbotButton = findViewById(R.id.chatbotButton);
        ScrollView scrollView = findViewById(R.id.scrollView2);





        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "Deposit Selected", Toast.LENGTH_SHORT).show();
                // Implement action for Deposit by calling DepositActivity
                Intent intent = new Intent(ThirdActivity.this, DepositActivity.class);
                startActivity(intent);
            }
        });

        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "WithDraw Selected", Toast.LENGTH_SHORT).show();
                // Implement action for Deposit by calling DepositActivity
                Intent intent = new Intent(ThirdActivity.this, WithDraw.class);
                startActivity(intent);
            }
        });

        accountDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "Account Details Selected", Toast.LENGTH_SHORT).show();
                // Implement action for Account Details by calling AccountDetailsActivity
                Intent intent = new Intent(ThirdActivity.this, AccountDetailsActivity.class);
                startActivity(intent);
            }
        });
        chatbotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, chatBotActivity.class);
                startActivity(intent);
            }
        });


        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (scrollView.getChildAt(0).getBottom() <= (scrollView.getHeight() + scrollView.getScrollY())) {
                    // Scroll is at bottom, show clickToCreateAccountButton
                    clickToCreateAccountButton.setVisibility(View.VISIBLE);
                } else {
                    // Scroll is not at bottom, hide clickToCreateAccountButton
                    clickToCreateAccountButton.setVisibility(View.INVISIBLE);
                }
            }
        });

        clickToCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ThirdActivity.this, "Account creation process started", Toast.LENGTH_SHORT).show();
                //call CreateAccountActivity
                Intent intent = new Intent(ThirdActivity.this, CreateAccountActivity.class);
                startActivity(intent);
                // Perform actions to start the account creation process

            }
        });


        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsContainer.setVisibility(View.INVISIBLE);
                createAccountLayout.setVisibility(View.VISIBLE);
            }
        });



        closeCreateAccountLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccountLayout.setVisibility(View.INVISIBLE);
                buttonsContainer.setVisibility(View.VISIBLE);
            }
        });

        TextView textView = findViewById(R.id.accountTypesText);
        String text = "<font color='#008000'><b>Personal Account :-</b></font>" +
                "Personal accounts offer versatile management of day-to-day finances. They provide features like online banking and convenient access to funds.(Use ChatBot to know more)<br><br>" +
                "<font color='#008000'><b>Savings Account :-</b></font><br>" +
                "Savings accounts are ideal for setting aside money for future needs or emergencies. They often come with interest, helping your savings grow over time.(Use ChatBot to know more)<br><br>" +
                "<font color='#008000'><b>Checking Account :-</b></font><br>" +
                "Checking accounts are perfect for everyday transactions such as bill payments and purchases. They typically include a debit card and various banking conveniences.(Use ChatBot to know more)<br><br>" +
                "<font color='#008000'><b>Investment Account :-</b></font><br>" +
                "Investment accounts are tailored for growing your wealth through investments in stocks, bonds, and other assets. They offer the potential for higher returns over time.(Use ChatBot to know more)<br><br>" +
                "<font color='#008000'><b>Retirement Account :-</b></font><br>" +
                "Retirement accounts are essential for long-term financial planning. They provide tax advantages and often include employer contributions, helping you build a nest egg for retirement.(Use ChatBot to know more)<br><br>";


        textView.setText(Html.fromHtml(text));

        // Update cash amount initially
        updateCashAmount();

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

package com.example.eazilydone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    private ScrollView scrollViewCurrentAccounts, scrollViewSavingAccounts;
    private LinearLayout currentAccountOptions, savingAccountOptions;
    private FrameLayout rightFrameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccount);

        rightFrameLayout = findViewById(R.id.right_frame_layout);
        scrollViewCurrentAccounts = findViewById(R.id.scroll_view_current_accounts);
        scrollViewSavingAccounts = findViewById(R.id.scroll_view_saving_accounts);
        currentAccountOptions = findViewById(R.id.current_account_options);
        savingAccountOptions = findViewById(R.id.saving_account_options);

        final Button buttonCurrentAccount = findViewById(R.id.button_current_account);
        final Button buttonSavingAccount = findViewById(R.id.button_saving_account);

        Button PremiumCurrentAccount = findViewById(R.id.button_premium_current_account);
        Button StandardCurrentAccount = findViewById(R.id.button_standard_current_account);
        Button ForeignCurrencyAccount = findViewById(R.id.button_foreign_currency_account);




        Button RegularSavingAccount = findViewById(R.id.button_regular_savings_account);
        Button ZeroBalanceSavingAccount = findViewById(R.id.button_zero_balance_savings_account);
        Button KidsSavingAccount = findViewById(R.id.button_kids_savings_account);
        Button SalarySavingAccount = findViewById(R.id.button_salary_account);






        PremiumCurrentAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the premium savings account form layout
                LayoutInflater inflater = LayoutInflater.from(CreateAccountActivity.this);
                View premiumSavingsAccountFormView = inflater.inflate(R.layout.premium_current_account_form, rightFrameLayout, false);

                // Clear existing views in the rightFrameLayout
                rightFrameLayout.removeAllViews();

                // Add the inflated layout to rightFrameLayout
                rightFrameLayout.addView(premiumSavingsAccountFormView);
            }
        });
        StandardCurrentAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the standard savings account form layout
                LayoutInflater inflater = LayoutInflater.from(CreateAccountActivity.this);
                View standardSavingsAccountFormView = inflater.inflate(R.layout.standard_current_account_form, rightFrameLayout, false);

                // Clear existing views in the rightFrameLayout
                rightFrameLayout.removeAllViews();

                // Add the inflated layout to rightFrameLayout
                rightFrameLayout.addView(standardSavingsAccountFormView);
            }
        });
//        PackagedCurrentAccount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Inflate the packaged savings account form layout
//                LayoutInflater inflater = LayoutInflater.from(CreateAccountActivity.this);
//                View packagedSavingsAccountFormView = inflater.inflate(R.layout.packaged_current_account_form, rightFrameLayout, false);
//
//                // Clear existing views in the rightFrameLayout
//                rightFrameLayout.removeAllViews();
//
//                // Add the inflated layout to rightFrameLayout
//                rightFrameLayout.addView(packagedSavingsAccountFormView);
//            }
//        });
        ForeignCurrencyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the foreign currency account form layout
                LayoutInflater inflater = LayoutInflater.from(CreateAccountActivity.this);
                View foreignCurrencyAccountFormView = inflater.inflate(R.layout.foreign_currency_account_form, rightFrameLayout, false);

                // Clear existing views in the rightFrameLayout
                rightFrameLayout.removeAllViews();

                // Add the inflated layout to rightFrameLayout
                rightFrameLayout.addView(foreignCurrencyAccountFormView);
            }
        });

//        SingleColumnCashBook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Inflate the single column cash book form layout
//                LayoutInflater inflater = LayoutInflater.from(CreateAccountActivity.this);
//                View singleColumnCashBookFormView = inflater.inflate(R.layout.single_column_cash_book_form, rightFrameLayout, false);
//
//                // Clear existing views in the rightFrameLayout
//                rightFrameLayout.removeAllViews();
//
//                // Add the inflated layout to rightFrameLayout
//                rightFrameLayout.addView(singleColumnCashBookFormView);
//            }
//        });


    //from here savings account



        RegularSavingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the savings account form layout
                LayoutInflater inflater = LayoutInflater.from(CreateAccountActivity.this);
                View savingsAccountFormView = inflater.inflate(R.layout.regular_savings_account_form, rightFrameLayout, false);

                // Clear existing views in the rightFrameLayout
                rightFrameLayout.removeAllViews();

                // Add the inflated layout to rightFrameLayout
                rightFrameLayout.addView(savingsAccountFormView);
            }
        });
        ZeroBalanceSavingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the savings account form layout
                LayoutInflater inflater = LayoutInflater.from(CreateAccountActivity.this);
                View savingsAccountFormView = inflater.inflate(R.layout.zero_balance_savings_account_form, rightFrameLayout, false);

                // Clear existing views in the rightFrameLayout
                rightFrameLayout.removeAllViews();

                // Add the inflated layout to rightFrameLayout
                rightFrameLayout.addView(savingsAccountFormView);
            }
        });
        KidsSavingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the savings account form layout
                LayoutInflater inflater = LayoutInflater.from(CreateAccountActivity.this);
                View savingsAccountFormView = inflater.inflate(R.layout.kids_savings_account_form, rightFrameLayout, false);

                // Clear existing views in the rightFrameLayout
                rightFrameLayout.removeAllViews();

                // Add the inflated layout to rightFrameLayout
                rightFrameLayout.addView(savingsAccountFormView);
            }
        });
        SalarySavingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the savings account form layout
                LayoutInflater inflater = LayoutInflater.from(CreateAccountActivity.this);
                View savingsAccountFormView = inflater.inflate(R.layout.salary_account_form, rightFrameLayout, false);

                // Clear existing views in the rightFrameLayout
                rightFrameLayout.removeAllViews();

                // Add the inflated layout to rightFrameLayout
                rightFrameLayout.addView(savingsAccountFormView);
            }
        });







        buttonCurrentAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility of current account options
                if (currentAccountOptions.getVisibility() == View.VISIBLE) {
                    currentAccountOptions.setVisibility(View.GONE);
                    scrollViewCurrentAccounts.setVisibility(View.GONE);
                } else {
                    currentAccountOptions.setVisibility(View.VISIBLE);
                    savingAccountOptions.setVisibility(View.GONE);
                    scrollViewCurrentAccounts.setVisibility(View.VISIBLE);
                    scrollViewSavingAccounts.setVisibility(View.GONE);
                    scrollViewCurrentAccounts.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollViewCurrentAccounts.scrollTo(0, 0);
                        }
                    });
                }
            }
        });
        buttonSavingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility of saving account options
                if (savingAccountOptions.getVisibility() == View.VISIBLE) {
                    savingAccountOptions.setVisibility(View.GONE);
                    scrollViewSavingAccounts.setVisibility(View.GONE);
                } else {
                    savingAccountOptions.setVisibility(View.VISIBLE);
                    currentAccountOptions.setVisibility(View.GONE);
                    scrollViewSavingAccounts.setVisibility(View.VISIBLE);
                    scrollViewCurrentAccounts.setVisibility(View.GONE);
                    scrollViewSavingAccounts.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollViewSavingAccounts.scrollTo(0, 0);
                        }
                    });
                }
            }
        });

        // Initialize with both options hidden
        currentAccountOptions.setVisibility(View.GONE);
        savingAccountOptions.setVisibility(View.GONE);
        scrollViewCurrentAccounts.setVisibility(View.GONE);
        scrollViewSavingAccounts.setVisibility(View.GONE);
    }
}

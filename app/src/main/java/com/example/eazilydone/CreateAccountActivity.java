package com.example.eazilydone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


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
                // Create a new instance of PremiumCurrentFragment
                PremiumAccountFragment fragment = new PremiumAccountFragment();

                // Replace the current content of rightFrameLayout with the fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.right_frame_layout, fragment)
                        .addToBackStack(null)  // Optional: This allows the user to navigate back to the previous fragment
                        .commit();
            }
        });





        StandardCurrentAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of StandardCurrentAccountFragment
                StandardCurrentAccountFragment fragment = new StandardCurrentAccountFragment();

                // Replace the current content of rightFrameLayout with the fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.right_frame_layout, fragment)
                        .addToBackStack(null)  // Optional: This allows the user to navigate back to the previous fragment
                        .commit();
            }
        });
        ForeignCurrencyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of ForeignCurrencyAccountFragment
                ForeignCurrencyAccountFragment fragment = new ForeignCurrencyAccountFragment();

                // Replace the current content of rightFrameLayout with the fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.right_frame_layout, fragment)
                        .addToBackStack(null)  // Optional: This allows the user to navigate back to the previous fragment
                        .commit();
            }
        });


        RegularSavingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of RegularSavingAccountFragment
                RegularSavingAccountFragment fragment = new RegularSavingAccountFragment();

                // Replace the current content of rightFrameLayout with the fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.right_frame_layout, fragment)
                        .addToBackStack(null)  // Optional: This allows the user to navigate back to the previous fragment
                        .commit();
            }
        });
        ZeroBalanceSavingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of ZeroBalanceSavingAccountFragment
                ZeroBalanceSavingAccountFragment fragment = new ZeroBalanceSavingAccountFragment();

                // Replace the current content of rightFrameLayout with the fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.right_frame_layout, fragment)
                        .addToBackStack(null)  // Optional: This allows the user to navigate back to the previous fragment
                        .commit();
            }
        });
        KidsSavingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of KidsSavingAccountFragment
                KidsSavingAccountFragment fragment = new KidsSavingAccountFragment();

                // Replace the current content of rightFrameLayout with the fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.right_frame_layout, fragment)
                        .addToBackStack(null)  // Optional: This allows the user to navigate back to the previous fragment
                        .commit();
            }
        });
        SalarySavingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of SalarySavingAccountFragment
                SalarySavingAccountFragment fragment = new SalarySavingAccountFragment();

                // Replace the current content of rightFrameLayout with the fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.right_frame_layout, fragment)
                        .addToBackStack(null)  // Optional: This allows the user to navigate back to the previous fragment
                        .commit();
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

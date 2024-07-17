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
                // Create a new instance of PremiumCurrentAccountFragment
                PremiumCurrentAccountFragment fragment = new PremiumCurrentAccountFragment();

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



    public static class PremiumCurrentAccountFragment extends Fragment {

        private EditText accountHolderName, phoneNumber, email, initialDeposit;
        private Spinner countryCodeSpinner;
        private Button submitButton;
        private CheckBox agreementCheckbox;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.premium_current_account_form, container, false);

            // Initialize UI components
            accountHolderName = rootView.findViewById(R.id.accountHolderName);
            phoneNumber = rootView.findViewById(R.id.phoneNumber);
            email = rootView.findViewById(R.id.email);
            initialDeposit = rootView.findViewById(R.id.initialDeposit);
            countryCodeSpinner = rootView.findViewById(R.id.countryCodeSpinner);
            submitButton = rootView.findViewById(R.id.submitButton);
            agreementCheckbox = rootView.findViewById(R.id.agreementCheckbox);

            // Array of country codes
            String[] countryCodes = {"+91 (India)", "+1 (USA)", "+44 (UK)", "+61 (Australia)", "+81 (Japan)",
                    "+86 (China)", "+49 (Germany)", "+33 (France)", "+55 (Brazil)", "+27 (South Africa)", "+94 (Sri Lanka)"};

            // Setting up the Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, countryCodes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            countryCodeSpinner.setAdapter(adapter);

            // Set OnClickListener for submitButton
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitForm();
                }
            });

            return rootView;
        }

        private void submitForm() {
            String name = accountHolderName.getText().toString();
            String phone = phoneNumber.getText().toString();
            String emailText = email.getText().toString();
            String deposit = initialDeposit.getText().toString();
            String countryCode = countryCodeSpinner.getSelectedItem().toString();

            // Get the current date and time
            String currentDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

            // Log the values
            Log.d("SalarySavingAccountFragment", "Account Holder Name: " + name);
            Log.d("SalarySavingAccountFragment", "Phone Number: " + phone);
            Log.d("SalarySavingAccountFragment", "Email: " + emailText);
            Log.d("SalarySavingAccountFragment", "Initial Deposit: " + deposit);
            Log.d("SalarySavingAccountFragment", "Country Code: " + countryCode);
            Log.d("SalarySavingAccountFragment", "Date and Time: " + currentDateAndTime);

            // Check if the checkbox is selected
            if (!agreementCheckbox.isChecked()) {
                Toast.makeText(requireContext(), "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate name: only letters (and spaces)
            if (!name.matches("[a-zA-Z ]+")) {
                Toast.makeText(requireContext(), "Name should only contain letters and spaces", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate phone number: exactly 10 digits
            if (!phone.matches("\\d{10}")) {
                Toast.makeText(requireContext(), "Phone number should be exactly 10 digits", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate email: should contain @
            if (!emailText.contains("@")) {
                Toast.makeText(requireContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                return;
            }

            // Perform further validation and submission logic here
            if (name.isEmpty() || phone.isEmpty() || emailText.isEmpty() || deposit.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Log saying form submitted successfully
            Log.d("SalarySavingAccountFragment", "Form submitted successfully");

            // Show a success message
            Toast.makeText(requireContext(), "Form submitted successfully", Toast.LENGTH_SHORT).show();

            // Start SendtoDB activity and send user details
            Intent intent = new Intent(getActivity(), SendtoDB.class);
            intent.putExtra("name", name);
            intent.putExtra("phone", phone);
            intent.putExtra("email", emailText);
            intent.putExtra("deposit", deposit);
            intent.putExtra("countryCode", countryCode);
            intent.putExtra("dateAndTime", currentDateAndTime);
            startActivity(intent);
        }
    }
    public static class ForeignCurrencyAccountFragment extends Fragment {

        private EditText accountHolderName, phoneNumber, email, initialDeposit;
        private Spinner countryCodeSpinner;
        private Button submitButton;
        private CheckBox agreementCheckbox;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.foreign_currency_account_form, container, false);

            // Initialize UI components
            accountHolderName = rootView.findViewById(R.id.accountHolderName);
            phoneNumber = rootView.findViewById(R.id.phoneNumber);
            email = rootView.findViewById(R.id.email);
            initialDeposit = rootView.findViewById(R.id.initialDeposit);
            countryCodeSpinner = rootView.findViewById(R.id.countryCodeSpinner);
            submitButton = rootView.findViewById(R.id.submitButton);
            agreementCheckbox = rootView.findViewById(R.id.agreementCheckbox);

            // Array of country codes
            String[] countryCodes = {"+91 (India)", "+1 (USA)", "+44 (UK)", "+61 (Australia)", "+81 (Japan)",
                    "+86 (China)", "+49 (Germany)", "+33 (France)", "+55 (Brazil)", "+27 (South Africa)", "+94 (Sri Lanka)"};

            // Setting up the Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, countryCodes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            countryCodeSpinner.setAdapter(adapter);

            // Set OnClickListener for submitButton
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitForm();
                }
            });

            return rootView;
        }

        private void submitForm() {
            String name = accountHolderName.getText().toString();
            String phone = phoneNumber.getText().toString();
            String emailText = email.getText().toString();
            String deposit = initialDeposit.getText().toString();
            String countryCode = countryCodeSpinner.getSelectedItem().toString();

            // Get the current date and time
            String currentDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

            // Log the values
            Log.d("SalarySavingAccountFragment", "Account Holder Name: " + name);
            Log.d("SalarySavingAccountFragment", "Phone Number: " + phone);
            Log.d("SalarySavingAccountFragment", "Email: " + emailText);
            Log.d("SalarySavingAccountFragment", "Initial Deposit: " + deposit);
            Log.d("SalarySavingAccountFragment", "Country Code: " + countryCode);
            Log.d("SalarySavingAccountFragment", "Date and Time: " + currentDateAndTime);

            // Check if the checkbox is selected
            if (!agreementCheckbox.isChecked()) {
                Toast.makeText(requireContext(), "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate name: only letters (and spaces)
            if (!name.matches("[a-zA-Z ]+")) {
                Toast.makeText(requireContext(), "Name should only contain letters and spaces", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate phone number: exactly 10 digits
            if (!phone.matches("\\d{10}")) {
                Toast.makeText(requireContext(), "Phone number should be exactly 10 digits", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate email: should contain @
            if (!emailText.contains("@")) {
                Toast.makeText(requireContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                return;
            }

            // Perform further validation and submission logic here
            if (name.isEmpty() || phone.isEmpty() || emailText.isEmpty() || deposit.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Log saying form submitted successfully
            Log.d("SalarySavingAccountFragment", "Form submitted successfully");

            // Show a success message
            Toast.makeText(requireContext(), "Form submitted successfully", Toast.LENGTH_SHORT).show();

            // Start SendtoDB activity and send user details
            Intent intent = new Intent(getActivity(), SendtoDB.class);
            intent.putExtra("name", name);
            intent.putExtra("phone", phone);
            intent.putExtra("email", emailText);
            intent.putExtra("deposit", deposit);
            intent.putExtra("countryCode", countryCode);
            intent.putExtra("dateAndTime", currentDateAndTime);
            startActivity(intent);
        }
    }
    public static class StandardCurrentAccountFragment extends Fragment {

        private EditText accountHolderName, phoneNumber, email, initialDeposit;
        private Spinner countryCodeSpinner;
        private Button submitButton;
        private CheckBox agreementCheckbox;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.standard_current_account_form, container, false);

            // Initialize UI components
            accountHolderName = rootView.findViewById(R.id.accountHolderName);
            phoneNumber = rootView.findViewById(R.id.phoneNumber);
            email = rootView.findViewById(R.id.email);
            initialDeposit = rootView.findViewById(R.id.initialDeposit);
            countryCodeSpinner = rootView.findViewById(R.id.countryCodeSpinner);
            submitButton = rootView.findViewById(R.id.submitButton);
            agreementCheckbox = rootView.findViewById(R.id.agreementCheckbox);

            // Array of country codes
            String[] countryCodes = {"+91 (India)", "+1 (USA)", "+44 (UK)", "+61 (Australia)", "+81 (Japan)",
                    "+86 (China)", "+49 (Germany)", "+33 (France)", "+55 (Brazil)", "+27 (South Africa)", "+94 (Sri Lanka)"};

            // Setting up the Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, countryCodes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            countryCodeSpinner.setAdapter(adapter);

            // Set OnClickListener for submitButton
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitForm();
                }
            });

            return rootView;
        }

        private void submitForm() {
            String name = accountHolderName.getText().toString();
            String phone = phoneNumber.getText().toString();
            String emailText = email.getText().toString();
            String deposit = initialDeposit.getText().toString();
            String countryCode = countryCodeSpinner.getSelectedItem().toString();

            // Get the current date and time
            String currentDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

            // Log the values
            Log.d("SalarySavingAccountFragment", "Account Holder Name: " + name);
            Log.d("SalarySavingAccountFragment", "Phone Number: " + phone);
            Log.d("SalarySavingAccountFragment", "Email: " + emailText);
            Log.d("SalarySavingAccountFragment", "Initial Deposit: " + deposit);
            Log.d("SalarySavingAccountFragment", "Country Code: " + countryCode);
            Log.d("SalarySavingAccountFragment", "Date and Time: " + currentDateAndTime);

            // Check if the checkbox is selected
            if (!agreementCheckbox.isChecked()) {
                Toast.makeText(requireContext(), "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate name: only letters (and spaces)
            if (!name.matches("[a-zA-Z ]+")) {
                Toast.makeText(requireContext(), "Name should only contain letters and spaces", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate phone number: exactly 10 digits
            if (!phone.matches("\\d{10}")) {
                Toast.makeText(requireContext(), "Phone number should be exactly 10 digits", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate email: should contain @
            if (!emailText.contains("@")) {
                Toast.makeText(requireContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                return;
            }

            // Perform further validation and submission logic here
            if (name.isEmpty() || phone.isEmpty() || emailText.isEmpty() || deposit.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Log saying form submitted successfully
            Log.d("SalarySavingAccountFragment", "Form submitted successfully");

            // Show a success message
            Toast.makeText(requireContext(), "Form submitted successfully", Toast.LENGTH_SHORT).show();

            // Start SendtoDB activity and send user details
            Intent intent = new Intent(getActivity(), SendtoDB.class);
            intent.putExtra("name", name);
            intent.putExtra("phone", phone);
            intent.putExtra("email", emailText);
            intent.putExtra("deposit", deposit);
            intent.putExtra("countryCode", countryCode);
            intent.putExtra("dateAndTime", currentDateAndTime);
            startActivity(intent);
        }
    }




    public static class RegularSavingAccountFragment extends Fragment {

        private EditText accountHolderName, phoneNumber, email, initialDeposit;
        private Spinner countryCodeSpinner;
        private Button submitButton;
        private CheckBox agreementCheckbox;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.regular_savings_account_form, container, false);

            // Initialize UI components
            accountHolderName = rootView.findViewById(R.id.accountHolderName);
            phoneNumber = rootView.findViewById(R.id.phoneNumber);
            email = rootView.findViewById(R.id.email);
            initialDeposit = rootView.findViewById(R.id.initialDeposit);
            countryCodeSpinner = rootView.findViewById(R.id.countryCodeSpinner);
            submitButton = rootView.findViewById(R.id.submitButton);
            agreementCheckbox = rootView.findViewById(R.id.agreementCheckbox);

            // Array of country codes
            String[] countryCodes = {"+91 (India)", "+1 (USA)", "+44 (UK)", "+61 (Australia)", "+81 (Japan)",
                    "+86 (China)", "+49 (Germany)", "+33 (France)", "+55 (Brazil)", "+27 (South Africa)", "+94 (Sri Lanka)"};

            // Setting up the Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, countryCodes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            countryCodeSpinner.setAdapter(adapter);

            // Set OnClickListener for submitButton
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitForm();
                }
            });

            return rootView;
        }

        private void submitForm() {
            String name = accountHolderName.getText().toString();
            String phone = phoneNumber.getText().toString();
            String emailText = email.getText().toString();
            String deposit = initialDeposit.getText().toString();
            String countryCode = countryCodeSpinner.getSelectedItem().toString();

            // Get the current date and time
            String currentDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

            // Log the values
            Log.d("SalarySavingAccountFragment", "Account Holder Name: " + name);
            Log.d("SalarySavingAccountFragment", "Phone Number: " + phone);
            Log.d("SalarySavingAccountFragment", "Email: " + emailText);
            Log.d("SalarySavingAccountFragment", "Initial Deposit: " + deposit);
            Log.d("SalarySavingAccountFragment", "Country Code: " + countryCode);
            Log.d("SalarySavingAccountFragment", "Date and Time: " + currentDateAndTime);

            // Check if the checkbox is selected
            if (!agreementCheckbox.isChecked()) {
                Toast.makeText(requireContext(), "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate name: only letters (and spaces)
            if (!name.matches("[a-zA-Z ]+")) {
                Toast.makeText(requireContext(), "Name should only contain letters and spaces", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate phone number: exactly 10 digits
            if (!phone.matches("\\d{10}")) {
                Toast.makeText(requireContext(), "Phone number should be exactly 10 digits", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate email: should contain @
            if (!emailText.contains("@")) {
                Toast.makeText(requireContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                return;
            }

            // Perform further validation and submission logic here
            if (name.isEmpty() || phone.isEmpty() || emailText.isEmpty() || deposit.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Log saying form submitted successfully
            Log.d("SalarySavingAccountFragment", "Form submitted successfully");

            // Show a success message
            Toast.makeText(requireContext(), "Form submitted successfully", Toast.LENGTH_SHORT).show();

            // Start SendtoDB activity and send user details
            Intent intent = new Intent(getActivity(), SendtoDB.class);
            intent.putExtra("name", name);
            intent.putExtra("phone", phone);
            intent.putExtra("email", emailText);
            intent.putExtra("deposit", deposit);
            intent.putExtra("countryCode", countryCode);
            intent.putExtra("dateAndTime", currentDateAndTime);
            startActivity(intent);
        }
    }
    public static class ZeroBalanceSavingAccountFragment extends Fragment {

        private EditText accountHolderName, phoneNumber, email, initialDeposit;
        private Spinner countryCodeSpinner;
        private Button submitButton;
        private CheckBox agreementCheckbox;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.zero_balance_savings_account_form, container, false);

            // Initialize UI components
            accountHolderName = rootView.findViewById(R.id.accountHolderName);
            phoneNumber = rootView.findViewById(R.id.phoneNumber);
            email = rootView.findViewById(R.id.email);
            initialDeposit = rootView.findViewById(R.id.initialDeposit);
            countryCodeSpinner = rootView.findViewById(R.id.countryCodeSpinner);
            submitButton = rootView.findViewById(R.id.submitButton);
            agreementCheckbox = rootView.findViewById(R.id.agreementCheckbox);

            // Array of country codes
            String[] countryCodes = {"+91 (India)", "+1 (USA)", "+44 (UK)", "+61 (Australia)", "+81 (Japan)",
                    "+86 (China)", "+49 (Germany)", "+33 (France)", "+55 (Brazil)", "+27 (South Africa)", "+94 (Sri Lanka)"};

            // Setting up the Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, countryCodes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            countryCodeSpinner.setAdapter(adapter);

            // Set OnClickListener for submitButton
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitForm();
                }
            });

            return rootView;
        }

        private void submitForm() {
            String name = accountHolderName.getText().toString();
            String phone = phoneNumber.getText().toString();
            String emailText = email.getText().toString();
            String deposit = initialDeposit.getText().toString();
            String countryCode = countryCodeSpinner.getSelectedItem().toString();

            // Get the current date and time
            String currentDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

            // Log the values
            Log.d("SalarySavingAccountFragment", "Account Holder Name: " + name);
            Log.d("SalarySavingAccountFragment", "Phone Number: " + phone);
            Log.d("SalarySavingAccountFragment", "Email: " + emailText);
            Log.d("SalarySavingAccountFragment", "Initial Deposit: " + deposit);
            Log.d("SalarySavingAccountFragment", "Country Code: " + countryCode);
            Log.d("SalarySavingAccountFragment", "Date and Time: " + currentDateAndTime);

            // Check if the checkbox is selected
            if (!agreementCheckbox.isChecked()) {
                Toast.makeText(requireContext(), "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate name: only letters (and spaces)
            if (!name.matches("[a-zA-Z ]+")) {
                Toast.makeText(requireContext(), "Name should only contain letters and spaces", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate phone number: exactly 10 digits
            if (!phone.matches("\\d{10}")) {
                Toast.makeText(requireContext(), "Phone number should be exactly 10 digits", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate email: should contain @
            if (!emailText.contains("@")) {
                Toast.makeText(requireContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                return;
            }

            // Perform further validation and submission logic here
            if (name.isEmpty() || phone.isEmpty() || emailText.isEmpty() || deposit.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Log saying form submitted successfully
            Log.d("SalarySavingAccountFragment", "Form submitted successfully");

            // Show a success message
            Toast.makeText(requireContext(), "Form submitted successfully", Toast.LENGTH_SHORT).show();

            // Start SendtoDB activity and send user details
            Intent intent = new Intent(getActivity(), SendtoDB.class);
            intent.putExtra("name", name);
            intent.putExtra("phone", phone);
            intent.putExtra("email", emailText);
            intent.putExtra("deposit", deposit);
            intent.putExtra("countryCode", countryCode);
            intent.putExtra("dateAndTime", currentDateAndTime);
            startActivity(intent);
        }
    }
    public static class KidsSavingAccountFragment extends Fragment {

        private EditText accountHolderName, phoneNumber, email, initialDeposit;
        private Spinner countryCodeSpinner;
        private Button submitButton;
        private CheckBox agreementCheckbox;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.kids_savings_account_form, container, false);

            // Initialize UI components
            accountHolderName = rootView.findViewById(R.id.accountHolderName);
            phoneNumber = rootView.findViewById(R.id.phoneNumber);
            email = rootView.findViewById(R.id.email);
            initialDeposit = rootView.findViewById(R.id.initialDeposit);
            countryCodeSpinner = rootView.findViewById(R.id.countryCodeSpinner);
            submitButton = rootView.findViewById(R.id.submitButton);
            agreementCheckbox = rootView.findViewById(R.id.agreementCheckbox);

            // Array of country codes
            String[] countryCodes = {"+91 (India)", "+1 (USA)", "+44 (UK)", "+61 (Australia)", "+81 (Japan)",
                    "+86 (China)", "+49 (Germany)", "+33 (France)", "+55 (Brazil)", "+27 (South Africa)", "+94 (Sri Lanka)"};

            // Setting up the Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, countryCodes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            countryCodeSpinner.setAdapter(adapter);

            // Set OnClickListener for submitButton
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitForm();
                }
            });

            return rootView;
        }

        private void submitForm() {
            String name = accountHolderName.getText().toString();
            String phone = phoneNumber.getText().toString();
            String emailText = email.getText().toString();
            String deposit = initialDeposit.getText().toString();
            String countryCode = countryCodeSpinner.getSelectedItem().toString();

            // Get the current date and time
            String currentDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

            // Log the values
            Log.d("SalarySavingAccountFragment", "Account Holder Name: " + name);
            Log.d("SalarySavingAccountFragment", "Phone Number: " + phone);
            Log.d("SalarySavingAccountFragment", "Email: " + emailText);
            Log.d("SalarySavingAccountFragment", "Initial Deposit: " + deposit);
            Log.d("SalarySavingAccountFragment", "Country Code: " + countryCode);
            Log.d("SalarySavingAccountFragment", "Date and Time: " + currentDateAndTime);

            // Check if the checkbox is selected
            if (!agreementCheckbox.isChecked()) {
                Toast.makeText(requireContext(), "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate name: only letters (and spaces)
            if (!name.matches("[a-zA-Z ]+")) {
                Toast.makeText(requireContext(), "Name should only contain letters and spaces", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate phone number: exactly 10 digits
            if (!phone.matches("\\d{10}")) {
                Toast.makeText(requireContext(), "Phone number should be exactly 10 digits", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate email: should contain @
            if (!emailText.contains("@")) {
                Toast.makeText(requireContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                return;
            }

            // Perform further validation and submission logic here
            if (name.isEmpty() || phone.isEmpty() || emailText.isEmpty() || deposit.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Log saying form submitted successfully
            Log.d("SalarySavingAccountFragment", "Form submitted successfully");

            // Show a success message
            Toast.makeText(requireContext(), "Form submitted successfully", Toast.LENGTH_SHORT).show();

            // Start SendtoDB activity and send user details
            Intent intent = new Intent(getActivity(), SendtoDB.class);
            intent.putExtra("name", name);
            intent.putExtra("phone", phone);
            intent.putExtra("email", emailText);
            intent.putExtra("deposit", deposit);
            intent.putExtra("countryCode", countryCode);
            intent.putExtra("dateAndTime", currentDateAndTime);
            startActivity(intent);
        }
    }

//    public static class SalarySavingAccountFragment extends Fragment {
//
//        private EditText accountHolderName, phoneNumber, email, initialDeposit;
//        private Spinner countryCodeSpinner;
//        private Button submitButton;
//        private CheckBox agreementCheckbox;
//
//        @Nullable
//        @Override
//        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.salary_account_form, container, false);
//
//            // Initialize UI components
//            accountHolderName = rootView.findViewById(R.id.accountHolderName);
//            phoneNumber = rootView.findViewById(R.id.phoneNumber);
//            email = rootView.findViewById(R.id.email);
//            initialDeposit = rootView.findViewById(R.id.initialDeposit);
//            countryCodeSpinner = rootView.findViewById(R.id.countryCodeSpinner);
//            submitButton = rootView.findViewById(R.id.submitButton);
//            agreementCheckbox = rootView.findViewById(R.id.agreementCheckbox);
//
//            // Array of country codes
//            String[] countryCodes = {"+91 (India)", "+1 (USA)", "+44 (UK)", "+61 (Australia)", "+81 (Japan)",
//                    "+86 (China)", "+49 (Germany)", "+33 (France)", "+55 (Brazil)", "+27 (South Africa)", "+94 (Sri Lanka)"};
//
//            // Setting up the Spinner
//            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, countryCodes);
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            countryCodeSpinner.setAdapter(adapter);
//
//            // Set OnClickListener for submitButton
//            submitButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    submitForm();
//                }
//            });
//
//            return rootView;
//        }
//
//        private void submitForm() {
//            String name = accountHolderName.getText().toString();
//            String phone = phoneNumber.getText().toString();
//            String emailText = email.getText().toString();
//            String deposit = initialDeposit.getText().toString();
//            String countryCode = countryCodeSpinner.getSelectedItem().toString();
//
//            // Log the values
//            Log.d("SalarySavingAccountFragment", "Account Holder Name: " + name);
//            Log.d("SalarySavingAccountFragment", "Phone Number: " + phone);
//            Log.d("SalarySavingAccountFragment", "Email: " + emailText);
//            Log.d("SalarySavingAccountFragment", "Initial Deposit: " + deposit);
//            Log.d("SalarySavingAccountFragment", "Country Code: " + countryCode);
//
//            // Check if the checkbox is selected
//            if (!agreementCheckbox.isChecked()) {
//                Toast.makeText(requireContext(), "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            // Validate name: only letters (and spaces)
//            if (!name.matches("[a-zA-Z ]+")) {
//                Toast.makeText(requireContext(), "Name should only contain letters and spaces", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            // Validate phone number: exactly 10 digits
//            if (!phone.matches("\\d{10}")) {
//                Toast.makeText(requireContext(), "Phone number should be exactly 10 digits", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            // Validate email: should contain @
//            if (!emailText.contains("@")) {
//                Toast.makeText(requireContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            // Perform further validation and submission logic here
//            if (name.isEmpty() || phone.isEmpty() || emailText.isEmpty() || deposit.isEmpty()) {
//                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            // Log saying form submitted successfully
//            Log.d("SalarySavingAccountFragment", "Form submitted successfully");
//
//            // Show a success message
//            Toast.makeText(requireContext(), "Form submitted successfully", Toast.LENGTH_SHORT).show();
//
//
//            // Start SendtoDB activity and send user details
//            Intent intent = new Intent(getActivity(), SendtoDB.class);
//            intent.putExtra("name", name);
//            intent.putExtra("phone", phone);
//            intent.putExtra("email", emailText);
//            intent.putExtra("deposit", deposit);
//            intent.putExtra("countryCode", countryCode);
//            startActivity(intent);
//        }
//
//
//    }

    public static class SalarySavingAccountFragment extends Fragment{

        private EditText accountHolderName, phoneNumber, email, initialDeposit;
        private Spinner countryCodeSpinner;
        private Button submitButton;
        private CheckBox agreementCheckbox;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.salary_account_form, container, false);

            // Initialize UI components
            accountHolderName = rootView.findViewById(R.id.accountHolderName);
            phoneNumber = rootView.findViewById(R.id.phoneNumber);
            email = rootView.findViewById(R.id.email);
            initialDeposit = rootView.findViewById(R.id.initialDeposit);
            countryCodeSpinner = rootView.findViewById(R.id.countryCodeSpinner);
            submitButton = rootView.findViewById(R.id.submitButton);
            agreementCheckbox = rootView.findViewById(R.id.agreementCheckbox);

            // Array of country codes
            String[] countryCodes = {"+91 (India)", "+1 (USA)", "+44 (UK)", "+61 (Australia)", "+81 (Japan)",
                    "+86 (China)", "+49 (Germany)", "+33 (France)", "+55 (Brazil)", "+27 (South Africa)", "+94 (Sri Lanka)"};

            // Setting up the Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, countryCodes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            countryCodeSpinner.setAdapter(adapter);

            // Set OnClickListener for submitButton
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitForm();
                }
            });

            return rootView;
        }

        private void submitForm() {
            String name = accountHolderName.getText().toString();
            String phone = phoneNumber.getText().toString();
            String emailText = email.getText().toString();
            String deposit = initialDeposit.getText().toString();
            String countryCode = countryCodeSpinner.getSelectedItem().toString();

            // Get the current date and time
            String currentDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

            // Log the values
            Log.d("SalarySavingAccountFragment", "Account Holder Name: " + name);
            Log.d("SalarySavingAccountFragment", "Phone Number: " + phone);
            Log.d("SalarySavingAccountFragment", "Email: " + emailText);
            Log.d("SalarySavingAccountFragment", "Initial Deposit: " + deposit);
            Log.d("SalarySavingAccountFragment", "Country Code: " + countryCode);
            Log.d("SalarySavingAccountFragment", "Date and Time: " + currentDateAndTime);

            // Check if the checkbox is selected
            if (!agreementCheckbox.isChecked()) {
                Toast.makeText(requireContext(), "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate name: only letters (and spaces)
            if (!name.matches("[a-zA-Z ]+")) {
                Toast.makeText(requireContext(), "Name should only contain letters and spaces", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate phone number: exactly 10 digits
            if (!phone.matches("\\d{10}")) {
                Toast.makeText(requireContext(), "Phone number should be exactly 10 digits", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate email: should contain @
            if (!emailText.contains("@")) {
                Toast.makeText(requireContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                return;
            }

            // Perform further validation and submission logic here
            if (name.isEmpty() || phone.isEmpty() || emailText.isEmpty() || deposit.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Log saying form submitted successfully
            Log.d("SalarySavingAccountFragment", "Form submitted successfully");

            // Show a success message
            Toast.makeText(requireContext(), "Form submitted successfully", Toast.LENGTH_SHORT).show();

            // Start SendtoDB activity and send user details
            Intent intent = new Intent(getActivity(), SendtoDB.class);
            intent.putExtra("name", name);
            intent.putExtra("phone", phone);
            intent.putExtra("email", emailText);
            intent.putExtra("deposit", deposit);
            intent.putExtra("countryCode", countryCode);
            intent.putExtra("dateAndTime", currentDateAndTime);
            startActivity(intent);
        }
    }



}

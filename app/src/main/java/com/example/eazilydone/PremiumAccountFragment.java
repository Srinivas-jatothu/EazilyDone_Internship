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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PremiumAccountFragment extends Fragment {

    private EditText accountHolderName, phoneNumber, email, initialDeposit, pin;
    private Spinner countryCodeSpinner;
    private Button submitButton;
    private CheckBox agreementCheckbox;
    private TextView cashAmountTextView; // Declare cashAmountTextView as a class member

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.premium_current_account_form, container, false);

        // Initialize CashAmountManager (if not already initialized)
        CashAmountManager.getInstance();

        // Initialize UI components
        accountHolderName = rootView.findViewById(R.id.accountHolderName);
        phoneNumber = rootView.findViewById(R.id.phoneNumber);
        email = rootView.findViewById(R.id.email);
        initialDeposit = rootView.findViewById(R.id.initialDeposit);
        pin = rootView.findViewById(R.id.pin);
        countryCodeSpinner = rootView.findViewById(R.id.countryCodeSpinner);
        submitButton = rootView.findViewById(R.id.submitButton);
        agreementCheckbox = rootView.findViewById(R.id.agreementCheckbox);
        cashAmountTextView = rootView.findViewById(R.id.cashAmount); // Initialize cashAmountTextView

        // Array of country codes
        String[] countryCodes = {"+91 (India)", "+1 (USA)", "+44 (UK)", "+61 (Australia)", "+81 (Japan)",
                "+86 (China)", "+49 (Germany)", "+33 (France)", "+55 (Brazil)", "+27 (South Africa)", "+94 (Sri Lanka)"};

        // Setting up the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, countryCodes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countryCodeSpinner.setAdapter(adapter);

        // Set OnClickListener for submitButton
        submitButton.setOnClickListener(v -> submitForm());

        // Update cash amount initially
        updateCashAmount();

        return rootView;
    }

    private void submitForm() {
        String name = accountHolderName.getText().toString();
        String phone = phoneNumber.getText().toString();
        String emailText = email.getText().toString();
        String deposit = initialDeposit.getText().toString();
        String pinnumber = pin.getText().toString();
        String countryCode = countryCodeSpinner.getSelectedItem().toString();



        // Get the current date and time
        String currentDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

        // Log the values
        Log.d("PremiumAccountFragment", "Account Holder Name: " + name);
        Log.d("PremiumAccountFragment", "Phone Number: " + phone);
        Log.d("PremiumAccountFragment", "Email: " + emailText);
        Log.d("PremiumAccountFragment", "Initial Deposit: " + deposit);
        Log.d("PremiumAccountFragment", "Country Code: " + countryCode);
        Log.d("PremiumAccountFragment", "Date and Time: " + currentDateAndTime);
        Log.d("PremiumAccountFragment", "PIN: " + pinnumber);



        if (Integer.parseInt(deposit) > CashAmountManager.getInstance().getCashAmount()) {
            Toast.makeText(requireContext(), "Insufficient balance", Toast.LENGTH_SHORT).show();
            return;
        }

        if (Integer.parseInt(deposit) < 1000) {
            Toast.makeText(requireContext(), "Deposit amount should be greater than 1000", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if the checkbox is selected
        if(!agreementCheckbox.isChecked()) {
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

        // Validate PIN: exactly 4 digits
        if (!pinnumber.matches("\\d{4}")) {
            Toast.makeText(requireContext(), "PIN should be exactly 4 digits", Toast.LENGTH_SHORT).show();
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
        Log.d("PremiumAccountFragment", "Form submitted successfully");

        // Show a success message
        Toast.makeText(requireContext(), "Form submitted successfully", Toast.LENGTH_SHORT).show();

        //remove he deposit amount from the cash amount
        CashAmountManager.getInstance().subtractCashAmount(Integer.parseInt(deposit));

        // Start SendtoDB activity and send user details
        Intent intent = new Intent(getActivity(), SendtoDB.class);
        intent.putExtra("name", name);
        intent.putExtra("phone", phone);
        intent.putExtra("email", emailText);
        intent.putExtra("deposit", deposit);
        intent.putExtra("countryCode", countryCode);
        intent.putExtra("dateAndTime", currentDateAndTime);
        intent.putExtra("pin", pinnumber);
        intent.putExtra("accountType", "Premium Current Account");
        startActivity(intent);
    }



    // Method to update cash amount in cash_amount_view.xml
    private void updateCashAmount() {
        if (cashAmountTextView != null) {
            cashAmountTextView.setText(String.valueOf(CashAmountManager.getInstance().getCashAmount()));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Update cash amount when returning to MainActivity
        updateCashAmount();
    }
}


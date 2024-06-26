package com.example.eazilydone; // Check if this matches your project structure

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PremiumCurrentAccountFragment extends Fragment {

    private EditText accountHolderName, phoneNumber, email, initialDeposit;
    private Spinner countryCodeSpinner;
    private Button submitButton;

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

        // Perform validation and submission logic here
        if (name.isEmpty() || phone.isEmpty() || emailText.isEmpty() || deposit.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Show a success message
        Toast.makeText(requireContext(), "Form submitted successfully", Toast.LENGTH_SHORT).show();
    }
}

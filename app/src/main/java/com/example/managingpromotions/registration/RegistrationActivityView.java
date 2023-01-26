package com.example.managingpromotions.registration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.managingpromotions.R;
import com.example.managingpromotions.login.activity.LoginActivityView;
import com.example.managingpromotions.model.RegistrationCredentials;

public class RegistrationActivityView extends AppCompatActivity {

    private Button signUpButton;
    private TextView usernameInput, passwordInput, passwordConfirmationInput;

    private final RegistrationPresenter registrationPresenter;

    public RegistrationActivityView() {
        this.registrationPresenter = new RegistrationPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);
        initComponents();
    }

    @Override
    protected void onResume() {
        super.onResume();

        signUpButton.setOnClickListener(view -> {

            RegistrationCredentials registrationCredentials = new RegistrationCredentials();

            registrationCredentials.setUsername(usernameInput.getText().toString());
            registrationCredentials.setPassword(passwordInput.getText().toString());
            registrationCredentials.setPasswordConfirmation(passwordConfirmationInput.getText().toString());

            registrationPresenter.createAccount(registrationCredentials);
        });
    }


    private void initComponents() {

        signUpButton = findViewById(R.id.sign_up_button);
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        passwordConfirmationInput = findViewById(R.id.password_confirmation_input);
    }

    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void invokeLoginActivity() {

        Intent intent = new Intent(this, LoginActivityView.class);
        startActivity(intent);
    }
}

package com.example.managingpromotions.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.managingpromotions.MainActivity;
import com.example.managingpromotions.R;
import com.example.managingpromotions.login.presenter.LoginActivityPresenter;
import com.example.managingpromotions.model.LoginCredentials;
import com.example.managingpromotions.registration.RegistrationActivityView;

public class LoginActivityView extends AppCompatActivity {

    private Button signInButton, signUpButton;
    private TextView usernameInput, passwordInput;

    private LoginActivityPresenter loginActivityPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initComponents();
        loginActivityPresenter = new LoginActivityPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        signInButton.setOnClickListener(view -> {

            LoginCredentials loginCredentials = new LoginCredentials();

            loginCredentials.setUsername(usernameInput.getText().toString());
            loginCredentials.setPassword(passwordInput.getText().toString());

            loginActivityPresenter.loginToService(loginCredentials);
        });

        signUpButton.setOnClickListener(view -> {

            Intent intent = new Intent(this, RegistrationActivityView.class);
            startActivity(intent);
        });
    }

    private void initComponents() {

        signInButton = findViewById(R.id.sign_in_button);
        signUpButton = findViewById(R.id.sign_up_button);
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
    }

    public void displayMessage(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_LONG).show();
    }

    public void invokeMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

package com.example.uvu3100banking;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button loginButton;
    private ProgressBar progressBar;

    // Firebase Authentication Instance
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize Views
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        progressBar = findViewById(R.id.progressBar);

        loginButton.setOnClickListener(v -> validateAndAuthenticate());
    }

    private void validateAndAuthenticate() {
        String userNameInput = username.getText().toString().trim();
        String userPasswordInput = password.getText().toString().trim();

        // Input Validation
        if (TextUtils.isEmpty(userNameInput)) {
            username.setError(getString(R.string.error_username_required));
            username.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(userPasswordInput)) {
            password.setError(getString(R.string.error_password_required));
            password.requestFocus();
            return;
        }

        // Show Progress Bar
        progressBar.setVisibility(View.VISIBLE);

        // Call Authentication Method
        authenticateUser(userNameInput, userPasswordInput);
    }

    private void authenticateUser(String username, String password) {
        mAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, task -> {
                    // Hide Progress Bar
                    progressBar.setVisibility(View.GONE);

                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            Toast.makeText(MainActivity.this, R.string.login_success, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(MainActivity.this, R.string.login_failed, Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // User is signed in, navigate to Dashboard
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
            finish();
        }
    }
}

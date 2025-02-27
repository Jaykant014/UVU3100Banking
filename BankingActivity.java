package com.example.uvu3100banking;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking);

        TextView accountInfo = findViewById(R.id.accountInfo);
        accountInfo.setText("Account Number: 123456789\nAccount Type: Checking\nBalance: $10,000");
    }
}


package com.example.uvu3100banking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    Button btnTransfer, btnAccountDetails, btnTransactionHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnTransfer = findViewById(R.id.btnTransfer);
        btnAccountDetails = findViewById(R.id.btnAccountDetails);
        btnTransactionHistory = findViewById(R.id.btnTransactionHistory);

        btnTransfer.setOnClickListener(v ->
                startActivity(new Intent(DashboardActivity.this, TransferActivity.class))
        );

        btnAccountDetails.setOnClickListener(v ->
                startActivity(new Intent(DashboardActivity.this, BankingActivity.class))
        );

        btnTransactionHistory.setOnClickListener(v ->
                startActivity(new Intent(DashboardActivity.this, TransactionHistoryActivity.class))
        );
    }

}
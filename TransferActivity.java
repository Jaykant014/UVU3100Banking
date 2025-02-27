package com.example.uvu3100banking;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TransferActivity extends AppCompatActivity {

    EditText recipient, amount;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        recipient = findViewById(R.id.recipient);
        amount = findViewById(R.id.amount);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = recipient.getText().toString();
                String amt = amount.getText().toString();

                if (to.isEmpty() || amt.isEmpty()) {
                    Toast.makeText(TransferActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TransferActivity.this, "Transferred $" + amt + " to " + to, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
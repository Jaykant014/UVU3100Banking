package com.example.uvu3100banking;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TransactionAdapter adapter;
    private List<String> transactionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Dummy Transaction Data
        transactionList = new ArrayList<>();
        transactionList.add("- $50 Walmart");
        transactionList.add("+ $500 Salary");
        transactionList.add("- $100 Gas");
        transactionList.add("- $200 Rent");
        transactionList.add("- $25 Coffee");
        transactionList.add("+ $200 Refund");
        transactionList.add("- $75 Groceries");

        // Initialize Adapter and Set to RecyclerView
        adapter = new TransactionAdapter(transactionList);
        recyclerView.setAdapter(adapter);
    }
}
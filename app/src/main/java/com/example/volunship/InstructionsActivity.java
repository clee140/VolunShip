package com.example.volunship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        BottomNavigationView bottomNavigationView = findViewById(R.id.content);
        bottomNavigationView.setSelectedItemId(R.id.instructions);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.instructions:
                        return true;
                    case R.id.charities:
                        startActivity(new Intent(getApplicationContext(), CharitiesActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.email:
                        startActivity(new Intent(getApplicationContext(), EmailActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}
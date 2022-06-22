package com.example.volunship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePageActivity extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
        Intent intent = getIntent();
        //String text = intent.getStringExtra(SignInActivity.EXTRA_TEXT);
        TextView textView1 = (TextView) findViewById(R.id.textView2);
        textView1.setText("Welcome " + SignInActivity.text + "!");

        handleClick(R.id.children, BooksActivity.class);
        handleClick(R.id.women, ClothingActivity.class);
        handleClick(R.id.homeless, CookwareActivity.class);
        handleClick(R.id.animals, SchoolActivity.class);
        handleClick(R.id.disabilities, SportsActivity.class);
        handleClick(R.id.environment, ToysActivity.class);

        BottomNavigationView bottomNavigationView = findViewById(R.id.content);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.instructions:
                        startActivity(new Intent(getApplicationContext(), InstructionsActivity.class));
                        overridePendingTransition(0, 0);
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

    public void openNewActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    public void handleClick(int id, Class cls) {
        linearLayout = (LinearLayout) findViewById(id);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewActivity(cls);
            }
        });
    }
}
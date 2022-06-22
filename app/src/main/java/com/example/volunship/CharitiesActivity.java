package com.example.volunship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CharitiesActivity extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charities);

        BottomNavigationView bottomNavigationView = findViewById(R.id.content);
        bottomNavigationView.setSelectedItemId(R.id.charities);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.instructions:
                        startActivity(new Intent(getApplicationContext(), InstructionsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.charities:
                        return true;
                    case R.id.email:
                        startActivity(new Intent(getApplicationContext(), EmailActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        handleClick(R.id.children, "https://givebackbox.shop/collections/children");
        handleClick(R.id.women, "https://givebackbox.shop/collections/women");
        handleClick(R.id.homeless, "https://givebackbox.shop/collections/homeless");
        handleClick(R.id.animals, "https://givebackbox.shop/collections/animals");
        handleClick(R.id.disabilities, "https://givebackbox.shop/collections/people-with-disabilities");
        handleClick(R.id.environment, "https://givebackbox.shop/collections/environment");
        handleClick(R.id.addicts, "https://givebackbox.shop/collections/addictions");
        handleClick(R.id.veterans, "https://givebackbox.shop/collections/veterans");
        handleClick(R.id.refugees, "https://givebackbox.shop/collections/refugee");

        clipboard("https://givebackbox.shop/collections/children");
        clipboard("https://givebackbox.shop/collections/women");
        clipboard("https://givebackbox.shop/collections/homeless");
        clipboard("https://givebackbox.shop/collections/animals");
        clipboard("https://givebackbox.shop/collections/people-with-disabilities");
        clipboard("https://givebackbox.shop/collections/environment");
        clipboard("https://givebackbox.shop/collections/addictions");
        clipboard("https://givebackbox.shop/collections/veterans");
        clipboard("https://givebackbox.shop/collections/refugee");

    }

    public void handleClick(int id, String url) {
        linearLayout = (LinearLayout) findViewById(id);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    public void clipboard(String url) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Non-profit link", url);
        clipboard.setPrimaryClip(clip);
    }
}
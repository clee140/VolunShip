package com.example.volunship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BooksActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        button = (Button) findViewById(R.id.toys_print);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.zappos.com/about/zappos-for-good/spread-the-word-nevada");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                clipboard();
                //handleText();
            }
        });
    }

    public void launchHomePage(View v) {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    public void clipboard() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Non-profit link", "https://www.zappos.com/about/zappos-for-good/spread-the-word-nevada");
        clipboard.setPrimaryClip(clip);
    }
}
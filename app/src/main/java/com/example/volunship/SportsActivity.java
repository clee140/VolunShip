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

public class SportsActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        handleButtons(R.id.toys_print, "http://www.turn2foryouth.com/how-to-start-a-drive");
        handleButtons(R.id.legos_print, "https://www.recycleballs.org/quicklabel-program-and-give-form-free/");
        clipboard("http://www.turn2foryouth.com/how-to-start-a-drive");
        clipboard("https://www.recycleballs.org/quicklabel-program-and-give-form-free/");
    }

    public void handleButtons(int num, String url) {
        button = (Button) findViewById(num);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    public void launchHomePage(View v) {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    public void clipboard(String url) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Non-profit link", url);
        clipboard.setPrimaryClip(clip);
    }
}
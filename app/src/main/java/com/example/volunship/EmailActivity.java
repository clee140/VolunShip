package com.example.volunship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EmailActivity extends AppCompatActivity {
    private EditText editTextTo;
    private EditText editTextSubject;
    private EditText editTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        editTextTo = findViewById(R.id.edit_text_to);
        editTextSubject = findViewById(R.id.edit_subject);
        editTextMessage = findViewById(R.id.edit_message);

        BottomNavigationView bottomNavigationView = findViewById(R.id.content);
        bottomNavigationView.setSelectedItemId(R.id.email);
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
                        startActivity(new Intent(getApplicationContext(), CharitiesActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.email:
                        return true;
                }
                return false;
            }
        });

        Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });


    }

    public void sendMail() {
        String recipientList = editTextTo.getText().toString();
        String[] recipients = recipientList.split(",");

        String subject = editTextSubject.getText().toString();
        String message = editTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
}
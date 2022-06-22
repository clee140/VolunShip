package com.example.volunship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    private Button button;
    public static String input;
    public static final String EXTRA_TEXT = "com.example.volunship.EXTRA_TEXT";
    public static String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
                //handleText();
            }
        });
    }

    private void openNewActivity() {
        EditText editText1 = (EditText) findViewById(R.id.editTextTextPersonName8);
        text = editText1.getText().toString();
        Intent intent = new Intent(this, HomePageActivity.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }

    public void handleText() {
        EditText t = findViewById(R.id.editTextTextPersonName8);
        input = t.getText().toString();
    }
}
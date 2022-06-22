package com.example.volunship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
    }

    //  public void disable(View view) {
        /*
        view.setEnabled(false);
        Button button = (Button) view;
        button.setText("Disabled");

         */

//    }

    /*
    public void handleText(View v) {
        EditText t = findViewById(R.id.source);
        String input = t.getText().toString();
        ((TextView) findViewById(R.id.output)).setText(input);
        Toast.makeText(this, input, Toast.LENGTH_LONG).show();
        //Log.d("info", input);
    }

     */


    public void launchSignIn(View v) {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
}
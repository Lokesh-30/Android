package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text1;
    private EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        text1 = findViewById(R.id.editText1);
        text2 = findViewById(R.id.editText2);

        String id = text1.getText().toString();
        String pass = text2.getText().toString();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(null);
                text2.setText(null);
                Toast.makeText(MainActivity.this, "Logged in", Toast.LENGTH_LONG).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(null);
                text2.setText(null);
                Toast.makeText(MainActivity.this,"Log in cancelled",Toast.LENGTH_LONG).show();
            }
        });
    }
}
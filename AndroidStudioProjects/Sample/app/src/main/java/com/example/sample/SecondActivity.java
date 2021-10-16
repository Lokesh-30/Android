package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView text;
    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        but = findViewById(R.id.button2);
        text =findViewById(R.id.textView2);

        String name = getIntent().getStringExtra("Message");

        text.setText(name);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = "This is Second Activity";
                Intent i = new Intent();
                i.putExtra("MS",str);
                setResult(RESULT_OK,i);
                finish();

            }
        });
    }
}
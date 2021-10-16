package com.example.sample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b ;
    private EditText name;
    private final int request = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button1);
        name = findViewById(R.id.name1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameStr;
                nameStr = name.getText().toString();

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("Message",nameStr);
                startActivityForResult(intent,request);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == request){
            if(resultCode == RESULT_OK){
                String msg = data.getStringExtra("MS");
                b.setText(msg);
            }
        }else{
            b.setText("No output");
        }
    }
}
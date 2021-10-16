package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b;
    private CheckBox c1,c2,c3,c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button1);

        c1 = findViewById(R.id.checkBox2);
        c2 = findViewById(R.id.checkBox3);
        c3 = findViewById(R.id.checkBox4);
        c4 = findViewById(R.id.checkBox5);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuilder strBuilder = new StringBuilder();
                strBuilder.append("Languages Known : ");
                strBuilder.append("\n");

                if(c1.isChecked()){
                    strBuilder.append(c1.getText().toString());
                    strBuilder.append("\n");
                }
                if(c2.isChecked()){
                    strBuilder.append(c2.getText().toString());
                    strBuilder.append("\n");
                }
                if(c3.isChecked()){
                    strBuilder.append(c3.getText().toString());
                    strBuilder.append("\n");
                }
                if(c4.isChecked()){
                    strBuilder.append(c4.getText().toString());
                    strBuilder.append("\n");
                }

                if(!c1.isChecked() && !c2.isChecked() && !c3.isChecked() && !c4.isChecked()){
                    strBuilder.append("None");
                }

                Toast.makeText(MainActivity.this,strBuilder.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
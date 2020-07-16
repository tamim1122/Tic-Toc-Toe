package com.example.tictoctoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mainbtn1 =findViewById(R.id.mainbtn_1);
        Button mainbtn2 =findViewById(R.id.mainbtn_2);

        mainbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent= new Intent(MainActivity.this,GameLaunch.class);
            startActivity(intent);
            }
        });

        mainbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}
package com.example.fitnesssdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ExcerciseActivity extends AppCompatActivity {

    LinearLayout linear_excercise_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise);

        linear_excercise_back = (LinearLayout) findViewById(R.id.linear_excercise_back);


        linear_excercise_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ExcerciseActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}

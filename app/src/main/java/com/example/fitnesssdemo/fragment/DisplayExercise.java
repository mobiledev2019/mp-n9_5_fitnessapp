package com.example.fitnesssdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DisplayExercise extends AppCompatActivity {
    private TextView txtName, txtDetail;
    private ImageView imgExerciseImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_exercise);
        init();
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",-1);
        String name = intent.getStringExtra("name");
        String detail = intent.getStringExtra("detail");

        txtName.setText(name);
        Glide.with(this).load(id).into(imgExerciseImage);

        txtDetail.setText(detail);

    }

    private void init() {
        txtName = findViewById(R.id.txtExerciseName);
        txtDetail = findViewById(R.id.txtDetail);
        imgExerciseImage = findViewById(R.id.imgExerciseImage);

    }
}

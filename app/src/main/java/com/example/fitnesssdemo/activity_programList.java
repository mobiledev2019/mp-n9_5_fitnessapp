package com.example.fitnesssdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activity_programList extends AppCompatActivity {

    private TextView programName,content;

    private final static String CODE="232323";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_list);
        Intent intent = getIntent();
        Program program =intent.getParcelableExtra(CODE);

        programName.findViewById(R.id.article_title);
        content.findViewById(R.id.article_content);

        programName.setText(program.getProgramName());
        content.setText(program.getContent());

    }

}

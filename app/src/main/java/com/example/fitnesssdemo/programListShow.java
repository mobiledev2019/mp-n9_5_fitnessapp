package com.example.fitnesssdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class programListShow extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ProgramListAdapter programListAdapter;

    private final static String CODE="232323";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_list_show);
        recyclerView = findViewById(R.id.recycleview);
        List <Program> programList = new ArrayList<>();

        programList.add(new Program("Chương trình số 1", "22222", " ", "noi dung la"));
        programList.add(new Program("Chương trình số 2", "22222", " ", "noi dung la"));
        programList.add(new Program("Chương trình số 3", "22222", " ", "noi dung la"));
        programList.add(new Program("Chương trình số 4", "22222", " ", "noi dung la"));

        programListAdapter = new ProgramListAdapter(programList);
        recyclerView.setAdapter(programListAdapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        programListAdapter.SetOnItemClickListener(new ProgramListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Program program = programListAdapter.getProgram(position);
                Intent intent = new Intent(getApplicationContext(), activity_programList.class);
                intent.putExtra(CODE, program);
                startActivity(intent);

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();

    }
}

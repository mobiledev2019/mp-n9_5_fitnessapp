package com.example.fitnesssdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class WeightManagementActivity extends AppCompatActivity  {


    LinearLayout linear_weight_back;


    Button see;
    EditText after;
    EditText before;
    EditText calo_in;
    EditText time_in;
    EditText after_;
    int x = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_management);

        linear_weight_back = (LinearLayout) findViewById(R.id.linear_weight_back);

        after = (EditText) findViewById(R.id.after);
        before = (EditText) findViewById(R.id.before);
        calo_in = (EditText) findViewById(R.id.calo_in);
        time_in = (EditText) findViewById(R.id.time_in);
        after_ = (EditText) findViewById(R.id.after_);

        see = (Button) findViewById(R.id.see);




        linear_weight_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WeightManagementActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  after.getText().toString();
                int a = Integer.parseInt(count);
                String count1 =  before.getText().toString();
                int b = Integer.parseInt(count1);
                String count2 =  calo_in.getText().toString();
                int c = Integer.parseInt(count2);
                String count3 =  time_in.getText().toString();
                int d = Integer.parseInt(count3);

                if((a - b) >= 0){
                    x = (((a - b)*7700)/d) + c;
                    after_.setText("Giảm (kcal/ngày) : " + x);
                }else{
                    x =(((b - a)*7700)/d) + c;
                    after_.setText("Tăng (kcal/ngày) : " + x);
                }


            }
        });

    }


}
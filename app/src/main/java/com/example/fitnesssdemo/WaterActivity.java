package com.example.fitnesssdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnesssdemo.database.DBManagerWater;
import com.example.fitnesssdemo.fragment.HomeFragment;
import com.example.fitnesssdemo.model.Water;

public class WaterActivity extends AppCompatActivity {

    LinearLayout linear_water_back;

    ImageButton minus_water;
    ImageButton plus_water;
    TextView text_water;

    Button save;
    Button reset;

    public WaterActivity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
        linear_water_back = (LinearLayout) findViewById(R.id.linear_water_back);
        final DBManagerWater dbManagerWater = new DBManagerWater(this);

        minus_water = (ImageButton) findViewById(R.id.minus_water);
        plus_water = (ImageButton) findViewById(R.id.plus_water);
        text_water = (TextView) findViewById(R.id.text_water);

        save = (Button) findViewById(R.id.save);
        reset = (Button) findViewById(R.id.reset);

        Water water = dbManagerWater.getMaxWater();
        if(water.getTotal()!=null) {
            text_water.setText(water.getTotal());
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Water water = createWater();
                if(water!=null){
                    dbManagerWater.addWater(water);
                    Toast.makeText(WaterActivity.this,"Done!", Toast.LENGTH_LONG).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_water.getText().toString();
                int x = Integer.parseInt(count);
                x = 0;
                count = String.valueOf(x);
                text_water.setText(count);
            }
        });



        linear_water_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WaterActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        minus_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_water.getText().toString();
                int x = Integer.parseInt(count);
                x--;
                if(x<=0){
                    x = 0;
                }
                count = String.valueOf(x);
                text_water.setText(count);
            }
        });
        plus_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_water.getText().toString();
                int x = Integer.parseInt(count);
                x++;
                if(x>8){
                    x = 8;
                }
                count = String.valueOf(x);
                text_water.setText(count);
            }
        });
    }
    private Water createWater(){
        String total = text_water.getText().toString();
        Water water = new Water(total);
        return water;
    }
}

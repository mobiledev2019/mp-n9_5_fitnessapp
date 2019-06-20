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

import com.example.fitnesssdemo.database.DBManagerFood;
import com.example.fitnesssdemo.model.Food;

public class FoodActivity extends AppCompatActivity {

    LinearLayout linear_food_back;

    Button save;
    Button reset;

    ImageButton minus_rice;
    ImageButton plus_rice;
    TextView text_rice;

    ImageButton minus_pork;
    ImageButton plus_pork;
    TextView text_pork;

    ImageButton minus_beef;
    ImageButton plus_beef;
    TextView text_beef;

    ImageButton minus_fish;
    ImageButton plus_fish;
    TextView text_fish;

    ImageButton minus_chicken;
    ImageButton plus_chicken;
    TextView text_chicken;

    ImageButton minus_veget;
    ImageButton plus_veget;
    TextView text_veget;

    TextView totel_kcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        final DBManagerFood dbManagerFood = new DBManagerFood(this);

        reset = (Button) findViewById(R.id.reset);
        save = (Button) findViewById(R.id.save);

        linear_food_back = (LinearLayout) findViewById(R.id.linear_food_back);

        minus_rice = (ImageButton) findViewById(R.id.minus_rice);
        plus_rice = (ImageButton) findViewById(R.id.plus_rice);
        text_rice = (TextView) findViewById(R.id.text_rice);

        minus_pork = (ImageButton) findViewById(R.id.minus_pork);
        plus_pork = (ImageButton) findViewById(R.id.plus_pork);
        text_pork = (TextView) findViewById(R.id.text_pork);

        minus_beef = (ImageButton) findViewById(R.id.minus_beef);
        plus_beef = (ImageButton) findViewById(R.id.plus_beef);
        text_beef = (TextView) findViewById(R.id.text_beef);

        minus_fish = (ImageButton) findViewById(R.id.minus_fish);
        plus_fish = (ImageButton) findViewById(R.id.plus_fish);
        text_fish = (TextView) findViewById(R.id.text_fish);

        minus_chicken = (ImageButton) findViewById(R.id.minus_chicken);
        plus_chicken = (ImageButton) findViewById(R.id.plus_chicken);
        text_chicken = (TextView) findViewById(R.id.text_chicken);

        minus_veget = (ImageButton) findViewById(R.id.minus_veget);
        plus_veget = (ImageButton) findViewById(R.id.plus_veget);
        text_veget = (TextView) findViewById(R.id.text_veget);

        totel_kcal = (TextView) findViewById(R.id.totel_kcal);

        Food food = dbManagerFood.getMaxFoodAll();
        if(food.getRice()!=null) {
            text_rice.setText(food.getRice());
            text_beef.setText(food.getBeef());
            text_pork.setText(food.getPork());
            text_fish.setText(food.getFish());
            text_chicken.setText(food.getChicken());
            text_veget.setText(food.getVegetable());
            totel_kcal.setText(food.getTotal());
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Food food = createFood();
                if(food!=null){
                    dbManagerFood.addFood(food);
                    Toast.makeText(FoodActivity.this,"Done!", Toast.LENGTH_LONG).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_rice.getText().toString();
                int x = Integer.parseInt(count);
                x = 0;
                count = String.valueOf(x);
                text_rice.setText(count);

                String count1 =  text_beef.getText().toString();
                int y = Integer.parseInt(count1);
                y = 0;
                count1 = String.valueOf(y);
                text_beef.setText(count1);

                String count2 =  text_pork.getText().toString();
                int z = Integer.parseInt(count2);
                z = 0;
                count2 = String.valueOf(z);
                text_pork.setText(count2);

                String count3 =  text_fish.getText().toString();
                int a = Integer.parseInt(count3);
                a = 0;
                count3 = String.valueOf(a);
                text_fish.setText(count3);

                String count4 =  text_chicken.getText().toString();
                int b = Integer.parseInt(count4);
                b = 0;
                count4 = String.valueOf(b);
                text_chicken.setText(count4);

                String count5 =  text_veget.getText().toString();
                int c = Integer.parseInt(count5);
                c = 0;
                count5 = String.valueOf(c);
                text_veget.setText(count5);

                String count6 =  totel_kcal.getText().toString();
                int d = Integer.parseInt(count6);
                d = 0;
                count6 = String.valueOf(d);
                totel_kcal.setText(count6);
            }
        });


        linear_food_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


        minus_rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_rice.getText().toString();
                int x = Integer.parseInt(count);
                int z = x;
                x--;
                if(x<=0){
                    x = 0;
                }
                count = String.valueOf(x);
                text_rice.setText(count);

                String totel =  totel_kcal.getText().toString();
                int y = Integer.parseInt(totel);
                if(z > 0){
                    y = y - 200;
                }
                if(y<=0){
                    y = 0;
                }
                totel = String.valueOf(y);
                totel_kcal.setText(totel);
            }
        });
        plus_rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_rice.getText().toString();
                int x = Integer.parseInt(count);
                x++;
                count = String.valueOf(x);
                text_rice.setText(count);

                String totel =  totel_kcal.getText().toString();
                int y = Integer.parseInt(totel);
                y = y + 200;
                totel = String.valueOf(y);
                totel_kcal.setText(totel);
                if(y>2150){
                    Toast.makeText(FoodActivity.this, "Too much !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        minus_pork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_pork.getText().toString();
                int x = Integer.parseInt(count);
                int z = x;
                x--;
                if(x<=0){
                    x = 0;
                }
                count = String.valueOf(x);
                text_pork.setText(count);

                String totel =  totel_kcal.getText().toString();
                int y = Integer.parseInt(totel);
                if(z > 0){
                    y = y - 148;
                }
                if(y<=0){
                    y = 0;
                }
                totel = String.valueOf(y);
                totel_kcal.setText(totel);
            }
        });
        plus_pork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_pork.getText().toString();
                int x = Integer.parseInt(count);
                x++;
                count = String.valueOf(x);
                text_pork.setText(count);

                String totel =  totel_kcal.getText().toString();
                int y = Integer.parseInt(totel);
                y = y + 148;
                totel = String.valueOf(y);
                totel_kcal.setText(totel);
                if(y>2150){
                    Toast.makeText(FoodActivity.this, "Too much !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        minus_beef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_beef.getText().toString();
                int x = Integer.parseInt(count);
                int z = x;
                x--;
                if(x<=0){
                    x = 0;
                }
                count = String.valueOf(x);
                text_beef.setText(count);

                String totel =  totel_kcal.getText().toString();
                int y = Integer.parseInt(totel);
                if(z > 0){
                    y = y - 251;
                }
                if(y<=0){
                    y = 0;
                }
                totel = String.valueOf(y);
                totel_kcal.setText(totel);
            }
        });
        plus_beef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_beef.getText().toString();
                int x = Integer.parseInt(count);
                x++;
                count = String.valueOf(x);
                text_beef.setText(count);

                String totel =  totel_kcal.getText().toString();
                int y = Integer.parseInt(totel);
                y = y + 251;
                totel = String.valueOf(y);
                totel_kcal.setText(totel);
                if(y>2150){
                    Toast.makeText(FoodActivity.this, "Too much !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        minus_fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_fish.getText().toString();
                int x = Integer.parseInt(count);
                int z = x;
                x--;
                if(x<=0){
                    x = 0;
                }
                count = String.valueOf(x);
                text_fish.setText(count);

                String totel =  totel_kcal.getText().toString();
                int y = Integer.parseInt(totel);
                if(z > 0){
                    y = y - 151;
                }
                if(y<=0){
                    y = 0;
                }
                totel = String.valueOf(y);
                totel_kcal.setText(totel);
            }
        });
        plus_fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_fish.getText().toString();
                int x = Integer.parseInt(count);
                x++;
                count = String.valueOf(x);
                text_fish.setText(count);

                String totel =  totel_kcal.getText().toString();
                int y = Integer.parseInt(totel);
                y = y + 151;
                totel = String.valueOf(y);
                totel_kcal.setText(totel);
                if(y>2150){
                    Toast.makeText(FoodActivity.this, "Too much !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        minus_chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_chicken.getText().toString();
                int x = Integer.parseInt(count);
                int z = x;
                x--;
                if(x<=0){
                    x = 0;
                }
                count = String.valueOf(x);
                text_chicken.setText(count);

                String totel =  totel_kcal.getText().toString();
                int y = Integer.parseInt(totel);
                if(z > 0){
                    y = y - 161;
                }
                if(y<=0){
                    y = 0;
                }
                totel = String.valueOf(y);
                totel_kcal.setText(totel);
            }
        });
        plus_chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_chicken.getText().toString();
                int x = Integer.parseInt(count);
                x++;
                count = String.valueOf(x);
                text_chicken.setText(count);

                String totel =  totel_kcal.getText().toString();
                int y = Integer.parseInt(totel);
                y = y + 161;
                totel = String.valueOf(y);
                totel_kcal.setText(totel);
                if(y>2150){
                    Toast.makeText(FoodActivity.this, "Too much !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        minus_veget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_veget.getText().toString();
                int x = Integer.parseInt(count);
                int z = x;
                x--;
                if(x<=0){
                    x = 0;
                }
                count = String.valueOf(x);
                text_veget.setText(count);

                String totel =  totel_kcal.getText().toString();
                int y = Integer.parseInt(totel);
                if(z > 0){
                    y = y - 49;
                }
                if(y<=0){
                    y = 0;
                }
                totel = String.valueOf(y);
                totel_kcal.setText(totel);
            }
        });
        plus_veget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count =  text_veget.getText().toString();
                int x = Integer.parseInt(count);
                x++;
                count = String.valueOf(x);
                text_veget.setText(count);

                String totel =  totel_kcal.getText().toString();
                int y = Integer.parseInt(totel);
                y = y + 49;
                totel = String.valueOf(y);
                totel_kcal.setText(totel);
                if(y>2150){
                    Toast.makeText(FoodActivity.this, "Too much !", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private Food createFood(){
        String rice = text_rice.getText().toString();
        String beef = text_beef.getText().toString();
        String pork = text_pork.getText().toString();
        String fish = text_fish.getText().toString();
        String chcicken = text_chicken.getText().toString();
        String veget = text_veget.getText().toString();
        String total = totel_kcal.getText().toString();
        Food food = new Food(rice, beef, pork, fish, chcicken, veget, total);
        return food;
    }
}

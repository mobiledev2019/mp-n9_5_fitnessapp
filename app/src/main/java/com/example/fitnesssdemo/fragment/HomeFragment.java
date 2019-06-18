package com.example.fitnesssdemo.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnesssdemo.ExcerciseActivity;
import com.example.fitnesssdemo.FoodActivity;
import com.example.fitnesssdemo.R;
import com.example.fitnesssdemo.WalkActivity;
import com.example.fitnesssdemo.WaterActivity;
import com.example.fitnesssdemo.WeightManagementActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Dialog dialog;
    LinearLayout linear_walk;
    LinearLayout linear_excercise;
    LinearLayout linear_water;
    LinearLayout linear_food;
    LinearLayout linear_weight_management;

    ImageButton minus_water;
    ImageButton plus_water;
    ImageButton notice;
    TextView text_water;


    public HomeFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        linear_walk = (LinearLayout) view.findViewById (R.id.linear_walk);
        linear_excercise = (LinearLayout) view.findViewById (R.id.linear_excercise);
        linear_water = (LinearLayout) view.findViewById (R.id.linear_water);
        linear_food = (LinearLayout) view.findViewById (R.id.linear_food);
        linear_weight_management = (LinearLayout) view.findViewById (R.id.linear_weight_management);

        minus_water = (ImageButton) view.findViewById(R.id.minus_water_background);
        plus_water = (ImageButton) view.findViewById(R.id.plus_water_background);
        text_water = (TextView) view.findViewById(R.id.text_water_background);

        notice = (ImageButton) view.findViewById(R.id.ideal);


        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });

        linear_walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), WalkActivity.class);
                startActivity(i);
            }
        });
        linear_excercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ExcerciseActivity.class);
                startActivity(i);
            }
        });
        linear_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), WaterActivity.class);
                startActivity(i);
            }
        });
        linear_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), FoodActivity.class);
                startActivity(i);
            }
        });
        linear_weight_management.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), WeightManagementActivity.class);
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



        return view;
    }


    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Thông báo");
        builder.setMessage("Cuộc sống không được như những gì bạn mong muốn? Bạn không thể kiềm chế được cảm xúc của mình và tinh thần đang xuống dốc? Sức khỏe đang có vấn đề? Hãy dành thời gian tập fitness ngay lập tức!! Lợi ích của fitness đối với bạn là cực kì to lớn và phong phú, không những về mặt hình thể, mà còn là sức khỏe, sức bền, sự linh hoạt và giúp cảm xúc của bạn được cải thiện nhiều hơn và giúp bạn thêm vui tươi yêu đời hơn mỗi ngày.");
        builder.setCancelable(false);
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}

package com.example.fitnesssdemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import com.example.fitnesssdemo.R;
import com.example.fitnesssdemo.activity_product;
import com.example.fitnesssdemo.activity_programList;
import com.example.fitnesssdemo.programListShow;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment {
    ViewFlipper viewFlipper, viewFlipper2;
    ImageButton btnPre, btnNext, btnProductPre, btnProductNext;
    Button btnProgramList;
    Button btnProductList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        viewFlipper = (ViewFlipper) view.findViewById(R.id.viewFlipper);
        btnPre = (ImageButton) view.findViewById(R.id.btn_pre);
        btnNext = (ImageButton) view.findViewById(R.id.btn_next);

        btnProgramList = (Button) view.findViewById(R.id.button_program);
        btnProductList = (Button) view.findViewById(R.id.button_product);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);

        //start program list activity
        btnProgramList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent mintent = new Intent(getActivity(), programListShow.class);
                startActivity(mintent);
            }
        });

        btnProductList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(getActivity(), activity_product.class);
                startActivity(mintent);
            }
        });


        //event for next button in slide
        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (viewFlipper.isAutoStart()){
                    viewFlipper.stopFlipping();
                    viewFlipper.showNext();
                    viewFlipper.startFlipping();
                    viewFlipper.setAutoStart(true);
                }
            }
        });
        //event for prev button in slide
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewFlipper.isAutoStart()) {
                    viewFlipper.stopFlipping();
                    viewFlipper.showPrevious();
                    viewFlipper.startFlipping();
                    viewFlipper.setAutoStart(true);
                }

            }
        });

        viewFlipper2 = (ViewFlipper) view.findViewById(R.id.viewFlipper2);
        btnProductPre = (ImageButton) view.findViewById(R.id.btn_product_pre);
        btnProductNext = (ImageButton) view.findViewById(R.id.btn_product_next);
        viewFlipper2.setFlipInterval(5000);
        viewFlipper2.setAutoStart(true);
        btnProductNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (viewFlipper2.isAutoStart()){
                    viewFlipper2.stopFlipping();
                    viewFlipper2.showNext();
                    viewFlipper2.startFlipping();
                    viewFlipper2.setAutoStart(true);
                }
            }
        });

        btnProductPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewFlipper2.isAutoStart()) {
                    viewFlipper2.stopFlipping();
                    viewFlipper2.showPrevious();
                    viewFlipper2.startFlipping();
                    viewFlipper2.setAutoStart(true);
                }

            }
        });


        return view;
    }

}

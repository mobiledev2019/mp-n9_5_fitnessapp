package com.example.fitnesssdemo;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ExerciseAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<com.example.fitnesssdemo.Exercise> exercises;

    public ExerciseAdapter(Context context, int layout, List<com.example.fitnesssdemo.Exercise> exercises) {
        this.context = context;
        this.layout = layout;
        this.exercises = exercises;
    }

    @Override
    public int getCount() {
        return exercises.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class Holder{
        ImageView imgExercise;
        TextView txtName;
    }

    @Override
    //để ko phải tạo mới dữ liệu
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder  holder;
        if (convertView == null)
        {
            holder = new Holder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout,null);
            holder.imgExercise = convertView.findViewById(R.id.imgExercise);
            holder.txtName = convertView.findViewById(R.id.txtName);
            convertView.setTag(holder);


        }
        else {
            holder = (Holder) convertView.getTag();
        }

        com.example.fitnesssdemo.Exercise exercise = exercises.get(position);
        holder.txtName.setText(exercise.getName());
        Glide.with(context).load(exercises.get(position).getId()).into(holder.imgExercise);

        return convertView;
    }
}

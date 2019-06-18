package com.example.fitnesssdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProgramListAdapter extends RecyclerView.Adapter<ProgramListAdapter.ProgramViewHolder> {
    private List<Program> list;
    private OnItemClickListener listener;

    public ProgramListAdapter (List<Program> list) { this.list = list;}
    public Program getProgram (int position) { return list.get(position); }
    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i){
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.programitem, viewGroup, false);
        return new ProgramViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder programViewHolder, int i) {
        Program program = list.get(i);
        programViewHolder.programName.setText(program.getProgramName());
        programViewHolder.description.setText(program.getDes());

    }

    public int getItemCount(){
        return list.size();
    }

    class ProgramViewHolder extends RecyclerView.ViewHolder {
        TextView programName, description;
        ImageView image;

        public ProgramViewHolder (@NonNull View itemView) {
            super(itemView);
            programName = itemView.findViewById(R.id.program_name);
            description = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View v){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION&&listener != null ){
                        listener.onItemClick(position);
                    }
                }
            });
        }

    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void SetOnItemClickListener(OnItemClickListener listener ){
        this.listener = listener;
    }


}






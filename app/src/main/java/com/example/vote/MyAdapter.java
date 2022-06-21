package com.example.vote;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    ArrayList<votes> votes;

    public MyAdapter(Context context, ArrayList<com.example.vote.votes> votes) {
        this.context = context;
        this.votes = votes;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.votesentry, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        votes vote = votes.get(position);
        holder.question.setText(vote.getQuestion());
        holder.datefin.setText(vote.getDatefin());
    }

    @Override
    public int getItemCount() {
        return votes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView question, datefin;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.textquestion);
            datefin = itemView.findViewById(R.id.textdatefin);
        }
    }
}

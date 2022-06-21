package com.example.vote;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    ArrayList<votes> listvotes;

    public MyAdapter(Context context, ArrayList<com.example.vote.votes> votes) {
        this.context = context;
        this.listvotes = votes;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.votesentry, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        votes vote = listvotes.get(position);
        holder.question.setText(vote.getQuestion());
        holder.datefin.setText(vote.getDatefin());
        holder.re1.setText(vote.getRe1());
        holder.re2.setText(vote.getRe2());
        holder.re3.setText(vote.getRe3());
        holder.re4.setText(vote.getRe4());
        holder.re5.setText(vote.getRe5());

        Log.e(" Error", "re1 = "+vote.getRe1());
        Log.e(" Error", "re2 = "+vote.getRe2());
        Log.e(" Error", "re3 = "+vote.getRe3());
        Log.e(" Error", "re4 = "+vote.getRe4());
        Log.e(" Error", "re5 = "+vote.getRe5());


        if(vote.getRe3().length()<1){
            holder.re3.setVisibility(View.GONE);
            Log.e(" cond", "re3 = "+vote.getRe3());
        }
        if(vote.getRe4().length()<1){
            holder.re4.setVisibility(View.GONE);
        }

        if(vote.getRe5().length()<1){
            holder.re5.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return listvotes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView question, datefin,re1,re2,re3,re4,re5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.textquestion);
            datefin = itemView.findViewById(R.id.textdatefin);
            re1 = itemView.findViewById(R.id.r1check);
            re2 = itemView.findViewById(R.id.r2check);
            re3 = itemView.findViewById(R.id.r3check);
            re4 = itemView.findViewById(R.id.r4check);
            re5 = (CheckBox)itemView.findViewById(R.id.r5check);

        }
    }
}

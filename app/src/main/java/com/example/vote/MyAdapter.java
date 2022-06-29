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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

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
        holder.idvote.setText(vote.getId());
        holder.re1.setText(vote.getRe1());
        holder.re2.setText(vote.getRe2());
        holder.re3.setText(vote.getRe3());
        holder.re4.setText(vote.getRe4());
        holder.re5.setText(vote.getRe5());

        holder.re1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked =holder.re1.isChecked();
                if(isChecked){
                    String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String key = FirebaseDatabase.getInstance().getReference("votesr").push().getKey();
                    votesr voter = new votesr(key,vote.getId(),vote.getRe1(),userid);

                    FirebaseDatabase.getInstance().getReference("votesr")
                            .child(key)
                            .setValue(voter).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {

                                        holder.re1.setVisibility(View.GONE);

                                    } else {
                                        holder.re2.setVisibility(View.GONE);
                                    }
                                }
                            });


                }else{
                    holder.question.setText("not good");
                }

            }
        });
        holder.re2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked =holder.re2.isChecked();
                if(isChecked){
                    String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String key = FirebaseDatabase.getInstance().getReference("votesr").push().getKey();
                    votesr voter = new votesr(key,vote.getId(),vote.getRe2(),userid);

                    FirebaseDatabase.getInstance().getReference("votesr")
                            .child(key)
                            .setValue(voter).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {

                                        holder.re1.setVisibility(View.GONE);

                                    } else {
                                        holder.re2.setVisibility(View.GONE);
                                    }
                                }
                            });


                }else{
                    holder.question.setText("not good");
                }

            }
        });
        holder.re3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked =holder.re3.isChecked();
                if(isChecked){
                    String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String key = FirebaseDatabase.getInstance().getReference("votesr").push().getKey();
                    votesr voter = new votesr(key,vote.getId(),vote.getRe3(),userid);

                    FirebaseDatabase.getInstance().getReference("votesr")
                            .child(key)
                            .setValue(voter).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {

                                        holder.re1.setVisibility(View.GONE);

                                    } else {
                                        holder.re2.setVisibility(View.GONE);
                                    }
                                }
                            });


                }else{
                    holder.question.setText("not good");
                }

            }
        });
        holder.re4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked =holder.re4.isChecked();
                if(isChecked){
                    String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String key = FirebaseDatabase.getInstance().getReference("votesr").push().getKey();
                    votesr voter = new votesr(key,vote.getId(),vote.getRe4(),userid);

                    FirebaseDatabase.getInstance().getReference("votesr")
                            .child(key)
                            .setValue(voter).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {

                                        holder.re1.setVisibility(View.GONE);

                                    } else {
                                        holder.re2.setVisibility(View.GONE);
                                    }
                                }
                            });


                }else{
                    holder.question.setText("not good");
                }

            }
        });
        holder.re5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked =holder.re5.isChecked();
                if(isChecked){
                    String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String key = FirebaseDatabase.getInstance().getReference("votesr").push().getKey();
                    votesr voter = new votesr(key,vote.getId(),vote.getRe5(),userid);

                    FirebaseDatabase.getInstance().getReference("votesr")
                            .child(key)
                            .setValue(voter).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {

                                        holder.re1.setVisibility(View.GONE);

                                    } else {
                                        holder.re2.setVisibility(View.GONE);
                                    }
                                }
                            });


                }else{
                    holder.question.setText("not good");
                }

            }

        });
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
        TextView question, datefin, idvote;
        CheckBox re1,re2,re3,re4,re5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.textquestion);
            idvote = itemView.findViewById(R.id.idvote);
            datefin = itemView.findViewById(R.id.textdatefin);
            re1 = itemView.findViewById(R.id.r1check);
            re2 = itemView.findViewById(R.id.r2check);
            re3 = itemView.findViewById(R.id.r3check);
            re4 = itemView.findViewById(R.id.r4check);
            re5 = itemView.findViewById(R.id.r5check);

        }
    }
}

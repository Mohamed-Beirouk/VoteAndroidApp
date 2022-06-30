package com.example.vote;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.concurrent.Executor;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Activity context;
    ArrayList<votes> listvotes;
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private androidx.biometric.BiometricPrompt.PromptInfo promptinfo;

    public MyAdapter(Activity context, ArrayList<com.example.vote.votes> votes) {
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

//                                        Toast.makeText(context, "Publié avec succés", Toast.LENGTH_SHORT).show();
                                        myfinger();

                                    } else {
                                        Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                }else{
                    Toast.makeText(context, "erreur survenue", Toast.LENGTH_SHORT).show();
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

                                        myfinger();
                                    } else {
                                        Toast.makeText(context, "erreur", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                }else{
                    Toast.makeText(context, "erreur survenue", Toast.LENGTH_SHORT).show();
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
                                        myfinger();
                                    } else {
                                        Toast.makeText(context, "erreur", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                }else{
                    holder.question.setText("ereeur survenue");
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
                                        myfinger();
                                    } else {
                                        Toast.makeText(context, "Erreur", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                }else{
                    holder.question.setText("erreur survenue");
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

                                        myfinger();
                                    } else {
                                        Toast.makeText(context, "ereeur survenue", Toast.LENGTH_SHORT).show();
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
    public void myfinger(){
        Executor executor = ContextCompat.getMainExecutor(context);

        biometricPrompt=new BiometricPrompt((FragmentActivity) context, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);

            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(context,
                                "voted done",
                                Toast.LENGTH_LONG)
                        .show();

            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });
        promptinfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Empreinte Auth")
                .setSubtitle("placer votre empreinte meged wjhak")
                .setNegativeButtonText("wella 6ra7 tlfun mahi lak !!")
                .build();
        biometricPrompt.authenticate(promptinfo);
//        fingerprint.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });
    }
}

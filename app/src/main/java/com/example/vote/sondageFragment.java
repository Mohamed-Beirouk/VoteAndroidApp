package com.example.vote;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executor;


public class sondageFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<votes> listvotes;
    public ArrayList<votesr> listvotesr = new ArrayList<>();
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    MyAdapter adapter;

    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private androidx.biometric.BiometricPrompt.PromptInfo promptinfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sondage, container, false);
        recyclerView = (RecyclerView)  view.findViewById(R.id.recycleview);


        databaseReference = FirebaseDatabase.getInstance().getReference("votes");
        listvotes = new ArrayList<>();
        adapter= new MyAdapter(getActivity(), listvotes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listvotesr=adddata();
                int vatsawet=0;
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    votes vote = dataSnapshot.getValue(votes.class);
                     vatsawet=0;
                    for(votesr v : listvotesr){
                       if( v.getUserid().equals(FirebaseAuth.getInstance().getCurrentUser().getUid()) && v.getIdv().equals(vote.getId())) {
                           vatsawet=1;
                       }
                    }
                    if(vatsawet==0){
                        try {
                            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(vote.getDatefin());
                            if(date1.after(new Date())){
                                listvotes.add(vote);}
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                    }
                adapter.notifyDataSetChanged();
            } @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
        return view;
    }
    public boolean VatSawet(String iduser,votes vote,ArrayList<votesr> listvotesr){
            for(votesr votesr : listvotesr){
                if(votesr.getUserid()==iduser && votesr.getIdv()==vote.getId()){
                    return true;
                }
            }
            return false;
    }
    public ArrayList<votesr> adddata(){
        databaseReference2 = FirebaseDatabase.getInstance().getReference("votesr");
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    votesr voter = dataSnapshot.getValue(votesr.class);
                    listvotesr.add(voter);

                }
            }@Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
        return listvotesr;
    }

}
package com.example.vote;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.datepicker.MaterialStyledDatePickerDialog;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class addVoteFragment extends Fragment {

    private EditText question, r1, r2, r3, r4, r5;
    String date2;
    private Button pickdatebtn, publierbn;
    private FirebaseAuth mAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_add_vote, container, false);
        question = view.findViewById(R.id.question);
        r1 = view.findViewById(R.id.r1);
        r2 = view.findViewById(R.id.r2);
        r3 = view.findViewById(R.id.r3);
        r4 = view.findViewById(R.id.r4);
        r5 = view.findViewById(R.id.r5);


        pickdatebtn = view.findViewById(R.id.pickdatebtn);
        publierbn = view.findViewById(R.id.publierbtn);

        pickdatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDatePickerDialog();
            }
        });
        publierbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addvote();
            }
        });

        return view;
    }

    private void addvote() {
        String ques = question.getText().toString().trim();
        String date = correctDate(date2);
        String re1 = r1.getText().toString().trim();
        String re2 = r2.getText().toString().trim();
        String re3 = r3.getText().toString().trim();
        String re4 = r4.getText().toString().trim();
        String re5 = r5.getText().toString().trim();


        String key = FirebaseDatabase.getInstance().getReference("votes").push().getKey();
        votes vote = new votes(key,ques,date,re1,re2,re3,re4,re5);

        FirebaseDatabase.getInstance().getReference("votes")
                .child(key)
                .setValue(vote).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getActivity(), "Publié avec succés", Toast.LENGTH_SHORT).show();
                            //addvotereponces();


                            Intent intent = new Intent(getActivity(),  home.class);
                           startActivity(intent);

                        } else {
                            Toast.makeText(getActivity(), "Erreur est survenue, ressayer!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

//    private void addvotereponces() {
//        String re1 = r1.getText().toString().trim();
//        String re2 = r2.getText().toString().trim();
//        String re3 = r3.getText().toString().trim();
//        String re4 = r4.getText().toString().trim();
//        String re5 = r5.getText().toString().trim();
//
//
//
//        String keyr1 = FirebaseDatabase.getInstance().getReference("votesr").push().getKey();
//        votesr votesr1 = new votesr(keyr1,key,re1);
//        FirebaseDatabase.getInstance().getReference("votesr")
//                .child(keyr1)
//                .setValue(votesr1).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//
//                        } else {
//                        }
//                    }
//                });
//        String keyr2 = FirebaseDatabase.getInstance().getReference("votesr").push().getKey();
//        votesr votesr2 = new votesr(keyr2,key,re2);
//        FirebaseDatabase.getInstance().getReference("votesr")
//                .child(keyr2)
//                .setValue(votesr2).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//
//                        } else {
//                        }
//                    }
//                });
//        String keyr3 = FirebaseDatabase.getInstance().getReference("votesr").push().getKey();
//        votesr votesr3 = new votesr(keyr3,key,re3);
//        FirebaseDatabase.getInstance().getReference("votesr")
//                .child(keyr3)
//                .setValue(votesr3).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//
//                        } else {
//                        }
//                    }
//                });
//        String keyr4 = FirebaseDatabase.getInstance().getReference("votesr").push().getKey();
//        votesr votesr4 = new votesr(keyr4,key,re4);
//        FirebaseDatabase.getInstance().getReference("votesr")
//                .child(keyr4)
//                .setValue(votesr4).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//
//                        } else {
//                        }
//                    }
//                });
//        String keyr5 = FirebaseDatabase.getInstance().getReference("votesr").push().getKey();
//        votesr votesr5 = new votesr(keyr5,key,re5);
//        FirebaseDatabase.getInstance().getReference("votesr")
//                .child(keyr5)
//                .setValue(votesr5).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//
//                        } else {
//                        }
//                    }
//                });
//
//
//
//    }

    private void showDatePickerDialog() {
        MaterialDatePicker materialDatePicker= MaterialDatePicker.Builder.datePicker().
                setTitleText("Select Date").build();



        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onPositiveButtonClick(Object selection) {

                date2=materialDatePicker.getHeaderText();
                pickdatebtn.setText(""+materialDatePicker.getHeaderText());

            }
        });

        materialDatePicker.show(getActivity().getSupportFragmentManager(), "Date");

    }
    public String correctDate(String d){
        char x,y,z;
        x=d.charAt(0);
        y=d.charAt(1);
        z=d.charAt(2);
        String month = ""+x+y+z;
        switch (month){
            case "jan":
                month="01";
                break;
            case "Feb":
                month="02";
                break;
            case "Mar":
                month="03";
                break;
            case "Apr":
                month="04";
                break;
            case "May":
                month="05";
                break;
            case "Jun":
                month="06";
                break;
            case "Jul":
                month="07";
                break;
            case "Aug":
                month="08";
                break;
        }
        char a,b;
        a=d.charAt(4);
        b=d.charAt(5);

        String day = ""+a+b;

        char c,cc,e,f;

        c=d.charAt(8);
        cc=d.charAt(9);
        e=d.charAt(10);
        f=d.charAt(11);

        String year = (""+c+""+cc+""+e+""+f);

        String result =day+"/"+month+"/"+year;
        return result;
    }

}
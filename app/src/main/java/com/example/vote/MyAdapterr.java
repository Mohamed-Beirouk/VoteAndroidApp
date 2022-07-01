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

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MyAdapterr extends RecyclerView.Adapter<MyAdapterr.MyViewHolder> {
    Context context;
    ArrayList<votes> listvotes;
    ArrayList<votesr> votesrlist = new ArrayList<>();
    ArrayList barArrayList;


    public MyAdapterr(Context context, ArrayList<com.example.vote.votes> votes) {
        this.context = context;
        this.listvotes = votes;
        DatabaseReference databaseReference2 = FirebaseDatabase.getInstance().getReference("votesr");
        databaseReference2.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    votesr voter = dataSnapshot.getValue(votesr.class);
                    votesrlist.add(voter);
                }
            }@Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
        //inidata();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.votesresult, parent, false);

        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        votes vote = listvotes.get(position);
        holder.question.setText(vote.getQuestion());
        //traitement resultat
        Log.e(" -------------------", "----------- = "+votesrlist.size());
        int nr1=0,nr2=0,nr3=0,nr4=0,nr5=0;
        for(votesr v : votesrlist){
            if(v.getIdv().equals(vote.getId())  && v.getRep().equals(vote.getRe1()) ){
                nr1++;
            }
            if(v.getIdv().equals(vote.getId())  && v.getRep().equals(vote.getRe2()) ){
                nr2++;
            }
            if(v.getIdv().equals(vote.getId())  && v.getRep().equals(vote.getRe3()) ){
                nr3++;
            }
            if(v.getIdv().equals(vote.getId())  && v.getRep().equals(vote.getRe4()) ){
                nr4++;
            }
            if(v.getIdv().equals(vote.getId())  && v.getRep().equals(vote.getRe5()) ){
                nr5++;
            }

        }
        if(vote.getRe3().length()<1){
//            holder.re3.setVisibility(View.GONE);
//            Log.e(" cond", "re3 = "+vote.getRe3());
        }
        if(vote.getRe4().length()<1){
//            holder.re4.setVisibility(View.GONE);
        }
        if(vote.getRe5().length()<1){
//            holder.re5.setVisibility(View.GONE);
        }

//        holder.re1.setText(vote.getRe1()+" a eu "+nr1+" votes");
//        holder.re2.setText(vote.getRe2()+" a eu "+nr2+" votes");
//        holder.re3.setText(vote.getRe3()+" a eu "+nr3+" votes");
//        holder.re4.setText(vote.getRe4()+" a eu "+nr4+" votes");
//        holder.re5.setText(vote.getRe5()+" a eu "+nr5+" votes");

        inidata();
        BarDataSet bardataset;
        bardataset = new BarDataSet(barArrayList, "question");
        BarData bardata = new BarData(bardataset);
        holder.barchart.setData(bardata);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        bardataset.setValueTextColor(android.R.color.black);
        bardataset.setValueTextSize(16f);
        holder.barchart.getDescription().setEnabled(true);
        XAxis xAxis = holder.barchart.getXAxis();
        final String[] labels = new String[] {"Dummy", "Jan", "Feb", "March", "April","mai","jun"};
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setGranularity(0f);
        xAxis.setGranularityEnabled(true);



    }
    public void inidata()
    {
        barArrayList = new ArrayList();
        barArrayList.add(new BarEntry(2f,10));
        barArrayList.add(new BarEntry(3f,20));
        barArrayList.add(new BarEntry(4f,30));
        barArrayList.add(new BarEntry(5f,40));
        barArrayList.add(new BarEntry(6f,50));
    }
        @Override
        public int getItemCount () {
            return listvotes.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {
            TextView question;
            CheckBox re1, re2, re3, re4, re5;
            BarChart barchart;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                question = itemView.findViewById(R.id.textquestionn);
                barchart = itemView.findViewById(R.id.barchart);

//                re1 = itemView.findViewById(R.id.r1checkn);
//                re2 = itemView.findViewById(R.id.r2checkn);
//                re3 = itemView.findViewById(R.id.r3checkn);
//                re4 = itemView.findViewById(R.id.r4checkn);
//                re5 = itemView.findViewById(R.id.r5checkn);





            }

        }


    }

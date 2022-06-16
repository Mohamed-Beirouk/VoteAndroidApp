package com.example.vote;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textview.MaterialTextView;

public class addVoteFragment extends Fragment {
    private  MaterialTextView editdate;
    private EditText question, r1, r2, r3, r4, r5;
    private Button pickdatebtn, publierbn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_add_vote, container, false);
        editdate = view.findViewById(R.id.date);
        pickdatebtn = view.findViewById(R.id.pickdatebtn);
        publierbn = view.findViewById(R.id.publierbtn);

        pickdatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        return view;
    }

    private void showDatePickerDialog() {
        MaterialDatePicker materialDatePicker= MaterialDatePicker.Builder.datePicker().
                setTitleText("Select Date").build();

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                editdate.setText(""+materialDatePicker.getHeaderText());
            }
        });

        materialDatePicker.show(getActivity().getSupportFragmentManager(), "Date");

    }


}
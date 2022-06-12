package com.example.vote;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class profileFragment extends Fragment {
    private TextView profileLibelle;
    private TextView profileLibelle2;
    private TextInputLayout editTextProfileLibelle;
    private TextInputLayout editTextProfileemail;
    private TextInputLayout editTextProfileusername;
    private TextInputLayout editTextProfilepassword;
    private Button logout;
// url = "https://console.firebase.google.com/project/votingapprim/database/data";
    private FirebaseUser user;
    private DatabaseReference reference;




//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        logout = view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(),  MainActivity.class);
                startActivity(intent);
            }
        });


        profileLibelle = view.findViewById(R.id.profileLibelle);
        profileLibelle2 = view.findViewById(R.id.profileLibelle2);
        editTextProfileLibelle = view.findViewById(R.id.editTextProfileLibelle);
        editTextProfileemail = view.findViewById(R.id.editTextProfileemail);
        editTextProfileusername = view.findViewById(R.id.editTextProfileusername);
        editTextProfilepassword = view.findViewById(R.id.editTextProfilepassword);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users");
        String useremail = user.getEmail();
        editTextProfileemail.getEditText().setText(useremail);
        String name = user.getDisplayName();
        profileLibelle.setText(name);
        profileLibelle2.setText(name);
        editTextProfileLibelle.getEditText().setText(name);

        return view;
    }


}
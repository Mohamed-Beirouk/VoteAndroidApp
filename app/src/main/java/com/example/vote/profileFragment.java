package com.example.vote;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        String useremail = user.getEmail();
        editTextProfileemail.getEditText().setText(useremail);

//

        reference = FirebaseDatabase.getInstance().getReference("users");
        DatabaseReference nom =  reference.child(user.getUid()).child("nom");
        DatabaseReference username =  reference.child(user.getUid()).child("username");
        Log.e("nom", "nom : " +nom );
        nom.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nom = dataSnapshot.getValue(String.class);
                Log.e("nom", "nom : " +nom );
                editTextProfileLibelle.getEditText().setText(nom);
                profileLibelle.setText(nom);
                profileLibelle2.setText(nom);

            }@Override
            public void onCancelled(@NonNull DatabaseError error) {}});

        username.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String username = dataSnapshot.getValue(String.class);
                Log.e("nom", "nom : " +username );
                editTextProfileusername.getEditText().setText(username);

            }@Override
            public void onCancelled(@NonNull DatabaseError error) {}});
//        profileLibelle.setText(name);
//        profileLibelle2.setText(name);
//        editTextProfileLibelle.getEditText().setText(name);

        return view;
    }


}
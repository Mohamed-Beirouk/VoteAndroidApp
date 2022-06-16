package com.example.vote;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class inscription extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    private Button registerbtn;

    private EditText editemail;
    private EditText editpassword;
    private EditText editnom;
    private EditText editempreinte;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscriptionactivity);
        mAuth = FirebaseAuth.getInstance();

        registerbtn = (Button) findViewById(R.id.registerbtn);
        registerbtn.setOnClickListener(this);

        editnom = (EditText) findViewById(R.id.nom);
        editemail = (EditText) findViewById(R.id.email);
        editpassword = (EditText) findViewById(R.id.password);
        editempreinte = (EditText) findViewById(R.id.empreinte);



    }

    @Override
    public void onClick(View v) {

        registerUser();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    public void registerUser(){
        String email = editemail.getText().toString().trim();
        String password = editpassword.getText().toString().trim();
        String nom = editnom.getText().toString().trim();
        String empreinte = editempreinte.getText().toString().trim();
        if(nom.isEmpty()){
            editnom.setError("Le nom maynsab 3anu");
            editnom.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editemail.setError("L'email mahu sale7");
            editemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editpassword.setError("Le password maynsab 3anu");
            editpassword.requestFocus();
            return;
        }
        if(password.length()<6){
            editpassword.setError("6 char au moins");
            editpassword.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(nom,empreinte);
                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(getApplicationContext(),
                                                                "Login successful!!",
                                                                Toast.LENGTH_LONG)
                                                        .show();

                                                Intent intent = new Intent(inscription.this,  home.class);
                                                startActivity(intent);}
                                            else {
                                                Toast.makeText(inscription.this, "error ", Toast.LENGTH_LONG).show();

                                            }
                                        }
                                    });
                        }
                    }
                });




    }
}

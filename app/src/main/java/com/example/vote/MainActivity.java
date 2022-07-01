package com.example.vote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import androidx.biometric.BiometricPrompt;
//import androidx.biometric.BiometricPrompt.PromptInfo;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private Button loginBtn, fingerprint;
    private Button inscription;
    private EditText emailv;
    private EditText passwordv;
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private androidx.biometric.BiometricPrompt.PromptInfo promptinfo;


    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        loginBtn = findViewById(R.id.loginBtn);
        emailv = findViewById(R.id.email);
        passwordv = findViewById(R.id.password);
        inscription = findViewById(R.id.inscription);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailv.getText();
                passwordv.getText();
                loginUserAccount();

            }
        });
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,  inscription.class);
                startActivity(intent);
            }
        });


    }
    public void myfinger(){
        Executor executor = ContextCompat.getMainExecutor(this);

        biometricPrompt=new BiometricPrompt(MainActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                loginBtn.setText("error");
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),
                                "Login successful!!",
                                Toast.LENGTH_LONG)
                        .show();

                Intent intent = new Intent(MainActivity.this,  home.class);
                startActivity(intent);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                loginBtn.setText("failed");
            }
        });
        promptinfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Empreinte Auth")
                .setSubtitle("placer votre empreinte sous le lecteur")
                .setNegativeButtonText("6ar7a mtna8ra !!")
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
    private void loginUserAccount()
    {
        String email, password;
        email = emailv.getText().toString().trim();

        password = passwordv.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter email!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    myfinger();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),
                                                    "Login failed!!"+password,
                                                    Toast.LENGTH_LONG)
                                            .show();
                                }
                            }
                        });
    }
}
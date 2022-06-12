package com.example.vote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class home extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    profileFragment profileFragment = new profileFragment();
    addVoteFragment addVoteFragment = new addVoteFragment();
    resultFragment resultFragment = new resultFragment();
    sondageFragment sondageFragment = new sondageFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.conn, profileFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.conn, profileFragment).commit();
                        return true;
                    case R.id.nouveau:
                        getSupportFragmentManager().beginTransaction().replace(R.id.conn, addVoteFragment).commit();
                        return true;
                    case R.id.votes:
                        getSupportFragmentManager().beginTransaction().replace(R.id.conn, sondageFragment).commit();
                        return true;
                    case R.id.results:
                        getSupportFragmentManager().beginTransaction().replace(R.id.conn, resultFragment).commit();
                        return true;

                }
                return false;
            }

        });

//    private void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        fragmentTransaction.replace(R.id.frame_layout, fragment);
//        fragmentTransaction.commit();
//    }
    }
}
package com.example.lacie.rentapp;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    final String members = "members";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        preferences = getPreferences(MODE_PRIVATE);
//        String saved = preferences.getString(members, "");
//        if (saved.isEmpty() || saved.equals("")){
//            //TODO opening registration fragment
//        } else {
//            //TODO opening members and counting fragment
//        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, new CountFragment());
        transaction.commit();

    }
}

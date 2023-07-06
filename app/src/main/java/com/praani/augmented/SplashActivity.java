package com.praani.augmented;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);




        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean showSplash = sharedPreferences.getBoolean("show_splash", true);




        if (showSplash) {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("show_splash", false);
            editor.apply();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                    String language = sharedPreferences.getString("language", "");

                    if (!language.isEmpty()) {

                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }else{
                        startActivity(new Intent(SplashActivity.this, LangActivity.class));
                    }

                }
            },3000);



        } else {

            startActivity(new Intent(SplashActivity.this,LangActivity.class));

        }
// Retrieve a preference value
//        boolean showSplash = sharedPreferences.getBoolean("show_splash", true);

// Update a preference value
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putBoolean("show_splash", false);
//        editor.apply();




    }
}
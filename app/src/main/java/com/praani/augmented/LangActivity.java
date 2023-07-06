package com.praani.augmented;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class LangActivity extends AppCompatActivity {

    SharedPreferences preferences;
    RadioGroup radioGroup;
    Button en,hi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);

        en = findViewById(R.id.rd_en);
        hi = findViewById(R.id.rd_hi);


        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                setLocale("en");
                preferences = getSharedPreferences("Lang", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("language", "eng"); // 'language' is the selected language code
                editor.apply();
                startActivity(new Intent(LangActivity.this,MainActivity.class));
                finish();

            }
        });
        hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                setLocale("hi");
                preferences = getSharedPreferences("Lang", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("language", "hin"); // 'language' is the selected language code
                editor.apply();
                startActivity(new Intent(LangActivity.this,MainActivity.class));
                finish();

            }
        });














    }
    private void setLocale(String languageCode) {
        Context context = LocaleHelper.setLocale(this, languageCode);
        Configuration configuration = context.getResources().getConfiguration();
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }
}
package com.example.presupuestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class intro extends AppCompatActivity {

    private static final long SPLASH_TIMEOUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(intro.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        }, SPLASH_TIMEOUT);
    }
}
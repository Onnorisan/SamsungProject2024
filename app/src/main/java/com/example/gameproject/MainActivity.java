package com.example.gameproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    public void goGame() {
        Intent intent = new Intent(MainActivity.this, game.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, 0);
    }
    public void rules() {
        Intent intent = new Intent(MainActivity.this, rules.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnstart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goGame();
            }
        });

        button = findViewById(R.id.rules);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules();
            }
        });
    }
}
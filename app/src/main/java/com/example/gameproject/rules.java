package com.example.gameproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rules extends AppCompatActivity {
    Button btn;
    public void goStart() {
        Intent intent = new Intent(rules.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        btn=findViewById(R.id.btn);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goStart();
            }
        });
    }
}
package com.example.androidshtrausandazenkot_4_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.start);
        Button quit = findViewById(R.id.quit);

        quit.setOnClickListener(e->{
            finish();
            System.exit(0);
        });
        start.setOnClickListener(view->{
            Intent intent = new Intent(this,Details.class);
            startActivity(intent);
            //closing the current activity
            finish();
        });
    }
}
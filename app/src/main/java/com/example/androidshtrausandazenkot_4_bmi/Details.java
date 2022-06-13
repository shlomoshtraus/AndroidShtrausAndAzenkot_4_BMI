package com.example.androidshtrausandazenkot_4_bmi;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        @SuppressLint("WrongViewCast")
        EditText firstName = findViewById(R.id.first_name_text);
        @SuppressLint("WrongViewCast")
        EditText lastName = findViewById(R.id.last_name_text);
        @SuppressLint("WrongViewCast")
        EditText age = findViewById(R.id.age_number);
        @SuppressLint("WrongViewCast")
        RadioGroup gender = findViewById(R.id.gender_group);
        Button next = findViewById(R.id.next);


        next.setOnClickListener(view->{
            if(firstName.getText().toString().equals("") || lastName.getText().toString().equals("") || age.getText().toString().equals("") || gender.getCheckedRadioButtonId() == -1){
                Toast.makeText(this, "Fill in all the required fields!",
                        Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(this,Body_information.class);
                intent.putExtra("age",Integer.parseInt(age.getText().toString()));
                startActivity(intent);
                //closing the current activity
                finish();
            }
        });

    }

}
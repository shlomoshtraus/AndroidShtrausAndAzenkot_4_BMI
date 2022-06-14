package com.example.androidshtrausandazenkot_4_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.google.android.material.slider.Slider;


public class Body_information extends AppCompatActivity {

    Intent intent;
    RadioButton getSmall, getMedium, getLarge;
    Double slimness;
    EditText weight;
    Slider height;
    Button submit;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_information);

        getSmall = findViewById(R.id.small);
        getMedium = findViewById(R.id.medium);
        getLarge = findViewById(R.id.large);
        height = findViewById(R.id.heightSlider);
        weight = findViewById(R.id.actual_weight_input);
        group = findViewById(R.id.body_frame_group);
        submit = findViewById(R.id.submit);
        intent = getIntent();

        submit.setOnClickListener(e -> {
            //in case the user didn't put any data in the text field
            if (weight.getText().toString().equals(""))
                Toast.makeText(this, "Fill in all the required fields!",
                        Toast.LENGTH_SHORT).show();
            else {
                //setting up the 'slimness' variable
                slimness = findSelectedRadioButton(group.getCheckedRadioButtonId());
                //pass the data field to the ResultActivity activity.
                intent.putExtra("height", (int)height.getValue());
                intent.putExtra("slimness", slimness);
                intent.putExtra("weight", Double.parseDouble(weight.getText().toString()));
                intent.setClass(this,Result.class);
                startActivity(intent);
                //closing the current activity
                finish();

            }
        });


    }

    private Double findSelectedRadioButton(int checkButtonId) {
        //getting the button that is benn checked
        if (checkButtonId == R.id.small) {
            return 0.9;
        } else if (checkButtonId == R.id.medium) {
            return 1.0;
        } else
            return 1.1;
    }
}
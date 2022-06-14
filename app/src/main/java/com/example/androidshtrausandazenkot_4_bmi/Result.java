package com.example.androidshtrausandazenkot_4_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    int age;
    double weight, bmi, idealWeight, height, slimness;
    String status;
    TextView bmiResult, statusResult, idealWeightResult, MessageDetails;
    Button mainButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        bmiResult = findViewById(R.id.bmi_result);
        idealWeightResult = findViewById(R.id.ideal_weight_result);
        statusResult = findViewById(R.id.status_result);
//        MessageDetails = findViewById(R.id.messageDetails);
        mainButton = findViewById(R.id.main_page);
        //getting all the data from the intent.
        age = getIntent().getIntExtra("age", 0);
        slimness = getIntent().getDoubleExtra("slimness", 0);
        weight = getIntent().getDoubleExtra("weight", 0);
        height = (getIntent().getIntExtra("height", 0)) / 100.0;
        //calculation the BMI.
        bmi = weight / (height * height);
        //calculation the ideal weight.
        idealWeight = ((height * 100) - 100 + (age / 10.0)) * 0.9 * slimness;

        updateWeightStatus(bmi);
        bmiResult.setText(""+ bmi);
        idealWeightResult.setText("" + idealWeight);
        statusResult.setText(status);



        mainButton.setOnClickListener(v ->
        {
            //switching to the MainActivity.
            startActivity(new Intent(this, MainActivity.class));
            //closing the current activity
            finish();
        });

    }
    private void updateWeightStatus(double bmiValue) {
        //calculation the weight status based on the bmi.
        if (bmiValue < 15)
            status = "Anorexic";
        else if (15 <= bmiValue && bmiValue < 18.5)
            status = "Underweight";
        else if (18.5 <= bmiValue && bmiValue < 25)
            status = "Normal";
        else if (25 <= bmiValue && bmiValue < 30)
            status = "Overweight";
        else if (30 <= bmiValue && bmiValue < 35)
            status = "Obese";
        else if (35 <= bmiValue)
            status = "Extreme Obese";
    }
}
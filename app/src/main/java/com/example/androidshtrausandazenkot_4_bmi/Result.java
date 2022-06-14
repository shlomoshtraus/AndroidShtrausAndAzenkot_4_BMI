package com.example.androidshtrausandazenkot_4_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Result extends AppCompatActivity {
    int age;
    double weight, bmi, idealWeight, height, slimness;
    String status;
    TextView bmiResult, statusResult, idealWeightResult;
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

        bmiResult.setText(""+ new DecimalFormat("##.###").format(bmi));
        updateWeightStatus(bmi);
        idealWeightResult.setText("" + new DecimalFormat("##.###").format(idealWeight));
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
        if (bmiValue < 15){
            status = "Anorexic";
            bmiResult.setTextColor(Color.RED);
            statusResult.setTextColor(Color.RED);}
        else if (15 <= bmiValue && bmiValue < 18.5){
            status = "Underweight";
            bmiResult.setTextColor(Color.RED);
            statusResult.setTextColor(Color.RED);}
        else if (18.5 <= bmiValue && bmiValue < 25){
            status = "Normal";
            bmiResult.setTextColor(Color.BLUE);
            statusResult.setTextColor(Color.BLUE);}
        else if (25 <= bmiValue && bmiValue < 30){
            status = "Overweight";
            bmiResult.setTextColor(Color.RED);
            statusResult.setTextColor(Color.RED);}
        else if (30 <= bmiValue && bmiValue < 35){
            status = "Obese";
            bmiResult.setTextColor(Color.RED);
            statusResult.setTextColor(Color.RED);}
        else if (35 <= bmiValue){
            status = "Extreme Obese";
            bmiResult.setTextColor(Color.RED);
            statusResult.setTextColor(Color.RED);}
    }
}
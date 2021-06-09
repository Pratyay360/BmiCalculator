package com.pratyay.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {
    RadioButton male, female;
    EditText age, feet, inch, weight;
    Button calculate;
    TextView result, remark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        age = findViewById(R.id.age);
        feet = findViewById(R.id.feet);
        inch = findViewById(R.id.inch);
        weight = findViewById(R.id.weight);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);
        remark = findViewById(R.id.remark);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmians = calculatebmi();
                String ageText = age.getText().toString();
                int age = Integer.parseInt(ageText);
                if (age >= 14) {
                    displayresult(bmians);
                } else {
                    displayminor(bmians);
                }


                Toast.makeText(MainActivity2.this, "Calculation Done!!", Toast.LENGTH_SHORT).show();
            }
            @SuppressLint("SetTextI18n")
            private double calculatebmi(){

                String feetText = feet.getText().toString();
                String inchText = inch.getText().toString();
                String wei = weight.getText().toString();
                //converting Strings to int
                int feet = Integer.parseInt(feetText);
                int inch = Integer.parseInt(inchText);
                int weight = Integer.parseInt(wei);
                int totalInch = (feet * 12) + inch;
                double heightinm = totalInch * 0.0254;
                return weight / (heightinm * heightinm);
            }
            //UNDER 18 MINOR
            private void displayminor(double bmi) {
                DecimalFormat myDecimalFormat = new DecimalFormat("0.00");
                String bmiresult = myDecimalFormat.format(bmi);
                String bmiremark;
                if (male.isChecked()) {
                    //Display Boy
                    bmiremark = "Concult Doctor For Bmi";
                } else if (female.isChecked()) {
                    //Display Girl
                    bmiremark = "Concult Doctor For Bmi";
                }else {
                    //general
                    bmiremark = "Concult Doctor For Bmi";
                }
                result.setText(bmiresult);
                remark.setText(bmiremark);

            }
            // Adult
            private void displayresult(double bmi) {
                DecimalFormat myDecimalFormat = new DecimalFormat("0.00");
                String bmiresult = myDecimalFormat.format(bmi);
                String bmiremark;
                if (bmi < 18.5) {
                    bmiremark = "Under Weight";
                } else if (bmi > 25) {
                    bmiremark = "Over Weight";
                } else {
                    bmiremark = "Healthy";
                }
                result.setText(bmiresult);
                remark.setText(bmiremark);

            }
        });










    }
}
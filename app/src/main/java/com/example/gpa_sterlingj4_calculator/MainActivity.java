package com.example.gpa_sterlingj4_calculator;
// Made by Justin Sterling      -App to calculate GPA based on 5 courses
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    //Method to check if an EditText box is empty
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize button, textViews, layout and editTexts by ID
        final Button button = findViewById(R.id.button);
        final TextView textEmpty = findViewById(R.id.textEmpty);
        final EditText text1 = findViewById(R.id.text1);
        final EditText text2 = findViewById(R.id.text2);
        final EditText text3 = findViewById(R.id.text3);
        final EditText text4 = findViewById(R.id.text4);
        final EditText text5 = findViewById(R.id.text5);
        final TextView textgpa = findViewById(R.id.textgpa);
        final ConstraintLayout background = (ConstraintLayout) findViewById(R.id.container);

        final String textA = "Calculate GPA";
        final String textB = "Clear form";
        //Event listener for when button is pressed
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Boolean for if any of the input fields are empty
                boolean empty = (isEmpty(text1) || isEmpty(text2) || isEmpty(text3) ||
                        isEmpty(text4) || isEmpty(text5));
                //If No fields are empty and button = 'Calculate GPA'
                if ((button.getText() == textA) && !empty) {
                    //Change button text, get numbers from fields and calculate GPA
                    button.setText(textB);
                    textEmpty.setVisibility(View.GONE);
                    double grade1 = Double.parseDouble(text1.getText().toString());
                    double grade2 = Double.parseDouble(text2.getText().toString());
                    double grade3 = Double.parseDouble(text3.getText().toString());
                    double grade4 = Double.parseDouble(text4.getText().toString());
                    double grade5 = Double.parseDouble(text5.getText().toString());

                    double gpa = (grade1 + grade2 + grade3 + grade4 + grade5) / 5;
                    textgpa.setText(String.format(Locale.US,"%.2f",gpa));
                    //Change background color based on GPA
                    if (gpa < 60)
                        background.setBackgroundColor(Color.RED);
                    else if (gpa <= 79)
                        background.setBackgroundColor(Color.YELLOW);
                    else if (gpa <= 100)
                        background.setBackgroundColor(Color.GREEN);
                }
                //If one of the fields are empty
                else if (button.getText() == textA && (empty)) {
                    textEmpty.setVisibility(View.VISIBLE);
                }
                //If the button == 'Clear form'
                else if (button.getText() != textA) {
                    //Clears inputs and GPA, sets button to 'Calculate GPA'
                    button.setText(textA);
                    text1.setText("");
                    text2.setText("");
                    text3.setText("");
                    text4.setText("");
                    text5.setText("");
                    textgpa.setText("");
                    background.setBackgroundColor(Color.WHITE);
                }
            }
        });
    }
}
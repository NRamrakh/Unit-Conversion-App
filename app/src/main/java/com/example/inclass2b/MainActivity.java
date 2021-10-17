/*
Assignment: In Class Assignment Number 2
File Name: MainActivity.java (For Question 2b)
Group Number 19
Full Name:
Nisha Ramrakhyani
Punit Mashruwala */

package com.example.inclass2b;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Demo";
    RadioGroup radioGroup;
    private CharSequence inchValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonConvert).setOnClickListener(this);
        radioGroup = findViewById(R.id.radioGroup);
    }

    @Override
    public void onClick(View v) {
        TextView resultTextView = findViewById(R.id.textViewResultValue);
        EditText inchTextView = findViewById(R.id.editTextInchValue);
        int checkedId = radioGroup.getCheckedRadioButtonId();
        inchValue = inchTextView.getText();
        if (checkedId == R.id.radioButtonClearAll) {
            Log.d(TAG, "onClick: button_clear_all");
            resultTextView.setText(getResources().getString(R.string.Empty_string));
            inchTextView.setText(getResources().getString(R.string.Empty_string));
        } else {
            if (inchValue.toString().isEmpty()) {
                Toast.makeText(this, getResources().getString(R.string.Toast_Empty_input), Toast.LENGTH_LONG).show();
            } else {
                try {
                    int inchIntValue = parseInt(inchValue.toString());
                    if (checkedId == R.id.radioButtonFeet) {
                        double FeetValue = ((double) inchIntValue) / 12;
                        resultTextView.setText(FeetValue + getResources().getString(R.string.Feet_unit));
                    } else if (checkedId == R.id.radioButtonMeters) {
                        double meterValue = inchIntValue * 0.0254;
                        resultTextView.setText(meterValue + getResources().getString(R.string.Meters_unit));
                    } else if (checkedId == R.id.radioButtonMiles) {
                        double milesValue = ((double) inchIntValue) / 63360;
                        resultTextView.setText(milesValue + getResources().getString(R.string.Miles_unit));
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(this, getResources().getString(R.string.Toast_Special_characters), Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}

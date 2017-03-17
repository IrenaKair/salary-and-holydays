package com.example.robertkaczmarek.wynagrodzeniacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;

import android.widget.Spinner;
import android.widget.TextView;

public class HolidayActivity extends AppCompatActivity  {
    Spinner school;
    int years;
    int ur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);


    }
    public void czysc(View view) {

        TextView dayHolidayx = (TextView) findViewById(R.id.dayHoliday);
        dayHolidayx.setText("              ");
        EditText yerWork = (EditText) findViewById(R.id.counHoliday);
        yerWork.setText("");
    }



    public void countDayHoliday(View view) {
        EditText yearWork = (EditText) findViewById(R.id.counHoliday);
        String yW = yearWork.getText().toString();
        int yWa = Integer.parseInt(yW);

        int staż = yWa+years;
        school = (Spinner) findViewById(R.id.hol);
        int x  = (Integer) school.getSelectedItemPosition();
        switch (x){
            case 0 :
                years = 2;
                break;
            case 1 :
                years = 3;
                break;
            case 2 :
                years = 4;
                break;
            case 3 :
                years = 5;
                break;
            case 4 :
                years = 4;
                break;
            case 5 :
                years = 6;
                break;

            case 6 :
                years = 8;
                break;
            default:
                break;
        }
        if (staż < 10) {
            ur = 20;
        } else if (staż >= 10) {
            ur = 26;
        }
        String urA = String.valueOf(ur);

        TextView dayHolidayx = (TextView) findViewById(R.id.dayHoliday);
        dayHolidayx.setText(urA);




    }


}








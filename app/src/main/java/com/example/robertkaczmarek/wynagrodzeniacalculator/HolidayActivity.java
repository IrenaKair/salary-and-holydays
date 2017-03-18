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
    Double ur;

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
        TextView countMHol = (TextView)findViewById(R.id.countMonthHol);
        countMHol.setText("");
        EditText month = (EditText)findViewById(R.id.monthHoliday);
        month.setText("");
    }



    public void countDayHoliday(View view) {
        EditText yearWork = (EditText) findViewById(R.id.counHoliday);
        String yW = yearWork.getText().toString();
        int yWa = Integer.parseInt(yW);


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
        int staż = yWa+years;
        if (staż < 10) {
            ur = 20.00;
        } else if (staż >= 10) {
            ur = 26.00;
        }
        String urA = String.valueOf(Math.round(ur));

        TextView dayHolidayx = (TextView) findViewById(R.id.dayHoliday);
        dayHolidayx.setText(urA);

        EditText month = (EditText)findViewById(R.id.monthHoliday);
        String monthA = month.getText().toString();
        int mmonth = Integer.parseInt(monthA);

        Double countMonthHol = ur/12*mmonth;
        String countMonthH = String.valueOf(Math.round(countMonthHol));

        TextView countMHol = (TextView)findViewById(R.id.countMonthHol);
        countMHol.setText(countMonthH);

    }


}








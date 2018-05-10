package com.example.robertkaczmarek.wynagrodzeniacalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class HolidayActivity extends Activity implements View.OnClickListener {
    Spinner school;
    int years;
    Double ur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);
        TextView infHol = (TextView)findViewById(R.id.textinfH);
        infHol.setOnClickListener(this);


    }
    public void czysc(View view) {
        EditText yerWork = (EditText) findViewById(R.id.counHoliday);
        yerWork.setText("");
        TextView countMHol = (TextView)findViewById(R.id.countMonthHol);
        countMHol.setText("");
        EditText month = (EditText)findViewById(R.id.monthHoliday);
        month.setText("");
    }



    public void countDayHoliday(View view) {
        school = (Spinner) findViewById(R.id.hol);
        int x  = (Integer) school.getSelectedItemPosition();
        switch (x){
            case 0 :
                years = 0;
                break;
            case 1 :
                years = 2;
                break;
            case 2 :
                years = 3;
                break;
            case 3 :
                years = 4;
                break;
            case 4 :
                years = 5;
                break;
            case 5 :
                years = 4;
                break;
            case 6 :
                years = 6;
                break;

            case 7 :
                years = 8;
                break;
            default:
                break;
        }
        EditText yearWork = (EditText) findViewById(R.id.counHoliday);
        String yW = yearWork.getText().toString();
        Double yWa = Double.parseDouble(yW);
        Double staż = yWa+years;
        if (staż < 10) {
            ur = 20.00;
        } else if (staż >= 10) {
            ur = 26.00;
        }
        String urA = String.valueOf(Math.round(ur));
        Intent goCountHol = new Intent(HolidayActivity.this, CountHoliday.class);
        goCountHol.putExtra(CountHoliday.YEAR_HOLIDAY, urA);
        startActivity(goCountHol);

    }

    @Override
    public void onClick(View view) {
        Intent goHol = new Intent(HolidayActivity.this, InfoHoliday.class);
        startActivity(goHol);
    }
}








package com.example.robertkaczmarek.wynagrodzeniacalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CountHoliday extends Activity {

    public static final String YEAR_HOLIDAY = "year_holiday";
    Double ur;
    String text1;
    String text2;
    String text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_holiday);

        Intent takeSalary = getIntent();
        String year_holiday = takeSalary.getStringExtra(YEAR_HOLIDAY);
         ur = Double.parseDouble(year_holiday);
        text1 = getString(R.string.text1);
        text2 = getString(R.string.text2);
        TextView dayHolidayx = (TextView) findViewById(R.id.wyliczenieUrlopu);
        dayHolidayx.setText(text1+" "+ "\n"+ year_holiday+ " "+ text2);
    }

    public void countDayHoliday(View view) {
        EditText month = (EditText)findViewById(R.id.monthHoliday);
        String monthA = month.getText().toString();
        Double mmonth = Double.parseDouble(monthA);
        Double countMonthHol = ur/12*mmonth;
        text3 = getString(R.string.monthHoliday);
        String countMonthH = String.valueOf(Math.round(countMonthHol));
        TextView countMHol = (TextView)findViewById(R.id.countMonthHol);
        countMHol.setText(text3+ "\n"+ countMonthH+" "+ text2);
    }
}

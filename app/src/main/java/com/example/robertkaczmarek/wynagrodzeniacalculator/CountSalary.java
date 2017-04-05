package com.example.robertkaczmarek.wynagrodzeniacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CountSalary extends AppCompatActivity {

   public static final String ZUS_RAZEM = "zusRazem";
    public static final String PIT = "pitAA";
    public static final String ZDR = "zdrA";
    public static final String ZUS_PRACODAWCA = "zusPracddawca1";
    public static final String WYNAGRODZENIE = "wynagrodzenie";
    public static final String KOSZTY = "koszty1";
    public static final String INPUT_SALARY = "inputSalary";
    public static final String PRECENT = "precent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_salary);

        Intent takeSalary = getIntent();
        String zusRazem = takeSalary.getStringExtra(ZUS_RAZEM);
        String pitAA = takeSalary.getStringExtra(PIT);
        String zdrA = takeSalary.getStringExtra(ZDR);
        String wynagrodzenie = takeSalary.getStringExtra(WYNAGRODZENIE);
        String zusPracodawca1 = takeSalary.getStringExtra(ZUS_PRACODAWCA);
        String koszty1 = takeSalary.getStringExtra(KOSZTY);
        String salary1 = takeSalary.getStringExtra(INPUT_SALARY);
        String precent = takeSalary.getStringExtra(PRECENT);

        TextView sal = (TextView)findViewById(R.id.takeSal);
        sal.setText(salary1 +" zł");
        TextView zus = (TextView) findViewById(R.id.countZus);
        zus.setText(zusRazem+" zł");
        TextView pit = (TextView) findViewById(R.id.countPit);
        pit.setText(pitAA+" zł");
        TextView zdrowo = (TextView) findViewById(R.id.countZdr);
        zdrowo.setText(zdrA+" zł");
        TextView netto = (TextView) findViewById(R.id.countNetto);
        netto.setText(wynagrodzenie+" zł");
        TextView zusP = (TextView)findViewById(R.id.countpracZUS);
        zusP.setText(zusPracodawca1+" zł");

        TextView koszty = (TextView)findViewById(R.id.countkoszty);
        koszty.setText(koszty1+" zł");

        TextView procent = (TextView)findViewById(R.id.precent);
        procent.setText(precent+ " %");
    }
}

package com.example.robertkaczmarek.wynagrodzeniacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SalaryActivity extends AppCompatActivity {

  //  private Double freeA;
    private Double freeB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);

    }

    public void Clear(View view) {
        EditText inputSalary = (EditText) findViewById(R.id.heightSalary);
        inputSalary.setText("                       ");
        TextView zus = (TextView) findViewById(R.id.countZus);
        zus.setText("                       ");
        TextView pit = (TextView) findViewById(R.id.countPit);
        pit.setText("                       ");
        TextView zdrowo = (TextView) findViewById(R.id.countZdr);
        zdrowo.setText("                       ");
        TextView netto = (TextView) findViewById(R.id.countNetto);
        netto.setText("                       ");


    }

    public void Count(View view) {
        EditText inputSalary = (EditText) findViewById(R.id.heightSalary);
        String inSalary = inputSalary.getText().toString();
        Double in = Double.parseDouble(inSalary);
        // Double freeA = 111.25;
        // Double freeB = 139.06;
        Double freeTax = 46.34;
        Double zusE = in / 100 * 9.76;
        Double zusR = in / 100 * 1.5;
        Double zusCh = in / 100 * 2.45;
        Double zusa = zusCh + zusE + zusR;
        Double zdr = (in - zusa) / 100 * 9;
        Double zdrOdliczPit = (in - zusa) / 100 * 7.75;
        String zdrA = String.format("%.2f", zdr);


        Double tocountPit = in - zusa - freeB;
        String zusRazem = String.format("%.2f", zusa);

        Double pitA = tocountPit / 100 * 18 - zdrOdliczPit - freeTax;
        String pitAA = String.format("%.2f", pitA);

        Double wynN = in - zusa - zdr - pitA;
        String wynagrodzenie = String.format("%.2f", wynN);

        TextView zus = (TextView) findViewById(R.id.countZus);
        zus.setText(zusRazem);
        TextView pit = (TextView) findViewById(R.id.countPit);
        pit.setText(pitAA);
        TextView zdrowo = (TextView) findViewById(R.id.countZdr);
        zdrowo.setText(zdrA);
        TextView netto = (TextView) findViewById(R.id.countNetto);
        netto.setText(wynagrodzenie);


    }

    public void onRadio(View view) {
        RadioGroup grup = (RadioGroup) findViewById(R.id.grup);
        int id = grup.getCheckedRadioButtonId();

        switch (id) {
            case R.id.btnA:
                freeB = 111.25;
                break;

            case R.id.btnB:
                freeB = 139.06;
                break;
            default:
                break;


        }


    }
}
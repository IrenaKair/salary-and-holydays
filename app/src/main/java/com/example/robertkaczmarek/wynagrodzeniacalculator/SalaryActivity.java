package com.example.robertkaczmarek.wynagrodzeniacalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class SalaryActivity extends Activity implements View.OnClickListener {
    String inSalary;
    //  private Double freeA;
    public Double freeB;
    Double freeTax;
    boolean checked = true;
    boolean checked1 = true;
     /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
  //  private GoogleApiClient client;
        int idA;
    int id;
     public Double zusa;
    public Double koszty;
    public  double zusPracodawca;
    Double in;
    RadioGroup grup;
    RadioGroup group2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);

        TextView infSalary = (TextView) findViewById(R.id.textinfS);

        infSalary.setOnClickListener(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
      //  client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void Clear(View view) {
        EditText inputSalary = (EditText) findViewById(R.id.heightSalary);
        inputSalary.setText("");
        inputSalary = (EditText) findViewById(R.id.heightSalary);
        inSalary = inputSalary.getText().toString();
        grup = (RadioGroup) findViewById(R.id.grup);
        group2 = (RadioGroup) findViewById(R.id.group2);
        grup.clearCheck();
        group2.clearCheck();
        checked = false;
        checked1 = false;


    }

    public void Count(View view) {
        EditText inputSalary;

        if( inSalary!=null&& checked==true&& checked1==true) {
             inputSalary = (EditText) findViewById(R.id.heightSalary);
            inSalary = inputSalary.getText().toString();
            in = Double.parseDouble(inSalary);


            Double zusE = in / 100 * 9.76;
            double zusE1 = Math.round(zusE * 100.0) / 100.0;

            Double zusR = in / 100 * 1.5;
            double zusR1 = Math.round(zusR * 100.0) / 100.0;

            Double zusCh = in / 100 * 2.45;
            double zusCh1 = Math.round(zusCh * 100.0) / 100.0;

            Double zusPE = in / 100 * 9.76;
            double zusPE1 = Math.round(zusPE * 100.0) / 100.0;

            Double zusPR = in / 100 * 6.5;
            double zusPR1 = Math.round(zusPR * 100.0) / 100.0;

            Double zusPW = in / 100 * 1.8;
            double zusPW1 = Math.round(zusPW * 100.0) / 100.0;
            Double zusFP = in / 100 * 2.45;
            double zusFP1 = Math.round(zusFP * 100.0) / 100.0;
            Double zusFGSP = in / 100 * 0.1;
            double zusFGSP1 = Math.round(zusFGSP * 100.0) / 100.0;

            zusPracodawca = zusPE1 + zusPR1 + zusPW1 + zusFP1 + zusFGSP1;
            String zusPracodawca1 = String.format("%.2f ", zusPracodawca);
            koszty = in + zusPracodawca;
            String koszty1 = String.valueOf(koszty);
            zusa = zusE1 + zusR1 + zusCh1;

            Double zdr = (in - zusa) / 100 * 9;
            Double zdrOdliczPit = (in - zusa) / 100 * 7.75;
            String zdrA = String.format("%.2f ", zdr);


            Double tocountPit = in - zusa - freeB;
            String zusRazem = String.format("%.2f ", zusa);


            Double pitA = tocountPit / 100 * 18 - zdrOdliczPit - freeTax;
            int pitA1 = (int) Math.round(pitA);

            String pitAA = String.valueOf(pitA1);

            Double wynN = in - zusa - zdr - pitA;
            String wynagrodzenie = String.format("%.2f ", wynN);

            Double precent = wynN / koszty * 100;

            String precentA1 = String.format("%.2f", precent);

            Intent gocountSalary = new Intent(this, CountSalary.class);
            gocountSalary.putExtra(CountSalary.INPUT_SALARY, inSalary);
            gocountSalary.putExtra(CountSalary.KOSZTY, koszty1);
            gocountSalary.putExtra(CountSalary.PIT, pitAA);
            gocountSalary.putExtra(CountSalary.WYNAGRODZENIE, wynagrodzenie);
            gocountSalary.putExtra(CountSalary.ZDR, zdrA);
            gocountSalary.putExtra(CountSalary.ZUS_PRACODAWCA, zusPracodawca1);
            gocountSalary.putExtra(CountSalary.ZUS_RAZEM, zusRazem);
            gocountSalary.putExtra(CountSalary.PRECENT, precentA1);

            startActivity(gocountSalary);

        }
        else {
            Toast.makeText(this, "nie zaznaczono wszystkich pól",Toast.LENGTH_LONG).show();

             inputSalary = (EditText) findViewById(R.id.heightSalary);
            inSalary = inputSalary.getText().toString();
            grup = (RadioGroup) findViewById(R.id.grup);
            group2 = (RadioGroup) findViewById(R.id.group2);
            grup.clearCheck();
            group2.clearCheck();
            checked = false;
           checked1 = false;
        }
    }

    public void onRadio(View view) {


        RadioGroup grup = (RadioGroup) findViewById(R.id.grup);
        id = grup.getCheckedRadioButtonId();

            switch (id) {
                case R.id.btnA:
                    checked=true;
                    freeB = 111.25;
                    break;
                case R.id.btnB:
                    checked=true;
                    freeB = 139.06;
                    break;
                case R.id.btnC:
                    checked=true;
                    freeB = 00.00;
                    break;
                default:
                    break;

            }
        }

    @Override
    public void onClick(View view) {
        Intent goSalary = new Intent(SalaryActivity.this, InfoSalary.class);
        startActivity(goSalary);
    }



    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client.connect();
      //  AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
      //  AppIndex.AppIndexApi.end(client, getIndexApiAction());
      //  client.disconnect();
    }

    public void reduction(View view) {
        RadioGroup group2 = (RadioGroup)findViewById(R.id.group2);
        idA= group2.getCheckedRadioButtonId();



        switch (idA) {
            case R.id.normal:
                checked1=true;
                freeTax = 46.33;
                break;
            case R.id.heightA:
                checked1=true;
                freeTax = 0.00;
                break;
            case R.id.reward:
                checked1=true;
                freeTax = 0.00;
                break;
            default:
                break;

        }
    }
}
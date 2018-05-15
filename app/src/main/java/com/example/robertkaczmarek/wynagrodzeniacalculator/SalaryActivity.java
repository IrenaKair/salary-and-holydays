package com.example.robertkaczmarek.wynagrodzeniacalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
    boolean checked;
    boolean checked1;
     /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
  //  private GoogleApiClient client;
        int idA;
    int id;
     public Double zusPracownika;
    public Double wynMinusKoszty;
    public  double zusPracodawca;
    Double in;
    Double kosztyPracodawcy;
    RadioGroup grup;
    RadioGroup group2;
    private int stopaprocentowa;
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
        boolean isError = false;
        inputSalary = (EditText) findViewById(R.id.heightSalary);
        inSalary = inputSalary.getText().toString();
        if(TextUtils.isEmpty(inSalary)){
            inputSalary.setError("Pole nie moźe być puste");
            isError = true;
        }

        if( !isError&& checked==true&& checked1==true) {

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

            Double zusPW = in / 100 * 1.67;
            double zusPW1 = Math.round(zusPW * 100.0) / 100.0;
            Double zusFP;
            if( in<2100){
               zusFP = 0.0;

            }else {
                zusFP = in / 100 * 2.45;
            }
            double zusFP1 = Math.round(zusFP * 100.0) / 100.0;
            Double zusFGSP = in / 100 * 0.1;
            double zusFGSP1 = Math.round(zusFGSP * 100.0) / 100.0;
            zusPracownika = zusE1 + zusR1 + zusCh1;
            zusPracodawca = zusPE1 + zusPR1 + zusPW1 + zusFP1 + zusFGSP1;
            String zusPracodawca1 = String.format("%.2f ", zusPracodawca);



            wynMinusKoszty = in - zusPracownika;

           Double zdr9;

            Double zdr7;


            if ( wynMinusKoszty>= freeB) {
             zdr9 = (in - zusPracownika) / 100 * 9;
                zdr7 = (in - zusPracownika) / 100 * 7.75;

            }
            else{
                zdr7 = 0.0;
                zdr9 = 0.0;
            }
            String zdrA = String.format("%.2f ", zdr9);

            Double zusRazem0 = zusPracownika + zusPracodawca;
            String zusRazem = String.format("%.2f ", zusRazem0);
            Double zaliczka;
            if(wynMinusKoszty>=freeB+freeTax) {
                zaliczka = (wynMinusKoszty-freeB) / 100 * stopaprocentowa - zdr7 - freeTax;
            if ( zaliczka<0){
                zaliczka=0.0;
            }
            }
            else {
                zaliczka = 0.0;
            }
            int pitA1 = (int) Math.round(zaliczka);

            String pitAA = String.valueOf(pitA1);

            Double wynN = in - zusPracownika- zdr9 - pitA1;
            String wynagrodzenie = String.format("%.2f ", wynN);
            kosztyPracodawcy = in+zusPracodawca;
            String koszty1 = String.format("%.2f", kosztyPracodawcy);
            Double precent = wynN / kosztyPracodawcy * 100;

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
        else  {
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
                stopaprocentowa = 18;
                break;
            case R.id.heightA:
                checked1=true;
                freeTax = 0.00;
                stopaprocentowa = 32;
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
package com.example.robertkaczmarek.wynagrodzeniacalculator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterView.OnItemClickListener salaryListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              if (i == 0){
                  Intent salaryIntent = new Intent(MainActivity.this, SalaryActivity.class);
                  startActivity(salaryIntent);


              }
                else if (i ==1){
                  Intent holidayIntent = new Intent(MainActivity.this, HolidayActivity.class);
                  startActivity(holidayIntent);
              }
                else if (i==2){
                  Uri pip = Uri.parse("http://www.pip.gov.pl");
                  Intent sendpip = new Intent(Intent.ACTION_VIEW, pip);
                  startActivity(sendpip);

                  }
                else{
                    Uri zus = Uri.parse("http://www.zus.pl");
                    Intent sendzus = new Intent(Intent.ACTION_VIEW, zus);
                    startActivity(sendzus);
                }

              }


        };

        ListView list = (ListView)findViewById(R.id.list);
        list.setOnItemClickListener(salaryListener);



    }


    public void goSalary(View view) {
        Intent goSalalaryIntent = new Intent(MainActivity.this, SalaryActivity.class);
        startActivity(goSalalaryIntent);
    }

    public void goHoliday(View view) {
        Intent doHalidayIntent = new Intent(MainActivity.this, HolidayActivity.class);
        startActivity(doHalidayIntent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.aaaaa) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

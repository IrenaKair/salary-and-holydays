package com.example.robertkaczmarek.wynagrodzeniacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class InfoSalary extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_salary);

        String htmlAsString = getString(R.string.salary);      // used by WebView
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString); // used by TextView

        // set the html content on a TextView
        TextView textView = (TextView) findViewById(R.id.textinf);
        textView.setText(htmlAsSpanned);
    }
}

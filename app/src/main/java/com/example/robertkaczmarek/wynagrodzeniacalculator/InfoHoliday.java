package com.example.robertkaczmarek.wynagrodzeniacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class InfoHoliday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_holiday);

        String htmlAsString = getString(R.string.holiday);      // used by WebView
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString); // used by TextView

        // set the html content on a TextView
        TextView textView = (TextView) findViewById(R.id.textinfA);
        textView.setText(htmlAsSpanned);

    }
}

package com.example.myuicontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        TextView textView_title = findViewById(R.id.editView_title);
        textView_title.setText(title);

        String password = intent.getStringExtra("password");
        TextView textView_password = findViewById(R.id.editView_password);
        textView_password.setText(password);

        String number = intent.getStringExtra("number");
        TextView textView_number = findViewById(R.id.editView_number);
        textView_number.setText(number);

        String multipleLine = intent.getStringExtra("multipleLine");
        TextView textView_multipleLine = findViewById(R.id.editView_multipleLine);
        textView_multipleLine.setText(multipleLine);

        String checkBoxFilm1 = intent.getStringExtra("checkBoxFilm1");
        TextView editView_checkBoxFilm1 = findViewById(R.id.checkBox_film1);
        editView_checkBoxFilm1.setText(checkBoxFilm1);

        String checkBoxFilm2 = intent.getStringExtra("checkBoxFilm2");
        TextView editView_checkBoxFilm2 = findViewById(R.id.checkBox_film2);
        editView_checkBoxFilm2.setText(checkBoxFilm2);

        String filmsISaw = intent.getStringExtra("filmsISaw");
        TextView textView_filmsISaw = findViewById(R.id.textView_filmsISaw);
        textView_filmsISaw.setText(filmsISaw);

        int seekBar1 = intent.getIntExtra("seekBar1", 0);
        TextView seekBar = findViewById(R.id.seekBar1);
        seekBar.setText(seekBar1 +"");

        int seekBar2 = intent.getIntExtra("seekBar2", 0);
        TextView seekBarDiscrete = findViewById(R.id.seekBar2);
        seekBarDiscrete.setText(seekBar2 +"");

        String ratingBarValue = intent.getStringExtra("ratingBarValue");
        TextView ratingBar = findViewById(R.id.ratingBar1);
        ratingBar.setText(ratingBarValue);

        String switchValue = intent.getStringExtra("switchValue");
        TextView switch_ewoks = findViewById(R.id.switch_ewoks);
        switch_ewoks.setText(switchValue);


        String dateSelected = intent.getStringExtra("calendarSelectedDate");
        TextView calendar_nextPremiere = findViewById(R.id.textView_calendar);
        calendar_nextPremiere.setText(dateSelected);

        String bestFilm = intent.getStringExtra("bestFilm");
        TextView textView_bestFilm = findViewById(R.id.textView_bestFilm);
        textView_bestFilm.setText(bestFilm);



    }

    public void onClickBack(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}
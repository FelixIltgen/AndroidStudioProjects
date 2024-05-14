package com.example.myuicontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, ShowResult.class);
        EditText editText_title = (EditText) findViewById(R.id.editView_title);
        intent.putExtra("title", editText_title.getText().toString());

        EditText editText_password = (EditText) findViewById(R.id.editView_password);
        intent.putExtra("password", editText_password.getText().toString());

        EditText editText_number = (EditText) findViewById(R.id.editView_number);
        intent.putExtra("number", editText_number.getText().toString());

        EditText editText_multipleLine = (EditText) findViewById(R.id.editView_multipleLine);
        intent.putExtra("multipleLine", editText_multipleLine.getText().toString());

        CheckBox checkBox_film1 = (CheckBox) findViewById(R.id.checkBox_film1);
        intent.putExtra("checkBoxFilm1", checkBox_film1.getText().toString()+" ("+checkBox_film1.isChecked()+")");

        CheckBox checkBox_film2 = (CheckBox) findViewById(R.id.checkBox_film2);
        intent.putExtra("checkBoxFilm2", checkBox_film2.getText().toString()+" ("+checkBox_film2.isChecked()+")");

        // get selected radio button from radioGroup
        RadioGroup radioGroup_filmsISaw = (RadioGroup) findViewById(R.id.radioGroup_filmsISaw);
        int selectedId = radioGroup_filmsISaw.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        RadioButton radioButton_selected = (RadioButton) findViewById(selectedId);
        intent.putExtra("filmsISaw", radioButton_selected.getText().toString());

        SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        intent.putExtra("seekBar1", seekBar1.getProgress());

        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        intent.putExtra("seekBar2", seekBar2.getProgress());

        RatingBar ratingBar1 = (RatingBar) findViewById(R.id.ratingBar1);
        intent.putExtra("ratingBarValue", ratingBar1.getRating()+"");

        Switch switch1 = (Switch) findViewById(R.id.switch_ewoks);
        intent.putExtra("switchValue", switch1.isChecked()+"");


        CalendarView calendar = (CalendarView) findViewById(R.id.calendar_nextPremiere);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String selectedDate = sdf.format(new Date(calendar.getDate()));
        intent.putExtra("calendarSelectedDate", selectedDate);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner_bestFilm);
        intent.putExtra("bestFilm", mySpinner.getSelectedItem().toString());

        //startActivity(intent);
        startActivityForResult(intent,0 );
    }

}
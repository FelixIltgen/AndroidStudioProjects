package com.example.mylayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Button to call the activity: ActivityHorizontalLinearLayout
        Button bt_horizontalLinearLayout= (Button) findViewById(R.id.button_HorizontalLinearLayout);
        bt_horizontalLinearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ActivityHorizontalLinearLayout.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button bt_verticalLinearLayout= (Button) findViewById(R.id.button_VerticalLinearLayout);
        bt_verticalLinearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ActivityVerticalLinearLayout.class);
                startActivityForResult(myIntent, 0);
            }
        });
        Button bt_relativeLayout= (Button) findViewById(R.id.button_relativeLayout);
        bt_relativeLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ActivityRelativeLayout.class);
                startActivityForResult(myIntent, 0);
            }
        });
        Button btn_tableLayout= (Button) findViewById(R.id.button_tableLayout);
        btn_tableLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), TableLayout.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
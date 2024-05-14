package com.example.mylayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TableLayout extends Activity {

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);

        Button bt_home = (Button) findViewById(R.id.button_home);
        bt_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });
    }
}
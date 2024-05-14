package com.example.myintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button_startBrowser);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.hs-offenburg.de"));
                startActivity(i);
            }
        });

        b2=(Button)findViewById(R.id.button_startPhone);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("tel:07812050"));
                startActivity(i);
            }
        });

        b3=(Button)findViewById(R.id.button_startCamera);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
            }
        });
    }
}
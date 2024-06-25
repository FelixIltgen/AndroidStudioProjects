package com.example.mytouchexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSingleTouch(View view) {
        Intent intent = new Intent(this, SingleTouch.class);
        startActivityForResult(intent,0 );
    }

    public void startMultiTouch(View view) {
        Intent intent = new Intent(this, MultiTouch.class);
        startActivityForResult(intent,0 );
    }

    public void startScaleGesture(View view) {
        Intent intent = new Intent(this, Gesture.class);
        startActivityForResult(intent,0 );
    }

    public void startMotionDetection(View view) {
        Intent intent = new Intent(this, Motion.class);
        startActivityForResult(intent,0 );
    }
}
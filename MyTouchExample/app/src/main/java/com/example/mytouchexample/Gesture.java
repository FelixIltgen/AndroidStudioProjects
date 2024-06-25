package com.example.mytouchexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class Gesture extends AppCompatActivity {

    private ImageView imageView;
    private float scale = 1f;
    private ScaleGestureDetector detector;

    public Gesture() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        imageView=(ImageView)findViewById(R.id.imageView);
        detector = new ScaleGestureDetector(this,new ScaleListener());
    }

    public void onClickBack(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    public boolean onTouchEvent(MotionEvent event) {
//  re-route the Touch Events to the ScaleListener class
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {


        float onScaleBegin = 0;
        float onScaleEnd = 0;

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            imageView.setScaleX(scale);
            imageView.setScaleY(scale);
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {

            Toast.makeText(getApplicationContext(),"Scale Begin" ,Toast.LENGTH_SHORT).show();
            onScaleBegin = scale;

            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {

            Toast.makeText(getApplicationContext(),"Scale Ended",Toast.LENGTH_SHORT).show();
            onScaleEnd = scale;

            if (onScaleEnd > onScaleBegin){
                Toast.makeText(getApplicationContext(),"Scaled Up by a factor of  " + String.valueOf( onScaleEnd / onScaleBegin ), Toast.LENGTH_SHORT  ).show();
            }

            if (onScaleEnd < onScaleBegin){
                Toast.makeText(getApplicationContext(),"Scaled Down by a factor of  " + String.valueOf( onScaleBegin / onScaleEnd ), Toast.LENGTH_SHORT  ).show();
            }

            super.onScaleEnd(detector);
        }
    }
}
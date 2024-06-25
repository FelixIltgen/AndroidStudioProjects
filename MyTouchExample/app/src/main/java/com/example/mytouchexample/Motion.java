package com.example.mytouchexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.view.MotionEvent;

public class Motion extends AppCompatActivity implements View.OnTouchListener  {
    int clickCount;
    private ViewGroup RootLayout;
    private int Position_X;
    private int Position_Y;

    long startTime = 0 ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion);
        RootLayout = (ViewGroup) findViewById(R.id.rootLayout);


        //new image
        Button NewImage = (Button)findViewById(R.id.new_image_button);
        NewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_Image();
            }
        });

        clickCount = 0;

    }

    public void onClickBack(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    private void Add_Image() {
        final ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.yoda);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
        iv.setLayoutParams(layoutParams);
        RootLayout.addView(iv, layoutParams);
        iv.setOnTouchListener(this);
    }

    public boolean onTouch(final View view, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();

        int pointerCount = event.getPointerCount();


        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                Position_X = X - layoutParams.leftMargin;
                Position_Y = Y - layoutParams.topMargin;
                break;

            case MotionEvent.ACTION_UP:
                if (startTime == 0){

                    startTime = System.currentTimeMillis();

                }else {
                    if (System.currentTimeMillis() - startTime < 200) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(Motion.this);
                        builder.setMessage("Are you sure you want to delete this?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                view.setVisibility(View.GONE);

                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                    }

                    startTime = System.currentTimeMillis();

                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;

            case MotionEvent.ACTION_POINTER_UP:
                break;

            case MotionEvent.ACTION_MOVE:

                if (pointerCount == 1){
                    RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    Params.leftMargin = X - Position_X;
                    Params.topMargin = Y - Position_Y;
                    Params.rightMargin = -500;
                    Params.bottomMargin = -500;
                    view.setLayoutParams(Params);
                }

                if (pointerCount == 2){

                    RelativeLayout.LayoutParams layoutParams1 =  (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams1.width = Position_X +(int)event.getX();
                    layoutParams1.height = Position_Y + (int)event.getY();
                    view.setLayoutParams(layoutParams1);
                }

                //Rotation
                if (pointerCount == 3){
                    //Rotate the ImageView
                    view.setRotation(view.getRotation() + 10.0f);
                }

                break;
        }

// Schedules a repaint for the root Layout.
        RootLayout.invalidate();
        return true;
    }

}
package com.example.mynotification;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity  {

    int notifier_counter = 0;
    NotificationManager notificationManager;
    RadioButton radioButtonFirst;
    RadioButton radioButtonSecond;
    RadioButton radioButtonThird;
    RadioGroup radioGroup;
    EditText editText;
    Button btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotification = findViewById(R.id.btnNotification);
        editText = findViewById(R.id.inContent);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonFirst = findViewById(R.id.radioButton1);
        radioButtonSecond = findViewById(R.id.radioButton2);
        radioButtonThird = findViewById(R.id.radioButton3);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // creatting notification groups
            List<NotificationChannelGroup> list = new ArrayList<>();
            list.add(new NotificationChannelGroup(radioButtonFirst.getText().toString(), radioButtonFirst.getText()));
            list.add(new NotificationChannelGroup(radioButtonSecond.getText().toString(), radioButtonSecond.getText()));
            list.add(new NotificationChannelGroup(radioButtonThird.getText().toString(), radioButtonThird.getText()));
            notificationManager.createNotificationChannelGroups(list);

            // creating notification channels
            NotificationChannel notificationChannel = new NotificationChannel("My_Notification_" + radioButtonFirst.getText().toString(), "Notification Channel 1", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setGroup(radioButtonFirst.getText().toString());
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

            NotificationChannel notificationChannel2 = new NotificationChannel("My_Notification_" + radioButtonSecond.getText().toString(), "Notification channel 2", NotificationManager.IMPORTANCE_HIGH );
            notificationChannel2.enableLights(true);
            notificationChannel2.enableVibration(true);
            notificationChannel2.setGroup(radioButtonSecond.getText().toString());
            notificationChannel2.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

            NotificationChannel notificationChannel3 = new NotificationChannel("My_Notification_" + radioButtonThird.getText().toString(), "Notification channel 3", NotificationManager.IMPORTANCE_HIGH );
            notificationChannel3.enableLights(true);
            notificationChannel3.enableVibration(true);
            notificationChannel3.setGroup(radioButtonThird.getText().toString());
            notificationChannel3.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});


            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
                notificationManager.createNotificationChannel(notificationChannel2);
                notificationManager.createNotificationChannel(notificationChannel3);
            }
        }

        radioGroup.check(R.id.radioButton1);

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.getText().toString().length() > 0) {
                    String channel_id = "";
                    String group_id = "";
                    Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
                    PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this, 0, myIntent, 0);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                        group_id = radioButton.getText().toString();
                        channel_id = notificationManager.getNotificationChannel("My_Notification_" + group_id).getId();
                        contentIntent = PendingIntent.getActivity(MainActivity.this, 0, new Intent(MainActivity.this, MainActivity.class).putExtra("importance", notificationManager.getNotificationChannel(channel_id).getImportance()).putExtra("channel_id", channel_id), PendingIntent.FLAG_UPDATE_CURRENT);
                    }

                    NotificationCompat.Builder notification = new NotificationCompat.Builder(MainActivity.this, channel_id)
                            .setContentTitle("My Notification")
                            .setContentText(editText.getText().toString())
                            .setGroup(group_id)
                            .setContentIntent(contentIntent)
                            .setSmallIcon(R.mipmap.ic_launcher);

                    notifier_counter++;
                    notificationManager.notify(notifier_counter, notification.build());
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter something in EditText", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
package com.example.mycontentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(StudentProvider.NAME, ((EditText)findViewById(R.id.editText_name)).getText().toString());
        values.put(StudentProvider.GRADE,((EditText)findViewById(R.id.editText_grade)).getText().toString());
        Uri uri = getContentResolver().insert(StudentProvider.CONTENT_URI, values);
        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();

    }
    public void onClickGetStudents(View view) {
        // Retrieve student records
        String URL = "content://com.example.mycontentprovider.StudentProvider";
        Uri students = Uri.parse(URL);
        Cursor c = getContentResolver().query(students, null, null, null, StudentProvider._ID);
        while (c.moveToNext()){
            Toast.makeText(this,
                    c.getString(c.getColumnIndex(StudentProvider._ID)) +
                            ", " +  c.getString(c.getColumnIndex( StudentProvider.NAME)) +
                            ", " + c.getString(c.getColumnIndex( StudentProvider.GRADE)),
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickUpdateStudents(View view){
        // Get name and grade from the user to update
        ContentValues values = new ContentValues();
        values.put(StudentProvider.NAME, ((EditText)findViewById(R.id.editText_name)).getText().toString());
        values.put(StudentProvider.GRADE,((EditText)findViewById(R.id.editText_grade)).getText().toString());
        String name = values.get(StudentProvider.NAME).toString();

        //get students from the db
        String URL = "content://com.example.mycontentprovider.StudentProvider";
        Uri students = Uri.parse(URL);
        Cursor c = getContentResolver().query(students, null, null, null, StudentProvider._ID);

        while (c.moveToNext()){
            //Check input name and name in db
            if (name.equals(c.getString(c.getColumnIndex(StudentProvider.NAME)))){
                Log.d("Log","Name ist vorhanden");
                //Update the grade
                getContentResolver().update(StudentProvider.CONTENT_URI,values,null,null);
                break;
            } else {
                Log.d("Log","Name ist nicht vorhanden");
            }
        }
    }
    public void onClickDeleteStudents(View view){
        // Get name and grade from the user to delete
        ContentValues values = new ContentValues();
        values.put(StudentProvider.NAME, ((EditText)findViewById(R.id.editText_name)).getText().toString());
        String name = values.get(StudentProvider.NAME).toString();

        //get students from db
        String URL = "content://com.example.mycontentprovider.StudentProvider";
        Uri students = Uri.parse(URL);
        Cursor c = getContentResolver().query(students, null, null, null, StudentProvider._ID);

        while (c.moveToNext()){
            //Check input name and name in db
            if (name.equals(c.getString(c.getColumnIndex(StudentProvider.NAME)))){
                Log.d("Log","Name ist vorhanden");

                //Delete grade
                int x = getContentResolver().delete(StudentProvider.CONTENT_URI,name, null);
                break;
            } else {
                Log.d("Log","Name ist nicht vorhanden");
            }
        }

    }

}
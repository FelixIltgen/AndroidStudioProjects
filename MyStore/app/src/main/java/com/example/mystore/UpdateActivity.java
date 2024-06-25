package com.example.mystore;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    EditText titel_input, author_input, ispn_input, rating_input;
    Button update_button;
    Button delete_button;
    String id, titel, author, ispn, rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        titel_input = findViewById(R.id.titel_input2);
        author_input = findViewById(R.id.author_input2);
        ispn_input = findViewById(R.id.ispn_input2);
        rating_input = findViewById(R.id.rating_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);
        getAndSetIntentData();

        //Set action bar
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(titel);
        }
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.updateData(id,titel,author,ispn,rating);

            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
    }
    void getAndSetIntentData(){
        if (getIntent().hasExtra("id") &&
                getIntent().hasExtra("titel") &&
                getIntent().hasExtra("author") && getIntent().hasExtra("ispn") && getIntent().hasExtra("rating")){
            //Getting intent data
            id = getIntent().getStringExtra("id");
            titel = getIntent().getStringExtra("titel");
            author = getIntent().getStringExtra("author");
            ispn = getIntent().getStringExtra("ispn");
            rating = getIntent().getStringExtra("rating");

            //Setting intent data
            titel_input.setText(titel);
            author_input.setText(author);
            ispn_input.setText(ispn);
            rating_input.setText(rating);
        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titel + " löschen?");
        builder.setMessage("Möchten Sie wirklich " + titel + " löschen?");
        builder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("Nein", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();
    }
}
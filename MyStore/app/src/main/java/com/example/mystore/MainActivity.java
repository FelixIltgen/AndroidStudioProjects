package com.example.mystore;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    MyDatabaseHelper myDB;
    ArrayList<String> book_id, book_titel, book_author, book_ispn, book_rating;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);

            }
        });
        myDB = new MyDatabaseHelper(MainActivity.this);
        book_id = new ArrayList<>();
        book_titel = new ArrayList<>();
        book_author = new ArrayList<>();
        book_ispn = new ArrayList<>();
        book_rating = new ArrayList<>();

        storeDataInArray();
        customAdapter = new CustomAdapter(MainActivity.this,this,book_id,book_titel,book_author,book_ispn,book_rating);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1){
            recreate();
        }
    }

    void storeDataInArray(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();

        }else {
            while (cursor.moveToNext()){
                book_id.add(cursor.getString(0));
                book_titel.add(cursor.getString(1));
                book_author.add(cursor.getString(2));
                book_ispn.add(cursor.getString(3));
                book_rating.add(cursor.getString(4));
            }

        }
    }

}
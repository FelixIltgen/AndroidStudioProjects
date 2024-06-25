package com.example.mystore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivity extends AppCompatActivity {

    EditText titel_input, author_input, ispn_input, rating_input;
    Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        titel_input = findViewById(R.id.titel_input);
        author_input = findViewById(R.id.author_input);
        ispn_input = findViewById(R.id.ispn_input);
        rating_input = findViewById(R.id.rating_input);
        save_button = findViewById(R.id.save_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(titel_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                        ispn_input.getText().toString().trim(),
                        Integer.valueOf(rating_input.getText().toString().trim()));

            }
        });
    }
}
package com.example.mycontentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Helper class that creates and manages the provider's data repository.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    DatabaseHelper(Context context){
        super(context, StudentProvider.DATABASE_NAME, null, StudentProvider.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentProvider.CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  StudentProvider.STUDENTS_TABLE_NAME);
        onCreate(db);
    }
}
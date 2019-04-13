package com.example.sammy1997.androidcsdcourse.helpers;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.sammy1997.androidcsdcourse.models.Student;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME="CSDStudentData.db" ;
    public static int DATABASE_VERSION=1 ;
    public static String TABLE_NAME = "Students" ;
    public static String[] COLUMNS = new String[]{"ID", "NAME", "DEPT", "EMAIL"};

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHelper(@Nullable Context context, String name, int version) {
        super(context, name, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE" + TABLE_NAME + "{" + COLUMNS[0] + " INTEGER AUTOINCREMENT PRIMARY KEY, " +
                COLUMNS[1] + " TEXT,  " + COLUMNS[2] + " TEXT,  " + COLUMNS[3] + " TEXT }; ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void putElement(Student student){
        ContentValues cv = new ContentValues();
        cv.put(COLUMNS[1], student.getName());
        cv.put(COLUMNS[2], student.getDept());
        cv.put(COLUMNS[3], student.getEmail());

        SQLiteDatabase db =  this.getWritableDatabase() ;
        db.insert(TABLE_NAME,null , cv) ;
    }
    public Cursor getElements(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null) ;
    }
    public Cursor getElementbyname(String name, String dept){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE NAME = ? AND DEPT = ?", new String[]{name, dept}) ;
    }
}

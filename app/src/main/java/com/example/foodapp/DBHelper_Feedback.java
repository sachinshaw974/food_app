package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper_Feedback extends SQLiteOpenHelper {
    public DBHelper_Feedback(Context context) {
        super(context, "feedback.db", null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table feedback(oid TEXT primary key,feedback TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop table if exists feedback");
    }

    public Boolean insertdata(String oid,String feedback)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("oid",oid);
        contentValues.put("feedback",feedback);

        long result=DB.insert("feedback",null,contentValues);
        if (result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public Cursor fetchdata()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from feedback",null);
        return cursor;
    }
}

package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "fooduser.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
    DB.execSQL("create table detail(name TEXT ,uname TEXT primary key,pass TEXT,email TEXT,phone TEXT,city TEXT,addr TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
    DB.execSQL("drop table if exists detail");
    }

    public Boolean insertdata(String name,String uname,String pass,String email,String phone,String city,String addr)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("uname",uname);
        contentValues.put("pass",pass);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("city",city);
        contentValues.put("addr",addr);
        long result=DB.insert("detail",null,contentValues);
        if (result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public Cursor fetchdata()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from detail",null);
        return cursor;
    }
}

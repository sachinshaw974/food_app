package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.Cursor;
import androidx.annotation.Nullable;

public class DBHelper_Order extends SQLiteOpenHelper {
    public DBHelper_Order(Context context) {
        super(context, "foodorder.db", null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL("create table orderdetail(oid TEXT primary key,name TEXT ,phone TEXT ,city TEXT,addr TEXT,product TEXT,price TEXT,qty TEXT,amount TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop table if exists orderdetail");
    }

    public Boolean insertdata(String oid,String name,String phone,String city,String addr,String product,String price,String qty,String amount)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("oid",oid);
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        contentValues.put("city",city);
        contentValues.put("addr",addr);
        contentValues.put("product",product);
        contentValues.put("price",price);
        contentValues.put("qty",qty);
        contentValues.put("amount",amount);
        long result=DB.insert("orderdetail",null,contentValues);
        if (result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public Cursor fetchdata()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from orderdetail",null);
        return cursor;
    }

    public Cursor searchdata(String phone)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from orderdetail WHERE phone="+phone,null);
        return cursor;
    }
}

package com.example.sqliteloginandreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(username TEXT primary key,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long results = MyDb.insert("users",null,contentValues);
        if(results == -1) return false;
        else
            return true;
    }
    //checks if uder exists in db
    public Boolean checkusername(String username){
        SQLiteDatabase MyDb = this.getWritableDatabase();
        Cursor cursor = MyDb.rawQuery("select * from users where username = ?",new String[]{username});
        return cursor.getCount() > 0;
    }
    //check username password
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDb = this.getWritableDatabase();
        Cursor cursor = MyDb.rawQuery("select * from users where username = ? and password= ?",new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}

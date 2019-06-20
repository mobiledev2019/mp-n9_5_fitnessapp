package com.example.fitnesssdemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.fitnesssdemo.model.Water;


/**
 * Created by chien on 11/13/16.
 */

public class DBManagerWater extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="water_list";
    private static final String TABLE_NAME ="water";
    private static final String WATER_ID ="id";
    private static final String WATER_TOTAL ="total";
    private static int VERSION = 1;
    private Context context;



    public DBManagerWater(Context context) {
        super(context, DATABASE_NAME,null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlQuery = "CREATE TABLE "+TABLE_NAME +" (" +
                WATER_ID +" integer primary key, "+
                WATER_TOTAL +" TEXT)";

        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void hello(){
        Toast.makeText(context, "Xin chao", Toast.LENGTH_LONG).show();
    }


    //Add new a water
    public void addWater(Water water){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(WATER_TOTAL, water.getTotal());
        db.insert(TABLE_NAME,null,value);
        db.close();
    }

    public Water getMaxWater(){
        String selectQuery = "SELECT " + "MAX(" + WATER_ID + ")," + WATER_TOTAL + " FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Water water = new Water();
        if (cursor.moveToFirst()) {
            do {
                water.setID(cursor.getInt(0));
                water.setTotal(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return water;
    }
}
package com.example.fitnesssdemo.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.fitnesssdemo.model.Water;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chien on 11/13/16.
 */

public class DBManager extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="water_list";
    private static final String TABLE_NAME ="water";
    private static final String ID ="id";
    private static final String VALUES ="values";

    private Context context;

    public DBManager(Context context) {
        super(context, DATABASE_NAME,null, 1);
        Log.d("DBManager", "DBManager: ");
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = " CREATE TABLE " + TABLE_NAME + " ( " +
                ID + " integer primary key, "+
                VALUES + "TEXT) ";
        db.execSQL(sqlQuery);
        Toast.makeText(context, "Create successfylly", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
        Toast.makeText(context, "Drop successfylly", Toast.LENGTH_SHORT).show();
    }


    //Add new a student
    public void addWater(Water water){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(VALUES, water.getValues());

        //Neu de null thi khi value bang null thi loi

        db.insert(TABLE_NAME,null,value);

        db.close();
    }

    /*
     Getting All Student
      */

    public List<Water> getWater() {
        List<Water> water = new ArrayList<Water>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Water wat = new Water();
                wat.setID(cursor.getInt(0));
                wat.setValues(cursor.getString(1));
                water.add(wat);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return water;
    }
}
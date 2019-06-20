package com.example.fitnesssdemo.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.fitnesssdemo.model.Food;


/**
 * Created by chien on 11/13/16.
 */

public class DBManagerFood extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="food_list";
    private static final String TABLE_NAME ="food";
    private static final String FOOD_ID ="id";
    private static final String FOOD_RICE ="rice";
    private static final String FOOD_BEEF ="beef";
    private static final String FOOD_PORK ="pork";
    private static final String FOOD_FISH ="fish";
    private static final String FOOD_CHICKEN ="chicken";
    private static final String FOOD_VEGETABLE ="vegetable";
    private static final String FOOD_TOTAL ="total";
    private static int VERSION = 1;
    private Context context;



    public DBManagerFood(Context context) {
        super(context, DATABASE_NAME,null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlQuery = "CREATE TABLE "+TABLE_NAME +" (" +
                FOOD_ID +" integer primary key, "+
                FOOD_RICE + " TEXT, "+
                FOOD_BEEF + " TEXT, "+
                FOOD_PORK + " TEXT," +
                FOOD_FISH + " TEXT," +
                FOOD_CHICKEN + " TEXT," +
                FOOD_VEGETABLE + " TEXT," +
                FOOD_TOTAL +" TEXT)";

        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void hello(){
        Toast.makeText(context, "Xin chao", Toast.LENGTH_LONG).show();
    }


    //Add new a water
    public void addFood(Food food){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(FOOD_RICE, food.getRice());
        value.put(FOOD_BEEF, food.getBeef());
        value.put(FOOD_PORK, food.getPork());
        value.put(FOOD_FISH, food.getFish());
        value.put(FOOD_CHICKEN, food.getChicken());
        value.put(FOOD_VEGETABLE, food.getVegetable());
        value.put(FOOD_TOTAL, food.getTotal());
        db.insert(TABLE_NAME,null,value);
        db.close();
    }


    public Food getMaxFood(){
        String selectQuery = "SELECT " + "MAX(" + FOOD_ID + ")," + FOOD_TOTAL + " FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Food food = new Food();
        if (cursor.moveToFirst()) {
            do {
                food.setID(cursor.getInt(0));
                food.setTotal(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return food;
    }


    public Food getMaxFoodAll(){
        String selectQuery = "SELECT " + "MAX(" + FOOD_ID + ")," + FOOD_RICE + "," + FOOD_BEEF + "," + FOOD_PORK + "," + FOOD_FISH + "," + FOOD_CHICKEN + "," + FOOD_VEGETABLE + "," + FOOD_TOTAL + " FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Food food = new Food();
        if (cursor.moveToFirst()) {
            do {
                food.setID(cursor.getInt(0));
                food.setRice(cursor.getString(1));
                food.setBeef(cursor.getString(2));
                food.setPork(cursor.getString(3));
                food.setFish(cursor.getString(4));
                food.setChicken(cursor.getString(5));
                food.setVegetable(cursor.getString(6));
                food.setTotal(cursor.getString(7));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return food;
    }
}

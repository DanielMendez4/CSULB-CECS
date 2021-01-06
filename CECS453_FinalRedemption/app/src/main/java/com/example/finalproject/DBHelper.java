package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ExpenseTracker.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_STREET = "street";
    public static final String CONTACTS_COLUMN_CITY = "place";
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table users " +
                        "(id integer primary key, username text unique, password text,email text)"
        );
        db.execSQL(
                "create table settings " +
                        "(id integer primary key, userid integer, annualIncome text, dailyExpense text,savingGoal text)"
        );
        db.execSQL(
                "create table items " +
                        "(id integer primary key, userid integer, itemname text , price text)"

        );
        db.execSQL(
                "create table itemEntries " +
                        "(id integer primary key, userid integer, itemname text , quantity text, price text, date text )"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }



    public boolean insertUser( String name, String password, String email) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("username", name);
        contentValues.put("password", password);
        contentValues.put("email", email);
        db.insert("users", null, contentValues);
        return true;
    }

    public boolean insertItem(String userid, String name, String price) {

               SQLiteDatabase db = this.getWritableDatabase();
               ContentValues contentValues = new ContentValues();

               contentValues.put("userid",userid);
               contentValues.put("itemname", name);
               contentValues.put("price", Integer.valueOf(price));

               db.insert("items", null, contentValues);
               return true;
    }


    public long insertItemPurchase(String userid, String name, String quantity, String price,String date) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("userid",userid);
        contentValues.put("itemname", name);
        contentValues.put("quantity", quantity);
        contentValues.put("price", price);
        contentValues.put("date",date);


        return db.insert("itemEntries", null, contentValues);
    }

    public boolean updateItem( String name, String price) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
       //These Fields should be your String values of actual column names
        cv.put("price",price);

        db.update("items",cv,"itemname=?",new String[] { name }) ;
        return true;
    }
    public boolean updateByQuantityName( String date, String quantity,String name) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //These Fields should be your String values of actual column names
        cv.put("quantity",quantity);

        db.update("itemEntries",cv,"date=?",new String[] { date }) ;
        return true;
    }


    public int updateQuantityByDate( String name, String quantity,String date) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //These Fields should be your String values of actual column names
        cv.put("quantity",quantity);


        return db.update("itemEntries",cv,"date=? AND itemname=?",new String[] { date,name }) ;
    }

    public boolean updateQuantityPrice( String name, String price) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //These Fields should be your String values of actual column names
        cv.put("price",price);

        db.update("itemEntries",cv,"itemname=?",new String[] { name }) ;
        return true;
    }

    public boolean deleteItem(String name) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("items",
                "itemname = ? ",
                new String[] { name } );

        return true;
    }


    public boolean insertSetting(String userid, String annualIncome, String dailyExpense, String saveGoal) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        db.delete("settings",
                "id = ? ",
                new String[] { Integer.toString(Integer.valueOf(userid)) });

        contentValues.put("userid",userid);
        contentValues.put("annualIncome", annualIncome);
        contentValues.put("dailyExpense", dailyExpense);
        contentValues.put("savingGoal", saveGoal);
        db.insert("settings", null, contentValues);
        return true;
    }
    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public HashMap<String,String> getAllUsers() {
        HashMap<String,String> users = new HashMap<>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from users", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            users.put(res.getString(1),res.getString(2));
            res.moveToNext();
        }
        return users;
    }

    public HashMap<String,String> getAllUserID() {
        HashMap<String,String> users = new HashMap<>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from users", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            users.put(res.getString(1),res.getString(0));
            res.moveToNext();
        }
        return users;
    }


    public HashMap<String,String> getAllItems() {
        HashMap<String,String> items = new HashMap<>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from items", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
           items.put(res.getString(1),res.getString(2));
            res.moveToNext();
        }
        return items;
    }

    public ArrayList<String> getItemsAsList(String id) {
        ArrayList<String> items = new ArrayList<>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from items", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            if(id.equals( res.getString(1)))
                items.add(res.getString(2) + " " +res.getString(3) + " userid " + res.getString(1));
            res.moveToNext();
        }
        return items;
    }

/*        "create table itemEntries " +
                "(id integer primary key, userid integer, itemname integer, quantity integer , price text)"
    */
    public ArrayList<String> getItemPurchaseList(String id) {
        ArrayList<String> items = new ArrayList<>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from itemEntries", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            if(id.equals( res.getString(1)))  items.add(res.getString(2) + " quantity " +res.getString(3) + " price " +res.getString(4) + " date " + res.getString(5));
            res.moveToNext();
        }
        return items;
    }

    public ArrayList<String> getUserSettings(String id) {
        ArrayList<String> items = new ArrayList<>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from settings", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            if(id.equals(res.getString(1))) break;
            res.moveToNext();
        }
        items.add(res.getString(2));
        items.add(res.getString(3));
        items.add(res.getString(4));
        return items;
    }

    public int getQuantity(String name,String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from itemEntries", null );
        res.moveToFirst();
        int total = 0;
        while(res.isAfterLast() == false){
            if(name.equals(res.getString(2)) && id.equals(res.getString(1))) total += res.getInt(3);
            res.moveToNext();
        }
        return total;

    }

    public void deleteQuantity(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from itemEntries", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            if (name.equals(res.getString(2))) break;
            res.moveToNext();
        }

    }
        public void deleteQuant(String name,String id, String price, String date, String quantity)
        {

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM itemEntries WHERE itemname='"+name+"' and userid='"+id+"' and quantity='"+quantity+"' and price='"+price+"' and date='"+date +"'");
        }


}
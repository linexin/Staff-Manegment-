package com.linex.google.assignment.Databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.linex.google.assignment.User.User;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    private static final String DB_NAME= "staff_db";
    private static final  int DB_VERSION = 1;
    public static final String TABLE_NAME = "staff_employee";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String DOB_COL = "dob";
    private static final String MOBILE_COL = "mobile";
    private static final String ADDRESS_COL = "address";
    public static final String EMAIL_COL = "email";
    public static final String PASSWORD_COL ="password";


public  DBHandler(Context context){
    super(context, DB_NAME, null, DB_VERSION  );
}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    String query = "CREATE TABLE " + TABLE_NAME + " ("
            + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_COL + " TEXT, "
            + DOB_COL + " TEXT, "
            + MOBILE_COL + " TEXT, "
            + ADDRESS_COL + " TEXT, "
            + EMAIL_COL + " TEXT, "
            + PASSWORD_COL + " TEXT)";

    sqLiteDatabase.execSQL(query);

    }

    public void addNewUser(String name, String dob, String mobile, String address, String email, String password){
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(DOB_COL, dob);
        values.put(MOBILE_COL, mobile);
        values.put(ADDRESS_COL, address);
        values.put(EMAIL_COL, email);
        values.put(PASSWORD_COL,  password);

        sqLiteDatabase.insert(TABLE_NAME, null, values);
        sqLiteDatabase.close();
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(sqLiteDatabase);
    }


    public ArrayList<User> usersData(){
    sqLiteDatabase = this.getReadableDatabase();
    Cursor cursor = sqLiteDatabase.rawQuery(" SELECT * FROM " + TABLE_NAME, null);
    ArrayList<User> usersDataArrayList = new ArrayList<>();

    if(cursor.moveToFirst()){
        do{
            usersDataArrayList.add(new User(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)));

        }while (cursor.moveToNext());
        cursor.close();
        return usersDataArrayList;
    }
        return usersDataArrayList;
    }





}

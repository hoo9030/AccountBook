package com.example.sqlitetest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	
	public DBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table AccountBook(_id INTEGER PRIMARY KEY AUTOINCREMENT, date DATE, item TEXT, value NUMBER)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	public String getResult(){
		SQLiteDatabase db = getReadableDatabase();
		
		String result = "";
		
		Cursor cursor = db.rawQuery("SELECT * FROM AccountBook", null);
		
        while (cursor.moveToNext()) {
            result += cursor.getString(0)
                    + " : "
                    + cursor.getString(1)
                    + " | "
                    + cursor.getString(2)
                    + " | "
                    + cursor.getInt(3)
                    + "¿ø\n";
        }

        return result;
		
	}

}

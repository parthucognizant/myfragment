package com.example.parfrag.database;


import com.example.parfrag.database.DbContract.DbEntry;
import com.example.parfrag.util.Constants;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * this class heilps me create a DB and its table
 * @author Parthasarathi Reddy
 *
 */
public class DbHelper extends SQLiteOpenHelper {
	
	public static final String DATABASE_NAME = "DbReader.db";
	public static final int DATABASE_VERSION = 1;
	private static final String TAG = "DbHelper";
	
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_ENTRIES =
	    "CREATE TABLE " + DbEntry.TABLE_NAME + " (" +
	    DbEntry._ID + " INTEGER PRIMARY KEY," +
	    DbEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
	    DbEntry.COLUMN_NAME_TITLE + TEXT_TYPE +
	     // Any other options for the CREATE command
	    " )";

	public DbHelper(Context context) {
		super(context, DATABASE_NAME,null,DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i(TAG, Constants.log_info.onCreate);
		db.execSQL(SQL_CREATE_ENTRIES);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i(TAG, Constants.log_info.onUpgrade);
		
	}
	
	
	
}

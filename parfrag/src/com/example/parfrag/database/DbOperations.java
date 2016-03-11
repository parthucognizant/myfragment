package com.example.parfrag.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.parfrag.database.DbContract.DbEntry;
import com.example.parfrag.util.Constants;

/**
 * This class has all DB operations
 * @author Parthasarathi Reddy
 *
 */

public class DbOperations {
	private static final String TAG = "DbOperations";
	SQLiteDatabase database;
	DbHelper dbHelper;

	public DbOperations(Context context){
		dbHelper = new DbHelper(context);
	}
	/**
	 * create a row in table
	 * @param id
	 * @param title
	 * @author Parthasarathi Reddy
	 */
	public void createRow(String id, String title){
		Log.i(TAG, Constants.log_info.createRow);

		ContentValues values = new ContentValues();
		values.put(DbEntry.COLUMN_NAME_ENTRY_ID, id);
		values.put(DbEntry.COLUMN_NAME_TITLE, title);

		database.insert(DbEntry.TABLE_NAME, null, values);
	}
	/**
	 * 
	 * @return string of a column
	 */
	public String readRow(){
		Log.i(TAG, Constants.log_info.readRow);
		Cursor cursor = database.query(DbEntry.TABLE_NAME, null, null, null, null, null, null);
		cursor.moveToLast();
		int columnIndex = cursor.getColumnIndexOrThrow(DbEntry.COLUMN_NAME_ENTRY_ID);
		int columnIndex1 = cursor.getColumnIndexOrThrow(DbEntry.COLUMN_NAME_TITLE);
		String result = cursor.getString(columnIndex) + cursor.getString(columnIndex1) ;
		return result;
	}
	
	public Cursor readRows(){
		Cursor cursor = database.query(DbEntry.TABLE_NAME, null, null, null, null, null, null);
		return cursor;
	}
	public void updateRow(){
		ContentValues values = new ContentValues();
		values.put(DbEntry.COLUMN_NAME_ENTRY_ID, "title");
		values.put(DbEntry.COLUMN_NAME_TITLE, "subtitle");
		database.update(DbEntry.TABLE_NAME, values, DbEntry.COLUMN_NAME_TITLE + " LIKE ?", new String[] {"Reddy"});
	}
	/**
	 * 
	 */
	public void deleteRow(){
		Log.i(TAG, Constants.log_info.deleteRow);
		database.delete(DbEntry.TABLE_NAME, DbEntry.COLUMN_NAME_TITLE + " LIKE ?", new String[] {"Reddy"});
	}
	/**
	 * 
	 */
	public void openDb(){
		Log.i(TAG, Constants.log_info.openDb);
		database = dbHelper.getWritableDatabase();
	}
	public void closeDb(){
		Log.i(TAG, Constants.log_info.closeDb);
		database.close();
	}

}

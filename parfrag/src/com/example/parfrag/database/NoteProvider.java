package com.example.parfrag.database;

import java.util.HashMap;

import com.example.parfrag.database.DbContract.DbEntry;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class NoteProvider extends ContentProvider {

	 private SQLiteDatabase database;
     static final String PROVIDER_NAME = "com.example.provider.Notes";
     static final String URL = "content://" + PROVIDER_NAME + "/students";
     static final Uri CONTENT_URI = Uri.parse(URL);
     static final UriMatcher uriMatcher;

     static final int STUDENTS = 1;
     static final int STUDENT_ID = 2;
     private static HashMap<String, String> STUDENTS_PROJECTION_MAP;

     static{
             uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
             uriMatcher.addURI(PROVIDER_NAME, "tablename", STUDENTS);
             uriMatcher.addURI(PROVIDER_NAME, "tablename/#", STUDENT_ID);
     }

     @Override
     public int delete(Uri arg0, String arg1, String[] arg2) {
             // TODO Auto-generated method stub
             return 0;
     }

     @Override
     public String getType(Uri uri) {
              switch (uriMatcher.match(uri)){
      /**
      * Get all student records
      */
      case STUDENTS:
      return "vnd.android.cursor.dir/vnd.example.students";
      
      /**
      * Get a particular student
      */
      case STUDENT_ID:
      return "vnd.android.cursor.item/vnd.example.students";
      
      default:
      throw new IllegalArgumentException("Unsupported URI: " + uri);
  }
     }

     @Override
     public Uri insert(Uri uri, ContentValues values) {
             /**
              * Add a new student record
              */
             long rowID = database.insert(DbEntry.TABLE_NAME, "", values);

             /**
              * If record is added successfully
              */

             if (rowID > 0)
             {
                     Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
                     getContext().getContentResolver().notifyChange(_uri, null);
                     return _uri;
             }
             throw new SQLException("Failed to add a record into " + uri);
     }

     @Override
     public boolean onCreate() {
             DbHelper dbHelper = new DbHelper(getContext());
             database = dbHelper.getWritableDatabase();
             return (database == null)? false:true;

     }

     @Override
     public Cursor query(Uri uri, String[] projection, String selection,
                     String[] selectionArgs, String sortOrder) {
             SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
             qb.setTables(DbEntry.TABLE_NAME);

             switch (uriMatcher.match(uri)) {
             case STUDENTS:
                     qb.setProjectionMap(STUDENTS_PROJECTION_MAP);
                     break;

             case STUDENT_ID:
                     qb.appendWhere( DbEntry._ID + "=" + uri.getPathSegments().get(1));
                     break;

             default:
                     throw new IllegalArgumentException("Unknown URI " + uri);
             }

             if (sortOrder == null || sortOrder == ""){
                     /**
                      * By default sort on student names
                      */
                     sortOrder = DbEntry.COLUMN_NAME_TITLE;
             }
             Cursor c = qb.query(database,   projection,        selection, selectionArgs,null, null, sortOrder);

             /**
              * register to watch a content URI for changes
              */
             c.setNotificationUri(getContext().getContentResolver(), uri);
             return c;
     }

     @Override
     public int update(Uri uri, ContentValues values, String selection,
                     String[] selectionArgs) {
             // TODO Auto-generated method stub
             return 0;
     }

}

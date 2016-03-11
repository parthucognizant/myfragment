package com.example.parfrag.database;

import android.provider.BaseColumns;

public class DbContract {
	
	public DbContract(){}
	
	public static abstract class DbEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";

}
}

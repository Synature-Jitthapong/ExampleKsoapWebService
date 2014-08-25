package com.example.ksoap2webservice.database.table;

import android.database.sqlite.SQLiteDatabase;

public class GlobalPropertyTable {
	public static final String TABLE_GLOBAL_PROPERTY = "GlobalProperty";
	public static final String COLUMN_CURRENCY_SYMBOL = "CurrencySymbol";
	public static final String COLUMN_CURRENCY_CODE = "CurrencyCode";
	public static final String COLUMN_CURRENCY_NAME = "CurrencyName";
	public static final String COLUMN_CURRENCY_FORMAT = "CurrencyFormat";
	public static final String COLUMN_DATE_FORMAT = "DateFormat";
	public static final String COLUMN_TIME_FORMAT = "TimeFormat";
	public static final String COLUMN_QTY_FORMAT = "QtyFormat";
	public static final String COLUMN_PREFIX_TEXT_TW = "PrefixTextTW";
	public static final String COLUMN_POSITION_PREFIX = "PositionPrefix";
	
	private String sqlCreate = 
			"CREATE TABLE " + TABLE_GLOBAL_PROPERTY + " ("
			+ COLUMN_CURRENCY_SYMBOL + " TEXT, "
			+ COLUMN_CURRENCY_CODE + " TEXT, "
			+ COLUMN_CURRENCY_NAME + " TEXT, "
			+ COLUMN_CURRENCY_FORMAT + " TEXT, "
			+ COLUMN_DATE_FORMAT + " TEXT, "
			+ COLUMN_TIME_FORMAT + " TEXT, "
			+ COLUMN_QTY_FORMAT + " TEXT, "
			+ COLUMN_PREFIX_TEXT_TW + " TEXT, "
			+ COLUMN_POSITION_PREFIX + " TEXT );";
	
	public void onCreate(SQLiteDatabase db){
		db.execSQL(sqlCreate);
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_GLOBAL_PROPERTY);
		onCreate(db);
	}
}

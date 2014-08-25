package com.example.ksoap2webservice.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 * @author j1tth4
 * 
 */
public class ReportDatabase{

	protected Context mContext;
	private ReportDatabaseHelper mHelper;
	
	public ReportDatabase(Context context){
		mContext = context;
		mHelper = ReportDatabaseHelper.getInstance(context); 
	}
	
	public Context getContext(){
		return mContext;
	}
	
	// open database for write
	public SQLiteDatabase getWritableDatabase(){
		return mHelper.getWritableDatabase();
	}
	
	// open database for read only
	public SQLiteDatabase getReadableDatabase(){
		return mHelper.getReadableDatabase();
	}
	
	public static class ReportDatabaseHelper extends SQLiteOpenHelper {
		
		/**
		 * Database name
		 */
		public static final String DB_NAME = "report.db";
		
		/**
		 * Database version
		 */
		private static final int DB_VERSION = 1;

		/**
		 * SQLiteOpenHelper instance
		 */
		private static ReportDatabaseHelper sHelper;

		/**
		 * @param context
		 * @return SQLiteOpenHelper instance This singleton pattern for only get
		 *         one SQLiteOpenHelper instance for thread save
		 */
		public static synchronized ReportDatabaseHelper getInstance(Context context) {
			if (sHelper == null) {
				sHelper = new ReportDatabaseHelper(context.getApplicationContext());
			}
			return sHelper;
		}

		private ReportDatabaseHelper(Context context) {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			
		}

		@Override
		public void onDowngrade(SQLiteDatabase db, int oldVersion,
				int newVersion) {

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			
		}
	}
}

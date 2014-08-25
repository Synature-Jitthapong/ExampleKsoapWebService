package com.example.ksoap2webservice.database;

import java.util.List;

import com.example.ksoap2webservice.database.model.ShopProperty;
import com.example.ksoap2webservice.database.table.ShopDataTable;

import android.content.ContentValues;
import android.content.Context;

/**
 * DAO stand for Data Access Object
 * @author j1tth4
 *
 */
public class ShopPropertyDao extends ReportDatabase{

	public ShopPropertyDao(Context context) {
		super(context);
	}
	
	public void insertShopData(List<ShopProperty> sl){
		// begin transaction
		getWritableDatabase().beginTransaction();
		try{
			// delete all old data
			getWritableDatabase().delete(ShopDataTable.TABLE_SHOP, null, null);
			for(ShopProperty s : sl){
				ContentValues cv = new ContentValues();
				cv.put(ShopDataTable.COLUMN_SHOP_ID, s.getShopID());
				cv.put(ShopDataTable.COLUMN_SHOP_CODE, s.getShopCode());
				cv.put(ShopDataTable.COLUMN_SHOP_NAME, s.getShopName());
				cv.put(ShopDataTable.COLUMN_SHOP_TYPE, s.getShopType());
				cv.put(ShopDataTable.COLUMN_SHOP_GROUP_ID, s.getShopGroupID());
				// insert
				getWritableDatabase().insert(ShopDataTable.TABLE_SHOP, null, cv);
			}
			// if not have error do commit transaction
			getWritableDatabase().setTransactionSuccessful();
		}finally{
			getWritableDatabase().endTransaction();
		}
	}
}

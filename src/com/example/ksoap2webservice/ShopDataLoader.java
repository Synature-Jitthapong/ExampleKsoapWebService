package com.example.ksoap2webservice;

import org.ksoap2.serialization.PropertyInfo;

import com.example.ksoap2webservice.database.GlobalPropertyDao;
import com.example.ksoap2webservice.database.ShopPropertyDao;
import com.example.ksoap2webservice.database.model.ShopData;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import android.content.Context;

public class ShopDataLoader extends Ksoap2WebService{

	public static final String LOAD_SHOP_DATA_METHOD = "WsDashBoard_LoadShopData";
	
	public static final int TIME_OUT = 10 * 1000;

	public ShopDataLoader(Context c, String deviceCode) {
		super(c, LOAD_SHOP_DATA_METHOD, TIME_OUT);
		mProperty = new PropertyInfo();
		mProperty.setName("szDeviceCode");
		mProperty.setValue(deviceCode);
		mProperty.setType(String.class);
		mSoapRequest.addProperty(mProperty);
	}

	@Override
	protected void onPostExecute(String result) {
		Gson gson = new Gson();
		try {
			ShopData sd = (ShopData) gson.fromJson(result, ShopData.class);
			
			// insert shop data into database
			ShopPropertyDao sp = new ShopPropertyDao(mContext);
			sp.insertShopData(sd.getShopProperty());
			
			// insert global property into database
			GlobalPropertyDao gp = new GlobalPropertyDao(mContext);
			gp.insertGlobalPropertyData(sd.getGlobalProperty());
			
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onPreExecute() {
	}

}

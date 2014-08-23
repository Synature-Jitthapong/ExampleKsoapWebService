package com.example.ksoap2webservicesample;

import org.ksoap2.serialization.PropertyInfo;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import android.content.Context;

public class MyService extends Ksoap2WebService{

	public static final String NAME_SPACE = "http://tempuri.org/";
	public static final String LOAD_SHOP_DATA_METHOD = "WsDashBoard_LoadShopData";
	
	public static final int TIME_OUT = 10 * 1000;

	public MyService(Context c, String deviceCode) {
		super(c, NAME_SPACE, LOAD_SHOP_DATA_METHOD, TIME_OUT);
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
			
			
			
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onPreExecute() {
	}

}

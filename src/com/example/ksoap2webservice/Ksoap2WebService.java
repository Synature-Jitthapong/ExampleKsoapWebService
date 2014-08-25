package com.example.ksoap2webservice;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

public abstract class Ksoap2WebService extends AsyncTask<String, String, String> {

	public static final String NAME_SPACE = "http://tempuri.org/";
	protected SoapObject mSoapRequest;
	protected int mTimeOut = 30 * 1000;
	protected String mWebMethod;
	protected Context mContext;
	protected PropertyInfo mProperty;

	public Ksoap2WebService(Context c, String method, int timeOut) {
		mContext = c;
		mWebMethod = method;
		mTimeOut = timeOut;
		mSoapRequest = new SoapObject(NAME_SPACE, mWebMethod);
	}

	@Override
	protected String doInBackground(String... uri) {
		String result = "";
		String url = uri[0];

		System.setProperty("http.keepAlive", "false");
		ConnectivityManager connMgr = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(mSoapRequest);
			String soapAction = NAME_SPACE + mWebMethod;
			HttpTransportSE androidHttpTransport = new HttpTransportSE(url,
					mTimeOut);
			androidHttpTransport.debug = true;
			try {
				androidHttpTransport.call(soapAction, envelope);
				if (envelope.bodyIn instanceof SoapObject) {
					SoapObject soapResult = (SoapObject) envelope.bodyIn;
					if (soapResult != null) {
						result = soapResult.getProperty(0).toString();
					} else {
						result = "No result!";
					}
				} else if (envelope.bodyIn instanceof SoapFault) {
					SoapFault soapFault = (SoapFault) envelope.bodyIn;
					result = soapFault.getMessage();
				}
			} catch (IOException e) {
				result = "Connection problems! Please try again.";
			} catch (XmlPullParserException e) {
				result = e.getMessage();
			}
		} else {
			result = "Cannot connect to network!";
		}
		return result;
	}
}

package com.example.ksoap2webservice.database.model;

public class GlobalProperty {
	private String CurrencySymbol;
    private String CurrencyCode;
    private String CurrencyName;
    private String CurrencyFormat;
    private String DateFormat;
    private String TimeFormat;
    private String QtyFormat;
    private String PrefixTextTW;
    private int PositionPrefix;
	public String getCurrencySymbol() {
		return CurrencySymbol;
	}
	public String getCurrencyCode() {
		return CurrencyCode;
	}
	public String getCurrencyName() {
		return CurrencyName;
	}
	public String getCurrencyFormat() {
		return CurrencyFormat;
	}
	public String getDateFormat() {
		return DateFormat;
	}
	public String getTimeFormat() {
		return TimeFormat;
	}
	public String getQtyFormat() {
		return QtyFormat;
	}
	public String getPrefixTextTW() {
		return PrefixTextTW;
	}
	public int getPositionPrefix() {
		return PositionPrefix;
	}
}

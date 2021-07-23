package com.dashboard.mini.cookies;

public class CookieUserID {
	private String CookieID;
	private boolean cookieDel;
	
	public  String getCookieID() {
		return CookieID;
	}
	public void setCookieID(String CookieID) {
		this.CookieID = CookieID;
	}
	
	public boolean isCookieDel() {
		return cookieDel;
	}
	
	public void setCookieDel(boolean cookieDel) {
		this.cookieDel = cookieDel;
	}

}

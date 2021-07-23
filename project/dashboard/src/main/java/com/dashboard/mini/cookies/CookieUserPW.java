package com.dashboard.mini.cookies;

public class CookieUserPW {
	private String CookiePW;
	private boolean cookieDel;
	
	public  String getCookiePW() {
		return CookiePW;
	}
	public void setCookiePW(String CookiePW) {
		this.CookiePW = CookiePW;
	}
	
	public boolean isCookieDel() {
		return cookieDel;
	}
	
	public void setCookieDel(boolean cookieDel) {
		this.cookieDel = cookieDel;
	}

}

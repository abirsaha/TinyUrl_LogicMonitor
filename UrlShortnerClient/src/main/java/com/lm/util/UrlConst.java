package com.lm.util;

public interface UrlConst {
	
	String FORM_EXPAND_TXT = "expandTxt";
	String FORM_TINY_TXT = "tinyTxt";
	
	String PG_NM = "index.jsp";
	
	String FRM_SHOW_TINYURL_1 = "tinyUrlKey_1";
	String FRM_SHOW_LONGURL_1 = "longUrlKey_1";
	String FRM_SHOW_TINYURL_2 = "tinyUrlKey_2";
	String FRM_SHOW_LONGURL_2 = "longUrlKey_2";
	String FRM_ERR_MSG = "err";
	
	String SERVICE_MEDIA_TYP = "application/json";
	String SERVICE_TINY_URL = "http://localhost:8080/UrlShortnerService/rest/LMService/getTinyUrl";
	String SERVICE_EXPANDED_URL = "http://localhost:8080/UrlShortnerService/rest/LMService/getOrgUrl";
	
	String EXP_MSG_1 = "Please Contact the Administrator.Make sure the url given is fully qualified url.";
	String EXP_MSG_2 = "Exception Occured - HTTP Error Code :";
	

}

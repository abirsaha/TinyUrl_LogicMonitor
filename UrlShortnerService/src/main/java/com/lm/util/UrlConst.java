package com.lm.util;

public interface UrlConst {
	
	String URL_PATH_BASE = "/LMService";
	String URL_PATH_MTDH_1 = "/getTinyUrl";
	String URL_PATH_MTDH_2 = "/getOrgUrl";
	
	
	
	
	int max = 122;
    int min = 48;
    int range = (max - min) + 1;
    String base_char = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    String base_url = "http://tinyurl.com/";
    
    String SERVICE_MEDIA_TYP = "application/json";
	String SERVICE_TINY_URL = "http://localhost:8080/UrlShortnerService/rest/LMService/getTinyUrl";
	String SERVICE_EXPANDED_URL = "http://localhost:8080/UrlShortnerService/rest/LMService/getOrgUrl";
	
	String EXP_MSG_1 = "Please Contact to Administrator";
	String EXP_MSG_2 = "Exception Occured - HTTP Error Code :";
	

}

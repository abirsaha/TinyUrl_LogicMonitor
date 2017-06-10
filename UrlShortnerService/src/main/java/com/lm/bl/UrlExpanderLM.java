package com.lm.bl;

import java.util.HashMap;
import java.util.Map;

import com.lm.exception.UrlException;
import com.lm.pojo.UrlLM;
import com.lm.util.UrlConst;

public class UrlExpanderLM {

	LMUrlServiceHelper lMUrlServiceHelper = new LMUrlServiceHelper();
	public UrlLM getOriginalUrl(UrlLM urlLM) throws UrlException{
		String tinyUrl = urlLM.getTinyUrl();
		System.out.println(tinyUrl);
		 String filteredTinyUrl = tinyUrl.substring(UrlConst.base_url.length());
		 Map<String,String> baseMap= new HashMap<String,String>();
		 try {
			 lMUrlServiceHelper.populateMap(baseMap);
		
	        if(baseMap.containsValue(filteredTinyUrl)){
	            for (Map.Entry<String, String> entry : baseMap.entrySet()) {
	                if(filteredTinyUrl.equals(entry.getValue())){
	                	urlLM.setLongUrl(entry.getKey());
	                	return urlLM;
	                }
	            }
	        }
	        
		 }catch(UrlException e){
				throw e;
			}catch(Exception e){
				throw new UrlException(e.getMessage() + " Class Name:- UrlShortnerLM , Method Name:- getTinyUrl");
			}   
		
		return urlLM;

	}

}

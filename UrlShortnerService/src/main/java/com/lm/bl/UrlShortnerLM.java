package com.lm.bl;


import java.util.HashMap;
import java.util.Map;

import com.lm.exception.UrlException;
import com.lm.pojo.UrlLM;
import com.lm.util.UrlConst;

public class UrlShortnerLM {

	LMUrlServiceHelper lMUrlServiceHelper = new LMUrlServiceHelper();
	public UrlLM getTinyUrl(UrlLM urlLM) throws UrlException{
		
		String longUrl = urlLM.getLongUrl();
		String tinyUrl = "";
		Map<String,String> baseMap= new HashMap<String,String>();
		try{ 
			baseMap = lMUrlServiceHelper.populateMap(baseMap);
		String filteredUrl =  lMUrlServiceHelper.pruneUrl(longUrl,baseMap);
         if(lMUrlServiceHelper.chkUrlExist(filteredUrl,baseMap)){
        	 tinyUrl = baseMap.get(filteredUrl);
         }else{
    
          do{
	         tinyUrl = lMUrlServiceHelper.genRandom();
	      }while(baseMap!=null && baseMap.containsValue(tinyUrl));
	      
	      baseMap.put(filteredUrl,tinyUrl);
	      lMUrlServiceHelper.storeMapInFile(filteredUrl,tinyUrl);
         }
         urlLM.setTinyUrl(UrlConst.base_url+tinyUrl);
		}catch(UrlException e){
			throw e;
		}catch(Exception e){
			throw new UrlException(e.getMessage() + " Class Name:- UrlShortnerLM , Method Name:- getTinyUrl");
		}
		
		return urlLM;
		
	}
	
	
	

}

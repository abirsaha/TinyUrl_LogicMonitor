package com.lm.service.tests;

import java.io.IOException;
import java.net.URL;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lm.bl.LMUrlServiceHelper;
import com.lm.pojo.UrlLM;
import com.lm.service.UrlServiceLM;

import junit.framework.TestCase;

public class UrlServiceLMTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	public void test() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		UrlServiceLM urlServiceLM = new UrlServiceLM();
		LMUrlServiceHelper lmHelper = new LMUrlServiceHelper();
		String longUrl = "http://www.google.com";
		
		URL url = new URL(longUrl);
        String protocol = url.getProtocol() + "://";
        char endChar = '/';
        String chk_url = longUrl.substring(protocol.length());
        if(endChar == chk_url.charAt(chk_url.length()-1)){
          chk_url = chk_url.substring(0,chk_url.length()-1);
        }
        
        
		UrlLM urlLM = new UrlLM();
		urlLM.setErrMsg(null);
		urlLM.setTinyUrl(null);
		urlLM.setLongUrl(longUrl);
		
		String jsonUrlString = mapper.writeValueAsString(urlLM);
		
		String responseTinyUrl = urlServiceLM.getTinyUrl(jsonUrlString);
		
		UrlLM retTinyUrl = new UrlLM();
		retTinyUrl = mapper.readValue(responseTinyUrl, UrlLM.class);
		String responseLongUrl = urlServiceLM.getOriginalUrl(responseTinyUrl);
		
		UrlLM retLongUrl = new UrlLM();
		retLongUrl = mapper.readValue(responseLongUrl, UrlLM.class);
		
		assertEquals(retTinyUrl.getTinyUrl(),retLongUrl.getTinyUrl());
		assertEquals(chk_url,retLongUrl.getLongUrl());
	
		
	}
}

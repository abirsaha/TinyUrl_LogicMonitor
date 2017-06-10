package com.lm.client;

import org.codehaus.jackson.map.ObjectMapper;

import com.lm.exception.UrlException;
import com.lm.pojo.UrlLM;
import com.lm.util.UrlConst;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UrlClient {
	
	ObjectMapper mapper = new ObjectMapper();
	
	public UrlLM getTinyUrl(UrlLM urlLM) throws Exception{
		
		UrlLM returlLM = null;
		try{
			
		String jsonInString = mapper.writeValueAsString(urlLM);	
		Client client = Client.create();
		WebResource webResource = client.resource(UrlConst.SERVICE_TINY_URL);
		ClientResponse response = webResource.type(UrlConst.SERVICE_MEDIA_TYP).post(ClientResponse.class, jsonInString);
		
		
		if (response.getStatus() != 200)
        {
            throw new UrlException(UrlConst.EXP_MSG_2 + response.getStatus());
        }
		
		String returnJsonStr = response.getEntity(String.class);
		
		returlLM = mapper.readValue(returnJsonStr, UrlLM.class);
		if(null != returlLM.getErrMsg()){
			throw new Exception(returlLM.getErrMsg());
		}
     
		}catch(Exception e){
			 throw e;
		}
		
		return returlLM;
	}
	
	
public UrlLM getExpandedUrl(UrlLM urlLM) throws Exception{
		
		UrlLM returlLM = null;
		try{
			
		String jsonInString = mapper.writeValueAsString(urlLM);
			
			
		Client client = Client.create();
		WebResource webResource = client.resource(UrlConst.SERVICE_EXPANDED_URL);
		ClientResponse response = webResource.type(UrlConst.SERVICE_MEDIA_TYP).post(ClientResponse.class, jsonInString);
		
		
		if (response.getStatus() != 200)
        {
            throw new UrlException(UrlConst.EXP_MSG_2 + response.getStatus());
        }
		
		String returnJsonStr = response.getEntity(String.class);
		
		returlLM = mapper.readValue(returnJsonStr, UrlLM.class);
		if(null != returlLM.getErrMsg()){
			throw new Exception(returlLM.getErrMsg());
		}
     
		}catch(Exception e){
			 throw e;
		}
		
		return returlLM;
	}

}

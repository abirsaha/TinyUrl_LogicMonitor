package com.lm.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.lm.bl.UrlExpanderLM;
import com.lm.bl.UrlShortnerLM;
import com.lm.pojo.UrlLM;
import com.lm.util.UrlConst;


@Path(UrlConst.URL_PATH_BASE)
public class UrlServiceLM {
	
	UrlShortnerLM urlShortnerLM = new UrlShortnerLM();
	UrlExpanderLM urlExpanderLM = new UrlExpanderLM();
	ObjectMapper mapper = new ObjectMapper();
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(UrlConst.URL_PATH_MTDH_1)
	public String getTinyUrl(String urlLM){
		UrlLM retUrlLm = new UrlLM();
		String retJson = "";
		try{
			UrlLM urlLm = mapper.readValue(urlLM, UrlLM.class);
			retUrlLm = urlShortnerLM.getTinyUrl(urlLm);
			retJson = mapper.writeValueAsString(retUrlLm);
		}catch(Exception e){
			retUrlLm.setErrMsg(e.getMessage());
			try{
				retJson = mapper.writeValueAsString(retUrlLm);
			}catch(Exception exp){
				exp.printStackTrace();
			}
		}
		
		return retJson;
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(UrlConst.URL_PATH_MTDH_2)
	public String getOriginalUrl(String urlLM){
		UrlLM retUrlLm = new UrlLM();
		String retJson = "";
		try{
			UrlLM urlLm = mapper.readValue(urlLM, UrlLM.class);
			retUrlLm = urlExpanderLM.getOriginalUrl(urlLm);
			retJson = mapper.writeValueAsString(retUrlLm);
		}catch(Exception e){
			retUrlLm.setErrMsg(e.getMessage());
			try{
				retJson = mapper.writeValueAsString(retUrlLm);
			}catch(Exception exp){
				exp.printStackTrace();
			}
		}
		
		return retJson;
	}

}

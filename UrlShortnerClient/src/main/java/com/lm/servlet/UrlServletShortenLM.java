package com.lm.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lm.client.UrlClient;
import com.lm.pojo.UrlLM;
import com.lm.util.UrlConst;

public class UrlServletShortenLM extends HttpServlet{
	
	UrlClient urlClient = new UrlClient();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	           throws ServletException, java.io.IOException {

	try{	    

		String expandedUrl = request.getParameter(UrlConst.FORM_EXPAND_TXT);
		
		UrlLM urlLM = new UrlLM();
		urlLM.setLongUrl(expandedUrl);
		
		UrlLM returlLM = urlClient.getTinyUrl(urlLM);
		
		request.setAttribute(UrlConst.FRM_SHOW_TINYURL_1, returlLM.getTinyUrl());
		request.setAttribute(UrlConst.FRM_SHOW_LONGURL_1, returlLM.getLongUrl());
		
			
		}catch (Exception e){
			request.setAttribute(UrlConst.FRM_ERR_MSG, UrlConst.EXP_MSG_1);
			//request.setAttribute(UrlConst.FRM_ERR_MSG, e.getMessage());
		}
		
	RequestDispatcher rd=request.getRequestDispatcher(UrlConst.PG_NM);  
    rd.include(request, response); 
		}

}

package com.lm.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lm.client.UrlClient;
import com.lm.pojo.UrlLM;
import com.lm.util.UrlConst;

public class UrlServletExpandLM extends HttpServlet{
	UrlClient urlClient = new UrlClient();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	           throws ServletException, java.io.IOException {

	try{	    

		String tinyUrl = request.getParameter(UrlConst.FORM_TINY_TXT);
		
		UrlLM urlLM = new UrlLM();
		urlLM.setTinyUrl(tinyUrl);
		
		UrlLM returlLM = urlClient.getExpandedUrl(urlLM);
		
		request.setAttribute(UrlConst.FRM_SHOW_TINYURL_2, returlLM.getTinyUrl());
		request.setAttribute(UrlConst.FRM_SHOW_LONGURL_2, returlLM.getLongUrl());
		
			
		}catch (Exception e){
			request.setAttribute(UrlConst.FRM_ERR_MSG, UrlConst.EXP_MSG_1);
			//request.setAttribute(UrlConst.FRM_ERR_MSG, e.getMessage());
		}
		
	RequestDispatcher rd=request.getRequestDispatcher(UrlConst.PG_NM);  
    rd.include(request, response);
		
		}

}

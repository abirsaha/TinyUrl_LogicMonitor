package com.lm.bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.lm.exception.UrlException;
import com.lm.util.UrlConst;

public class LMUrlServiceHelper {
   
    
    String pruneUrl(String chk_url,Map<String,String> baseMap) throws UrlException{
    	try{
        URL url = new URL(chk_url);
        String protocol = url.getProtocol() + "://";
        char endChar = '/';
        chk_url = chk_url.substring(protocol.length());
        if(endChar == chk_url.charAt(chk_url.length()-1)){
          chk_url = chk_url.substring(0,chk_url.length()-1);
        }
    	}catch(Exception e){
    		throw new UrlException(e.getMessage() + " Class Name:- LMUrlServiceHelper , Method Name:- pruneUrl");
    	}
         return chk_url;
    }
    
     boolean chkUrlExist(String filteredUrl,Map<String,String> baseMap) throws UrlException{
    	try{
        if(baseMap != null && baseMap.containsKey(filteredUrl)){
            return true;
        }
    	}catch(Exception e){
    		throw new UrlException(e.getMessage() + " Class Name:- LMUrlServiceHelper , Method Name:- chkUrlExist");
    	}
        return false;
    }
    
     String genRandom() throws UrlException{
    	 String retStr = "";
    try{
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
            for(int i=0;i<6;i++){
               char rand_chr = UrlConst.base_char.charAt(random.nextInt(UrlConst.base_char.length()-1));
               sb.append(rand_chr); 
            }
            retStr = sb.toString();
    }catch(Exception e){
		throw new UrlException(e.getMessage() + " Class Name:- LMUrlServiceHelper , Method Name:- genRandom");
	}
        return retStr;    
    }
    
     Map<String,String> populateMap(Map<String,String> baseMap) throws UrlException{
    	 
//    	try{ 
//    	File file = new File("map.txt");
//    	Scanner scanner = new Scanner(file);
//
//        while (scanner.hasNextLine()) {
//            String[] columns = scanner.nextLine().split(",");
//            baseMap.put(columns[0], columns[1]);
//        }
//        
//        scanner.close();
//    	}catch(Exception e){
//			throw new UrlException(e.getMessage() + " Class Name:- LMUrlServiceHelper , Method Name:- populateMap");
//		}
//        return baseMap;
    	 
    	 
    	 FileInputStream inputStream=null;
    	 try {
    		   // Getting ClassLoader obj
    		   ClassLoader classLoader = this.getClass().getClassLoader();
    		   // Getting resource(File) from class loader
    		   File configFile=new File(classLoader.getResource("map.txt").getFile());
    		  
    		   inputStream = new FileInputStream(configFile);
    		   BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    		   String line;
    		   while ((line = reader.readLine()) != null) {
    			   String[] columns = line.split(",");
    	            baseMap.put(columns[0], columns[1]);
    		   }
    		 
    		   reader.close();


    		  } catch (Exception e) {

    				throw new UrlException(e.getMessage() + " Class Name:- LMUrlServiceHelper , Method Name:- populateMap");
    		  }
    		  finally {
    		   try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		  }
    	 
    	 return baseMap;

    }
    
     void storeMapInFile(String longUrl,String tinyUrl) throws UrlException{
    	 
    	 PrintWriter out = null;
    	 FileWriter fstream = null;
    	try  
    	{
    		// Getting ClassLoader obj
 		   ClassLoader classLoader = this.getClass().getClassLoader();
 		   // Getting resource(File) from class loader
 		   File configFile=new File(classLoader.getResource("map.txt").getFile());
    		fstream = new FileWriter(configFile,true);
    		out = new PrintWriter(fstream);
    	    out.println(longUrl+","+tinyUrl);
    	
    	}catch(Exception e){
			throw new UrlException(e.getMessage() + " Class Name:- LMUrlServiceHelper , Method Name:- storeMapInFile");
		}
    	finally
    	{
    	   try{
    	    	out.flush();
    	        out.close();
    	        
    	        fstream.close();
    	    }catch(Exception e){
    			throw new UrlException(e.getMessage() + " Class Name:- LMUrlServiceHelper , Method Name:- storeMapInFile");
    	    }
    	}
    }
}

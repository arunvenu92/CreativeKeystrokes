package com.system.puchisoftware;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Search 
{
 
	public static void main(String args[])
	{
		
       try
       {
    	Map<Integer,String> mapUtil = new HashMap<Integer,String>();
    	FileReader filereaderObject = new FileReader(new File("D:\\MYHEC273848D\\Arun\\HTMLReport\\src\\createReport\\create.java"));
		BufferedReader bw = new BufferedReader(filereaderObject);
		String line = null;
		String searchKeyword = "java";
	
		int lineCounter=0;
		while((line = bw.readLine())!= null)
		{
		 	lineCounter++;
		 	if(line.contains(searchKeyword))
		 	{
		 		mapUtil.put(lineCounter,line);
		 	}
		}
		System.out.println("Total line in the document "+ lineCounter);
		
		Set<Integer> setObject = mapUtil.keySet();
		
		if(!setObject.isEmpty())
		{
			for (Integer integer : setObject) 
			{
				System.out.println("String " + searchKeyword + " found in line number "+ integer +" line matching "+ mapUtil.get(integer));
			}
		}
		else
		{
			System.out.println("No Search Keyword found");
		}
		
       }
       catch(Exception e)
       {
    	    //Exception here
       }
	}

	
	
	
	
}

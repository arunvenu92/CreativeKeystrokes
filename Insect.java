package com.system.insectsoftware;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Search 
{
	private static ArrayList<String> recurselistOfpath = new ArrayList<String>();
	public static void main(String args[])
	{
		try
		{
			String filePath = null;
			String searchKeyword = null;
			String fileExtensions = null;
			String extension =null;
			FileReader filereaderObject = null;
			BufferedReader bw = null;
			Map<Integer,String> mapUtil = new HashMap<Integer,String>();
			int lineCounter=0;
	    	
			for (String string : args) 
			{
				System.out.println(string);
			}
			
			if(args.length < 0)
	    	{
	    		System.out.println("Provide all the arguments");
	    	}
	    	else
	    	{
	    		filePath = args[0].split("=")[1];
	    		searchKeyword = args[1].split("=")[1];
	    		fileExtensions = args[2].split("=")[1];
	    	}

			getRecursePath(filePath);
			String[] seperateExtensions = fileExtensions.split("#~");
			for (String sepPath : recurselistOfpath) 
			{

				File fileObject = new File(sepPath);

				if(fileObject.isFile())
				{
					
					try
					{
						extension = fileObject.getAbsoluteFile().getName().substring(fileObject.getAbsoluteFile().getName().lastIndexOf("."),fileObject.getAbsoluteFile().getName().length());
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("No Extension or Invalid extension for the filepath");
						continue;
					}
					catch(StringIndexOutOfBoundsException e)
					{
						System.out.println("No Extension or Invalid extension for the filepath");
						continue;
					}
					for (String string : seperateExtensions) 
					{
						if(extension.equalsIgnoreCase(string))
						{
							filereaderObject = new FileReader(fileObject);
							bw = new BufferedReader(filereaderObject);
							String line = null;
							while((line = bw.readLine())!= null)
							{
								lineCounter++;
								if(line.contains(searchKeyword))
								{
									mapUtil.put(lineCounter,line);
								}
							}
							System.out.println("****************************************************************");
							System.out.println("File Path " + sepPath);
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
							System.out.println("End of search in " + sepPath);
							System.out.println("****************************************************************");
						}
					}
				}

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void getRecursePath(String filePath)
	{
		File fileDirectoryAndFiles = new File(filePath);
		File[] fileArray = fileDirectoryAndFiles.listFiles();
		for (File file2 : fileArray) 
		{
			if(file2.isDirectory())
			{
				getRecursePath(file2.getAbsolutePath());	
			}
			else
			{
				recurselistOfpath.add(file2.getAbsolutePath());
			}
		}
	}



}

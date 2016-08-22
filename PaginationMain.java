package pagination;

import java.io.BufferedReader;
import java.util.Random;
import java.util.Scanner;
public class PaginationMain {

	
	public static void main(String args[])
	{
		
		//double totalResults = Math.
		
		int totalResults = new Random().nextInt(1000);
		int numberOfResults = 10;
		int numberofPages = (int) Math.floor(totalResults / numberOfResults) ;
		
		int fnumberofPages = 0;
		if(totalResults % numberOfResults == 0 )
		{
			fnumberofPages  = numberofPages;
		}
		else if(totalResults % numberOfResults < 10)
		{
			
			fnumberofPages = numberofPages + 1;
		}
			
	    System.out.println("Total Results " + totalResults);
		System.out.println("Total Number of pages to display " + fnumberofPages);
		
		for (int i=1;i<=fnumberofPages;i++) 
		{
			System.out.print(i +" ");
		}
		
		System.out.println("Select the page");
		
		Scanner scannerObject = new Scanner(System.in);
		
		int page = scannerObject.nextInt();
		
		if(page == fnumberofPages && totalResults % numberOfResults != 0 )
		{
			for(int i=totalResults-(totalResults%numberOfResults);i<=totalResults;i++)
			{
				System.out.println(i + " ");
			}
		}
		else
		{
			for(int i= (numberOfResults*(page-1)+1);i<=numberOfResults*page;i++)
			{
				System.out.println(i + " ");
			}
		}
	}

	
}

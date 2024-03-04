package FileInputOutputExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileInputOutputJavaIO {
	
	static Scanner sc=new Scanner(System.in);
	static final String pathname="fileIO.txt";
	
	
	static void writeRecord() 
	{
		FileOutputStream fos=null;
		try 
		{
			fos = new FileOutputStream(new File(pathname));
	        System.out.println("Enter Data To Store");
	        String data=sc.next();
	        byte[] byteData = data.getBytes();
	        fos.write(byteData);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fos.close();
			} 
			catch (IOException e) 
			{
				
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	static void readRecord()
	{
		FileInputStream fis=null;
		try
		{
			fis=new FileInputStream(new File(pathname));
	        int data;
	        while((data = fis.read()) != -1)
	        {
	            System.out.print((char)data);
	        }
	        System.out.println();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				fis.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
	}
	
	
	static int menuList()
	{
		System.out.println("Enter Choice ");
		System.out.println("0.Exit 1.Write 2.Read");
		return sc.nextInt();
	}

	public static void main(String[] args) 
	{
		int choice;
		while((choice=menuList())!=0)
		{
			switch(choice)
			{
				case 1:
					writeRecord();
				break;
				case 2:
					readRecord();
				break;
			}	
		}

	}


}

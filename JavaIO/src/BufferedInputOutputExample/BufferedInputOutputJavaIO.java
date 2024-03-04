package BufferedInputOutputExample;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class BufferedInputOutputJavaIO {
	static Scanner sc=new Scanner(System.in);
	static final String pathname="Buffered.txt";
	
	
	static void writeRecord() throws IOException 
	{
		try(BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(pathname)));)
		{
		//	for(char ch='A';ch<='Z';ch++)
		//		bos.write(ch);
			System.out.println("Enter Data To Store");
	        String data=sc.nextLine();
	        byte[] byteData = data.getBytes();
	        bos.write(byteData);
		
			System.out.println("Data is written inside the file");
		} 
	}
	
	static void readRecord() throws FileNotFoundException, IOException
	{
		try(BufferedInputStream bis=new BufferedInputStream(new FileInputStream(new File(pathname)));)
		{
			int data;
			//Files ==> EOF ==> end of file ==> -1 
			while((data=bis.read())!=-1)
			{
				System.out.print((char)data);
			}
				
		}		
	}
	
	
	static int menuList()
	{
	    System.out.println("Enter Choice ");
	    System.out.println("0.Exit 1.Write 2.Read");
	    String input = sc.nextLine();
	    return Integer.parseInt(input);
	}

	public static void main(String[] args) throws IOException 
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
			  sc.nextLine();
		}

	}

}

package DataInputOutputExample;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DataInputOutputJavaIO {
	
	static Scanner sc=new Scanner(System.in);
	static final String pathname="dataIO.txt";
	
	
	static void writeRecord() throws IOException 
	{
		try(DataOutputStream dos= new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(pathname))));)
		{
			System.out.println("Enter Name");
			dos.writeUTF(sc.next());
			System.out.println("Enter Age");
			dos.writeInt(sc.nextInt());
			System.out.println("Enter Salary");
			dos.writeFloat(sc.nextFloat());
		} 
	}
	
	static void readRecord() throws FileNotFoundException, IOException
	{
		try(DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream(new File(pathname))));)
		{
			String name=dis.readUTF();
			int age=dis.readInt();
			int salary=(int) dis.readFloat();
			System.out.println("Name = "+name+ " Age = "+age+" Salary ="+salary);
			
				
		}		
	}
	
	
	static int menuList()
	{
		System.out.println("Enter Choice ");
		System.out.println("0.Exit 1.Write 2.Read");
		return sc.nextInt();
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
		}

	}


}

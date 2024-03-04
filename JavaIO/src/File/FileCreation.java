package File;

import java.io.File;
import java.io.IOException;

public class FileCreation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String createFile="Text.txt";
		String createFolder1="JAVA";
		File file=new File(createFile);
		File file1=new File(createFolder1);
		
		boolean check=file.createNewFile();
		boolean check1=file1.mkdirs();
		
		System.out.println("Status: "+check);
		System.out.println("Status: "+check1);
		

	}

}

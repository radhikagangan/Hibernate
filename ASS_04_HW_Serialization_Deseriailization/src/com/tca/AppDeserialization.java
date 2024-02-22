package com.tca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;

import com.tca.entities.Student;

public class AppDeserialization {

	public static void main(String[] args) throws Exception 
	{

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try 
		{
			fis = new FileInputStream("resources/student.ser");
			ois = new ObjectInputStream(fis);
			File f = new File("resources/student.csv");
			FileWriter fw = new FileWriter("resources/student.csv");
			if (!f.exists()) {
				System.out.println("File does not exists");
				System.exit(0);
			}
			if (!f.isFile()) {
				System.out.println("Not a file");
				System.exit(0);
			}
			
			Student s =null;
			while((s=(Student) ois.readObject())!=null)
			{
					
				
					fw.append(String.valueOf(s.getRno()));
					fw.append(",");
					fw.append(s.getName());
					fw.append(",");
					fw.append(String.valueOf(s.getPer()));
					fw.append("\n");	
					System.out.println(""+s.getRno());
					System.out.println(""+s.getName());
					System.out.println(""+s.getPer());
				
			}
			
			fw.close();
			
		} catch (Exception e) 
		{
			
			
		} finally 
		{
			fis.close();
			ois.close();
			
		}
	}

}
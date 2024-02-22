package com.tca;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

import com.tca.entities.Student;

public class AppDeserialization {
	public static void main(String[] args) throws Exception
	{
			
	FileInputStream fis=null;
	ObjectInputStream oos=null;
	
	try {
		fis= new FileInputStream("resources/student.ser");
		oos= new ObjectInputStream(fis);
		
		Student s=(Student) oos.readObject();
		System.out.println("Roll no."+ s.getRno());
		System.out.println("Name: "+ s.getName());
		System.out.println("Percentage :"+ s.getPer());
		
		
		}
	catch(Exception e) {
		System.out.println(e);
		
	}
	finally {
		fis.close();
		oos.close();
		
	}
	}
}

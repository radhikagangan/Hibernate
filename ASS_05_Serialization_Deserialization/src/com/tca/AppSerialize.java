package com.tca;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.tca.entities.Student;

// to read binary we require FileInputStream and to write binary in filre we use FileOutputStream
public class AppSerialize {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos=null;
		ObjectOutputStream oos= null;
		
		try 
		{
			fos=new FileOutputStream("resources/student.ser");
			oos=new ObjectOutputStream(fos);
			
			Student ob=new Student();
			
			ob.setRno(101);
			ob.setName("Radhika");
			ob.setPer(88);
			
			oos.writeObject(ob);
			System.out.println("Object has been serializes!!");
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			fos.close();
			oos.close();
			
		}

	}

}

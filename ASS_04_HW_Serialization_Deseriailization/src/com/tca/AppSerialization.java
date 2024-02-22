package com.tca;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;

import com.tca.entities.Student;

// to read binary we require FileInputStream and to write binary in filre we use FileOutputStream
public class AppSerialization{

	public static void main(String[] args) throws Exception{
		FileOutputStream fos=null;
		ObjectOutputStream oos= null;
		FileReader fr=null;
		BufferedReader bf=null;
		
		try 
		{
			fos=new FileOutputStream("resources/student.ser");
			oos=new ObjectOutputStream(fos);
			
			fr=new FileReader("resources/student.csv");
			bf=new BufferedReader(fr);
			
			while(true) {
				String str=bf.readLine();
				if(str==null)
					break;
				
				String token[]=str.split(",");
				
				Student ob=new Student();
				
				ob.setRno(Integer.parseInt(token[0]));
				ob.setName(token[1]);
				ob.setPer(Double.parseDouble(token[2]));
				
				oos.writeObject(ob);
				System.out.println("Object has been serializes!!");
				
				
				}
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			fos.close();
			oos.close();
			fr.close();
			bf.close();
			
		}

	}

}

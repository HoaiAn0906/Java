package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entityChan.DateOfBirth;
import entityChan.Enrolment;
import entityChan.Student;
import util.mapperChan;

public class cau2chan {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String path = "data.json";
		List<Student> students = new ArrayList<Student>();
		students = mapperChan.readFromFile(path);
		for (Student student : students) {
			System.out.println(student);
		}

		FileOutputStream fos = new FileOutputStream(new File("data/dataTest.json"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(students);
		fos.close();
		oos.close();
//		
//		FileInputStream fineIn = new FileInputStream("data/dataTest.json");
//        ObjectInputStream objIn = new ObjectInputStream(fineIn);
//        List<Student> students1 = (List<Student>) objIn.readObject();
//        for (Student student : students1) {
//			System.out.println(student);
//		}
//        fineIn.close();
//        objIn.close();
	}
}

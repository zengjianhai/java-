package ObjectTest;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import PipeStreamTest.Student;

public class ObjectDemo {

	public static void main(String[] args) {
		ObjectDemo od = new ObjectDemo();
		od.read("src/test4");
	}

	public void write(String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Student student1 = new Student("zeng", 20, "ÄÐ");
			Student student2 = new Student("min", 19, "Å®");
			List<Student> students = new ArrayList<Student>();
			students.add(student1);
			students.add(student2);
			oos.writeObject(students);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void read(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Student> students = (List<Student>) ois.readObject();
			for (Student student : students) {
				System.out.println(student);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}

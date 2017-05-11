package io.test1.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

// ���Ϸκ��� Person ��ü�� ������ȭ ���Ѽ� ��������
public class Test6_0511 {

	public static void main(String[] args) {
		File file = new File("C:\\busTest", "serial.dat");

		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Person person = (Person) ois.readObject(); // ������ȭ

			System.out.println(person.getName() + " " + person.getAge());

			// ����� �ڿ� �ݱ�
			ois.close();
		} catch (FileNotFoundException e) { // FileInputStream
			e.printStackTrace();
		} catch (IOException e) { // ObjectInputStream
			e.printStackTrace();
		} catch (ClassNotFoundException e) { // readObject
			e.printStackTrace();
		}

	}

}

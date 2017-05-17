package io.test1.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

// 파일로부터 Person 객체를 역직렬화 시켜서 가져오기
public class Test6_0511 {

	public static void main(String[] args) {
		File file = new File("C:\\busTest", "serial.dat");

		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Person person = (Person) ois.readObject(); // 역직렬화

			System.out.println(person.getName() + " " + person.getAge());

			// 입출력 자원 닫기
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

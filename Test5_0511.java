package io.test1.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 *	[ �޸𸮿� ������ ��ü�� �񿵼Ӽ�(=�Ͻü�)�� ���� ]
 * 
 *  �ڹٿ����� '��ü ����ȭ(Object Serialization)' ����� ������.
 *  ��ü ����ȭ�� �����ϸ� �޸𸮿� ������ �ν��Ͻ� ������
 *  �����̳� ��Ʈ��ũ�� ���ؼ� ���Ӽ��� ������ �� ����.
 *  
 *  <��ü ����ȭ�� ����ϴ� ���>
 *  public class Ŭ������  implements Serializable{}
 *  
 *  <Serializable>
 *   - ���� ��ŷ ����� ������ �뵵�� ����ϴ� ��Ŀ(marker) �������̽�
 *   
 *   <��ü ����ȭ�� ���� I/OŬ����>
 *   
 *    - ObjectInputStream
 *    	: ��ü ����ȭ�� �����͸� ���� �� �����. ������ȭ�� �� �����.
 *    
 *    - ObjectOutputStream
 *   	: �ν��Ͻ��� ��ü ����ȭ�� ����� �� �����.
 *   
 *   <��ü ����ȭ�� Ư¡>
 *   - Sereializable �������̽��� �����.
 *   - �޸𸮿� ������ �ν��Ͻ��� ���������� byte�� ó����.
 *   - byte ������ ó���Ǳ� ������ �ݵ�� ObjectInputStream��
 *     ObjectOutputStream�� ����ؾ� ��.
 *   - ���������� �߻���. ����ȭ �� ��ü�� ��������� �����ϴ�
 *     ��ü������ ���������� ��ü ����ȭ�ȴٴ� �ǹ�.
 *   - ��κ��� API�� ��� ��ü ����ȭ ������ Ŭ��������.(String,ArrayList)
 *   - ��ü ����ȭ���� ���ܽô� ����� transient Ű����� ����ϸ� ��.  
 *       
 * */
// Person ��ü�� ����ȭ ���Ѽ� ���Ϸ� ��������
public class Test5_0511 {

	public static void main(String[] args) {

		Person person = new Person("ȫ�浿",30);
		
		File file = new File("C:\\bustest","serial.dat");
		try {
			// ��½�Ʈ�� �غ�
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(person); // ����ȭ ��Ű�� 
			
			// �ڿ��ݱ� (�⺻������� �ƴ� ����� �ڿ��� �� �ݾƾ� ��)
			oos.close();
		} catch (FileNotFoundException e) { // FileOutputStream
			e.printStackTrace();
		} catch (IOException e) { // ObjectOutputStream
			e.printStackTrace();
		}
	}

}

package io.test1.com;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

// Ű���� �Է°��� ���Ϸ� ����ϱ�
// (�����ٿ� ���ļ� �Է¹ޱ�)
public class Test3_0511 {

	public static void main(String[] args) {
		String id = null;
		String pwd = null;
		String age = null;

		// �Է½�Ʈ�� �غ�
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// ��½�Ʈ�� �غ�
		FileWriter writer = null;
		try {
			writer = new FileWriter("C:\\busTest\\data.txt", true); // true : �߰� , false : ����� 
			
			// �Է¹ޱ�
			System.out.print("���̵� : ");
			id =  reader.readLine();
			
			System.out.print("�н����� : ");
			pwd = reader.readLine();
			
			System.out.print("���� : ");
			age = reader.readLine();
			
			// ���Ϸ� ����ϱ�
			
			// �����ٷ� �ٹٲ�  <"\r\n">
			writer.write(id);
			writer.write("\r\n");
			writer.flush(); // buffer�� ������ ���� ��.
			
			writer.write(pwd);
			writer.write("\r\n");

			writer.write(age);
			writer.write("\r\n");

//			reader.close(); ǥ�� ����� ������ ��Ʈ���� ��������� ���� �ʿ䰡����, ���� ��밡���ϱ⶧����
			writer.close(); // �ڿ��� �ݴ� ������ buffer�� ���� ��. -> �������� ���۵Ǵ� ����
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

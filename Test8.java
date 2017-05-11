package io.test.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// C:\\busTest ������ �̹��� ���������� �����Ͽ� ������ �̸����� ���� �����ϱ�
public class Test8 {

	public static void main(String[] args) {
		
		
		try {
			// �Է� ��Ʈ�� �غ�
			File readFile = new File("C:\\busTest","sg.jpg");
			FileInputStream fStream = new FileInputStream(readFile);
			
			int size = (int) readFile.length(); // ����Ʈ���� ����ũ��
			
			// ��� ��Ʈ�� �غ�
			File writeFile = new File("C:\\busTest","hg.jpg");
			FileOutputStream outputStream = new FileOutputStream(writeFile,false);
			
			byte[] arrByte = new byte[size]; // size ����ŭ byte �迭 ����
			
			
			int count = fStream.read(arrByte); // �Է½�Ʈ�� ����
			
			outputStream.write(arrByte); // ��½�Ʈ�� ����
			
			fStream.close();
			outputStream.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}

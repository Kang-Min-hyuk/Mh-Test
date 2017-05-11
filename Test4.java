package io.test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 *  - Node �迭 
 * 		���� �����͸� ���� ó���ϴ� Ŭ���� �迭
 * 		���� �����Ͷ� -> �ڹ� I/O�� �⺻ ó�� ��������
 * 		byte �Ǵ� char�μ� �������� ���� �����͸� �ǹ�
 * 
 * 		��ǥ������ ���� Ŭ�������� InputStream, OutputStream,
 * 		Reader, Writer Ŭ�������� �ش���
 * 
 * 		Node �迭 Ŭ�������� Ư¡�� ��ȿ������ ����¸��� ����.
 *  - Filter �迭
 * 		Node �迭�� ����ؼ��� ��ȿ�������� ó���Ǳ� ������
 * 		ȿ�������� ó���ϱ� ���ؼ� byte�� char�� ��ȯ��Ű�ų�InputStreamReader)
 * 		�� ���ξ� ó���ϴ� Ŭ�������� ������.
 * 
 * */


public class Test4 {

	
		public static void main(String[] args) {
			System.out.println("�����͸� �Է��ϼ���.");

			InputStream is = System.in;

			InputStreamReader isReader = new InputStreamReader(is);
			BufferedReader bReader = new BufferedReader(isReader);

//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			// ���ڷ��̼� ����
			try {
				String str = bReader.readLine();

				System.out.println("�Է°� : " + str);

				bReader.close(); // ���������� ����� �ڿ��� ������
								 // ����� �ڿ��� ���������� ����.

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}

package io.test.com;

import java.io.IOException;
import java.io.InputStream;

/*
 * �ڹ��� �����(I/O)
 * 
 * <��� ����> 
 * 
 *      [�ҽ�(Source)]  -> [�ڹ� ���ø����̼�]  ->  [������(destination)]
 *                  �Է�(input)			 ���(output)
 * 
 *  �ڹ�  I/O�� ������ �׻� �ڹ� ���ø����̼��� !
 *  
 *  - �ҽ� : ������ �Ǵ� �ڹ� ���ø����̼ǿ��� �����͸� �о���̴� ����� �ǹ�.
 *  		�⺻������ Ű����, ����, ��Ʈ��ũ ���� �ɼ� ����.
 *  
 *  - ������ : ������ �Ǵ� �ڹ� ���ø����̼��� ������ ��� ����� �ǹ���.
 *  		  �⺻������ �����, ����, ��Ʈ��ũ ���� �ɼ� ����.
 *  
 *  - �Է� : �ҽ����� ������ �Ǵ� �ڹ� ���ø����̼����� �����͸� �о���̴� �۾�. 
 *  		�ڹٿ����� �Է� ��Ʈ��(input stream) �̶�� ��.
 *  
 *  - ��� : ������ �Ǵ� �ڹ� ���ø����̼ǿ��� �������� �����͸� ��½�Ű�� �۾�
 *  		�ڹٿ����� ��� ��Ʈ��(output stream) �̶�� ��.
 *  
 * <�ڹ��� I/O ������ ����>
 * 
 *  - byte 
 *  	�ڹ��� �Է� �� ��� �����ͷ� byte ó�� ������.
 *  	�̹��� ���� ���� ���̳ʸ� ���� ������ ����� �� ��� ����.
 *  
 *  	InputStream (�߻�Ŭ����) 
 *   		- FileInputStream
 *   		- BufferedInputStream
 *   		- DataInputStream
 *
 *   	OutputStream (�߻�Ŭ����)
 *   		- FileOutputStream
 *   		- BufferedOutputStream
 *   		- DataOutputStream
 *   		- PrintStream
 *  - char
 *      char ó���� �ؽ�Ʈ ���� ������ ����½� ��� ������.
 *															
 *		Reader(�߻�Ŭ����)
 *			- InputStreamReader
 *			- FileReader
 *			- BufferedReader
 *
 *		Writer(�߻�Ŭ����)
 *			- OutputStreamWriter
 *			- FileWriter
 *			- BufferedWriter
 *			- PrintWriter			
 *
 * <�ڹ��� ǥ�� �����>
 * 
 *  - System.in 
 *  	ǥ���Է����μ� Ű���忡�� �����и� �о���϶� ����.
 *  	in�� �ڷ����� InputStream�̹Ƿ� byte ������ ó����.
 *  	
 *  	int read()
 *  	 	: ��Ʈ�� ������ 1byte�� ����.
 *  		   ���ڷ� �������� char ����ȯ�ؾߵ� 
 *  
 *  	int read(byte[] b)
 *  		: ���� �����͸� byte �迭�� �����ϰ� ���� ������ ��ȯ��. 
 *  	
 *  	void close()
 *  		: �Է½�Ʈ���� ����.	
 *  
 *  - System.out
 *  	ǥ��������μ� ����ͷ� �����͸� ����� �� ����.
 *  	out�� ���������� printStream��
 *  	��ǥ���� ���°� ���� ����ߴ� System.out.pirntln();
 *  - Syetem.err
 *		ǥ�ؿ��ημ� ����Ϳ� �������� ����Ҷ� ����
 *		���� ������ ����
 *																													  					 
 * */
// Ű���忡�� �Էµ� �����͸� ����Ϳ� ���
public class Test {

	public static void main(String[] args) {
		System.out.println("������ �Է�");

		InputStream is = System.in;

		try {
			int n = is.read();

			System.out.println("�Է°� :" + (char) n);

			is.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

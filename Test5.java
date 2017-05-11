package io.test.com;

import java.io.File;

/*
 * File Ŭ����
 *  : ���� �� ���丮 ���õ� ��Ÿ �����͸� ó���ϴ� Ŭ����
 *  	���ϸ�, ����ũ��, �б���, ������, ���丮 ���� ���� ó�� �۾�
 *  
 *   	<File ��ü�� ������ ���� �����ϴ°� �ƴ�.>
 *   ������ �����ϴ� ������ ��Ÿ������ �˾ƺ��� ���� ��ü�� ������.
 * 
 * File ������
 * 	-File(String fileName)
 * 		: ���ϸ��� ���ڷ� �����Ͽ� File ��ü�� ������.  
 * 
 * 
 * 
 * 
 * 
 * */
public class Test5 {

	public static void main(String[] args) {
		File f = new File("C:\\busTest", "Test5.java");

		System.out.println(f.getName());
		System.out.println(f.getPath());
		System.out.println(f.length());
		System.out.println(f.exists()); // ���� �Ǵ� ���丮 ���翩��
		System.out.println(File.separator); // ��� ������

		boolean b = new File("C:\\busTest\\aaa").mkdir(); // test ���丮�ȿ� aaa
															// ���丮 ����
		new File("C:\\busTest", "Test4.java").delete(); // �����ϰ� �������� ����

		String[] list = new File("C:\\busTest").list();
		for (String str : list) {
			System.out.println("test �������� : " + str);
		}

		// if(f.exists()){
		// f.delete();
		// }
	}

}

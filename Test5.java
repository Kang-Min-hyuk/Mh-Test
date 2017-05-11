package io.test.com;

import java.io.File;

/*
 * File 클래스
 *  : 파일 및 디렉토리 관련된 메타 데이터를 처리하는 클래스
 *  	파일명, 파일크기, 읽기모드, 쓰기모드, 디렉토리 생성 등의 처리 작업
 *  
 *   	<File 객체의 생성이 파일 생성하는게 아님.>
 *   기존에 존재하는 파일의 메타정보를 알아보기 위한 객체를 생성함.
 * 
 * File 생성자
 * 	-File(String fileName)
 * 		: 파일명을 인자로 지정하여 File 객체를 생성함.  
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
		System.out.println(f.exists()); // 파일 또는 디렉토리 존재여부
		System.out.println(File.separator); // 경로 구분자

		boolean b = new File("C:\\busTest\\aaa").mkdir(); // test 디렉토리안에 aaa
															// 디렉토리 생성
		new File("C:\\busTest", "Test4.java").delete(); // 삭제하고 성공여부 리턴

		String[] list = new File("C:\\busTest").list();
		for (String str : list) {
			System.out.println("test 폴더내용 : " + str);
		}

		// if(f.exists()){
		// f.delete();
		// }
	}

}

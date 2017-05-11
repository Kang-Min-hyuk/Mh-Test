package io.test.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// C:\\busTest 폴더에 이미지 원본파일을 복사하여 동일한 이름으로 파일 생성하기
public class Test8 {

	public static void main(String[] args) {
		
		
		try {
			// 입력 스트림 준비
			File readFile = new File("C:\\busTest","sg.jpg");
			FileInputStream fStream = new FileInputStream(readFile);
			
			int size = (int) readFile.length(); // 바이트단위 파일크기
			
			// 출력 스트림 준비
			File writeFile = new File("C:\\busTest","hg.jpg");
			FileOutputStream outputStream = new FileOutputStream(writeFile,false);
			
			byte[] arrByte = new byte[size]; // size 값만큼 byte 배열 생성
			
			
			int count = fStream.read(arrByte); // 입력스트림 동작
			
			outputStream.write(arrByte); // 출력스트림 동작
			
			fStream.close();//   close(); 닫기
			outputStream.close(); // close(); 
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}

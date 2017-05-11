package io.test1.com;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

// 키보드 입력값을 파일로 출력하기
// (여러줄에 걸쳐서 입력받기)
public class Test3_0511 {

	public static void main(String[] args) {
		String id = null;
		String pwd = null;
		String age = null;

		// 입력스트림 준비
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// 출력스트림 준비
		FileWriter writer = null;
		try {
			writer = new FileWriter("C:\\busTest\\data.txt", true); // true : 추가 , false : 덮어쓰기 
			
			// 입력받기
			System.out.print("아이디 : ");
			id =  reader.readLine();
			
			System.out.print("패스워드 : ");
			pwd = reader.readLine();
			
			System.out.print("나이 : ");
			age = reader.readLine();
			
			// 파일로 출력하기
			
			// 다음줄로 줄바꿈  <"\r\n">
			writer.write(id);
			writer.write("\r\n");
			writer.flush(); // buffer를 강제로 비우게 됨.
			
			writer.write(pwd);
			writer.write("\r\n");

			writer.write(age);
			writer.write("\r\n");

//			reader.close(); 표준 출력을 제외한 스트링은 명시적으로 닫을 필요가없다, 추후 사용가능하기때문에
			writer.close(); // 자원을 닫는 시점에 buffer를 비우게 됨. -> 목적지로 전송되는 시점
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

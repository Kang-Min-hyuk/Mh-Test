package io.test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 *  - Node 계열 
 * 		원시 데이터를 직접 처리하는 클래스 계열
 * 		원시 데이터란 -> 자바 I/O의 기본 처리 데이터인
 * 		byte 또는 char로서 가공되지 않은 데이터를 의미
 * 
 * 		대표적으로 상위 클래스들인 InputStream, OutputStream,
 * 		Reader, Writer 클래스들이 해당함
 * 
 * 		Node 계열 클래스들의 특징은 비효율적인 입출력만이 가능.
 *  - Filter 계열
 * 		Node 계열만 사용해서는 비효율적으로 처리되기 때문에
 * 		효율적으로 처리하기 위해서 byte를 char로 변환시키거나InputStreamReader)
 * 		한 라인씩 처리하는 클래스들이 제공됨.
 * 
 * */


public class Test4 {

	
		public static void main(String[] args) {
			System.out.println("데이터를 입력하세요.");

			InputStream is = System.in;

			InputStreamReader isReader = new InputStreamReader(is);
			BufferedReader bReader = new BufferedReader(isReader);

//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			// 데코레이션 패턴
			try {
				String str = bReader.readLine();

				System.out.println("입력값 : " + str);

				bReader.close(); // 최종적으로 사용한 자원만 닫으면
								 // 연결된 자원도 연속적으로 닫힘.

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}

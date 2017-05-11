package network.test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * <URL 클래스> (Unified Resource Locator) 
 *  : World Wide Web 상의 '자원'들을 사용하기 위한 포인터 역할의 클래스
 * 
 * 
 * <URL 형식>
 *  http://www.kkk.co.kr:80/network/index.html
 *  
 *   - <http -> protocol 
 *   - www.kkk.co.kr -> host
 *   - 80 -> port 번호
 *   	포트번호는 0~65536 사이에서 사용 가능.
 *   	0~1023 사이의 번호는 시스템에 예약이 되어 있음.
 *   	1024~65536 까지의 포트는 사용자가 임의로 사용할 수 있음. 
 *   		FTP 서비스 : 21
 *  		TELNET 서비스 : 23
 *  		SMTP 서비스 : 25		
 *   		HTTP 서비스 : 80
 *   
 *   - network/index.html -> path
 *  
 * */

// URL 클래스를 이용해서 www.naver.com 문서내용을 표준출력하기

public class Test1 {

	public static void main(String[] args) {
			try {
				URL url = new URL("https://www.naver.com");
				
				InputStream is = url.openStream(); // URL 객체에서 InputStream을 얻기 위해서 openStream() 메소드 호출함.
				InputStreamReader isReader = new InputStreamReader(is);
				BufferedReader reader = new BufferedReader(isReader);
				
				String strLine = reader.readLine();
				while(strLine != null){
					System.out.println(strLine);
					strLine =reader.readLine();
				}
				
				reader.close();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}

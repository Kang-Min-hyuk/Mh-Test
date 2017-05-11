package network.test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * <URL Ŭ����> (Unified Resource Locator) 
 *  : World Wide Web ���� '�ڿ�'���� ����ϱ� ���� ������ ������ Ŭ����
 * 
 * 
 * <URL ����>
 *  http://www.kkk.co.kr:80/network/index.html
 *  
 *   - <http -> protocol 
 *   - www.kkk.co.kr -> host
 *   - 80 -> port ��ȣ
 *   	��Ʈ��ȣ�� 0~65536 ���̿��� ��� ����.
 *   	0~1023 ������ ��ȣ�� �ý��ۿ� ������ �Ǿ� ����.
 *   	1024~65536 ������ ��Ʈ�� ����ڰ� ���Ƿ� ����� �� ����. 
 *   		FTP ���� : 21
 *  		TELNET ���� : 23
 *  		SMTP ���� : 25		
 *   		HTTP ���� : 80
 *   
 *   - network/index.html -> path
 *  
 * */

// URL Ŭ������ �̿��ؼ� www.naver.com ���������� ǥ������ϱ�

public class Test1 {

	public static void main(String[] args) {
			try {
				URL url = new URL("https://www.naver.com");
				
				InputStream is = url.openStream(); // URL ��ü���� InputStream�� ��� ���ؼ� openStream() �޼ҵ� ȣ����.
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

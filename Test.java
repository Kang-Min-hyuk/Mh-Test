package network.test.com;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * [java.net] 패키지
 * 
 * <InetAddress 클래스>
 *  : 자바에서 IP주소를 사용할 수 있는 기능을 제공하는 클래스.
 *  
 *  - getAddress()
 *   	: InetAddress 클래스가 가지고 있는 IP주소의 byte 배열을 얻음.
 *   
 *  - getHostAddress()
 * 		: IP 주소를 문자열로 나타냄.
 * 
 *  - getHostName()
 *  	: 객체가 가지는 호스트 이름을 문자열로 나타냄.
 *  
 *  - getByName(String host)
 *  	: 주어진 이름을 갖는 호스트의 IP주소를 얻음.
 *  
 * 	- getAllByName(String host)
 * 		: 주어진 이름을 갖는 호스트의 IP주소들을 얻음.
 * 
 * 	- getLocalHost()
 * 		: 현재 시스템의 호스트 IP주소를 얻음.
 * 
 * */
public class Test {

	public static void main(String[] args) {

		String name = "www.google.co.kr"; // Domain Name

		try {
			InetAddress inetAddress = InetAddress.getByName(name);
			String hostName = inetAddress.getHostName(); // Domain Name
			String hostAddress = inetAddress.getHostAddress();  // IP Address

			System.out.println(hostName + " " + hostAddress);
			
			// 현재 프로그램이 실행되는 컴퓨터 기기의 인터넷주소객체
			InetAddress inetLocal = inetAddress.getLocalHost();
			String localName = inetLocal.getHostName();
			String localAddress = inetLocal.getHostAddress();
			
			System.out.println(localName + " " + localAddress);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}

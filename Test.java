package network.test.com;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * [java.net] ��Ű��
 * 
 * <InetAddress Ŭ����>
 *  : �ڹٿ��� IP�ּҸ� ����� �� �ִ� ����� �����ϴ� Ŭ����.
 *  
 *  - getAddress()
 *   	: InetAddress Ŭ������ ������ �ִ� IP�ּ��� byte �迭�� ����.
 *   
 *  - getHostAddress()
 * 		: IP �ּҸ� ���ڿ��� ��Ÿ��.
 * 
 *  - getHostName()
 *  	: ��ü�� ������ ȣ��Ʈ �̸��� ���ڿ��� ��Ÿ��.
 *  
 *  - getByName(String host)
 *  	: �־��� �̸��� ���� ȣ��Ʈ�� IP�ּҸ� ����.
 *  
 * 	- getAllByName(String host)
 * 		: �־��� �̸��� ���� ȣ��Ʈ�� IP�ּҵ��� ����.
 * 
 * 	- getLocalHost()
 * 		: ���� �ý����� ȣ��Ʈ IP�ּҸ� ����.
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
			
			// ���� ���α׷��� ����Ǵ� ��ǻ�� ����� ���ͳ��ּҰ�ü
			InetAddress inetLocal = inetAddress.getLocalHost();
			String localName = inetLocal.getHostName();
			String localAddress = inetLocal.getHostAddress();
			
			System.out.println(localName + " " + localAddress);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}

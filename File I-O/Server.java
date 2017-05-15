package io.test1.com;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 
 * Socket Ŭ���� 
 *   ���� ȣ��Ʈ�� ���� I/O ����� ��� ���¸� �����ϰ� ����.
 *   
 *   
 * Socket Ŭ���� <�ֿ� �޼ҵ�>
 *  void close() ���� ��ü�� ����.
 *  
 *  InetAddress getInetAddress() ���� ��ü�κ��� InetAddress ��ȯ
 *  
 *  InetAddress getLocalAddress() ���� �ּҸ� ��ȯ
 *  
 *  InputStream getInputStream() ���� ��ü�κ��� InputStream ��ȯ 
 *  
 *  int port() ���� ��ü�� ��Ʈ��ȣ�� ��ȯ
 *  
 * ServerSocket Ŭ����
 * 	: Socket�� �����Ǵ� ���� ȣ��Ʈ�� ������ �ǹ���.
 * 	  ServerSocket Ŭ������ accept() �޼ҵ带 ���� Ŭ���̾�Ʈ ��û�� �޾Ƶ���.
 * 
 * ServerSocket <�ֿ� �޼ҵ�>
 * 	void close() ServerSocket ��ü�� ����
 * 
 *  int getLocalport() ServerSocket ��ü�� ������ ��Ʈ��ȣ�� ��ȯ��.
 *  
 *  Socket accept() Ŭ���̾�Ʈ�� ��û�� ��ٸ��� �޼ҵ�
 * 	  
 * */
public class Server {

	public static void main(String[] args) {
		try {
			int portNumber = 5001;
			
			ServerSocket serverSocket = new ServerSocket(5001);
			
			// accept() ȣ��Ǹ� Ŭ���̾�Ʈ�� ��û������ ��ٸ�.
			// Ŭ���̾�Ʈ�� ������ ���ӵǸ�
			// Ŭ���̾�Ʈ ������ ���� ���� ��ü�� ��ȯ��.
			Socket socket = serverSocket.accept();
			
			InetAddress clientAddress = socket.getLocalAddress();
			int clientPort = socket.getPort();
			System.out.println("Ŭ���̾�Ʈ�� ���ӵ�. ");
			System.out.println("host : " + clientAddress + " , " + clientPort);
			
			// �Է½�Ʈ�� �غ�
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			Object object = ois.readObject();
			System.out.println("Ŭ���̾�Ʈ�κ��� �Էµ� ��: " +object);
			
			// ��½�Ʈ�� �غ� 
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject("�����κ��� ���� ��: " + object);
			
			// �ڿ� �ݱ� 
			oos.flush(); // ���� ����
			oos.close(); // ��½�Ʈ�� �ݱ�
			ois.close(); // �Է½�Ʈ�� �ݱ� 
			socket.close(); // ���� �ݱ�
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}

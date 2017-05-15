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
 * Socket 클래스 
 *   원격 호스트에 대한 I/O 기반의 통신 상태를 구축하게 해줌.
 *   
 *   
 * Socket 클래스 <주요 메소드>
 *  void close() 소켓 객체를 닫음.
 *  
 *  InetAddress getInetAddress() 소켓 객체로부터 InetAddress 반환
 *  
 *  InetAddress getLocalAddress() 로컬 주소를 반환
 *  
 *  InputStream getInputStream() 소켓 객체로부터 InputStream 반환 
 *  
 *  int port() 소켓 객체의 포트번호를 반환
 *  
 * ServerSocket 클래스
 * 	: Socket에 대응되는 원격 호스트의 소켓을 의미함.
 * 	  ServerSocket 클래스는 accept() 메소드를 통해 클라이언트 요청을 받아들임.
 * 
 * ServerSocket <주요 메소드>
 * 	void close() ServerSocket 객체를 닫음
 * 
 *  int getLocalport() ServerSocket 객체에 설정된 포트번호를 반환함.
 *  
 *  Socket accept() 클라이언트의 요청을 기다리는 메소드
 * 	  
 * */
public class Server {

	public static void main(String[] args) {
		try {
			int portNumber = 5001;
			
			ServerSocket serverSocket = new ServerSocket(5001);
			
			// accept() 호출되면 클라이언트의 요청정보를 기다림.
			// 클라이언트가 서버에 접속되면
			// 클라이언트 정보를 가진 소켓 객체를 반환함.
			Socket socket = serverSocket.accept();
			
			InetAddress clientAddress = socket.getLocalAddress();
			int clientPort = socket.getPort();
			System.out.println("클라이언트가 접속됨. ");
			System.out.println("host : " + clientAddress + " , " + clientPort);
			
			// 입력스트림 준비
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			Object object = ois.readObject();
			System.out.println("클라이언트로부터 입력된 값: " +object);
			
			// 출력스트림 준비 
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject("서버로부터 받은 값: " + object);
			
			// 자원 닫기 
			oos.flush(); // 버퍼 비우기
			oos.close(); // 출력스트림 닫기
			ois.close(); // 입력스트림 닫기 
			socket.close(); // 소켓 닫기
			
			serverSocket.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}

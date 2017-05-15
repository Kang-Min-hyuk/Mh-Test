package io.test1.com;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		int portNumber = 5001;
		try {

			Socket socket = new Socket("localhost", portNumber);

			// ��½�Ʈ�� �غ�
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject("Hi Android");
			oos.flush(); // ���� ����.
			
			// �Է½�Ʈ�� �غ�
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			String str =  (String)ois.readObject();
			System.out.println(str);
			
			ois.close();
			oos.close();
			socket.close();
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

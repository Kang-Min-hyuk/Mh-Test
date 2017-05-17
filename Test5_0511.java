package io.test1.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 *	[ 메모리에 생성된 객체는 비영속성(=일시성)을 가짐 ]
 * 
 *  자바에서는 '객체 직렬화(Object Serialization)' 기능을 제공함.
 *  객체 직렬화를 적용하면 메모리에 생성된 인스턴스 정보를
 *  파일이나 네트워크를 통해서 영속성을 유지할 수 있음.
 *  
 *  <객체 직렬화를 명시하는 방법>
 *  public class 클래스명  implements Serializable{}
 *  
 *  <Serializable>
 *   - 단지 마킹 기능을 가지는 용도로 사용하는 마커(marker) 인터페이스
 *   
 *   <객체 직렬화를 위한 I/O클래스>
 *   
 *    - ObjectInputStream
 *    	: 객체 직렬화된 데이터를 읽을 때 사용함. 역직렬화할 때 사용함.
 *    
 *    - ObjectOutputStream
 *   	: 인스턴스를 객체 직렬화로 출력할 때 사용함.
 *   
 *   <객체 직렬화의 특징>
 *   - Sereializable 인터페이스를 사용함.
 *   - 메모리에 생성된 인스턴스를 내부적으로 byte로 처리함.
 *   - byte 단위로 처리되기 때문에 반드시 ObjectInputStream과
 *     ObjectOutputStream을 사용해야 됨.
 *   - 연쇄적으로 발생됨. 직렬화 될 객체의 멤버변수가 참조하는
 *     객체까지도 연쇄적으로 객체 직렬화된다는 의미.
 *   - 대부분의 API는 모두 객체 지렬화 가능한 클래스들임.(String,ArrayList)
 *   - 객체 직렬화에서 제외시는 방법은 transient 키워드로 명시하면 됨.  
 *       
 * */
// Person 객체를 직렬화 시켜서 파일로 가져오기
public class Test5_0511 {

	public static void main(String[] args) {

		Person person = new Person("홍길동",30);
		
		File file = new File("C:\\bustest","serial.dat");
		try {
			// 출력스트림 준비
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(person); // 직렬화 시키기 
			
			// 자원닫기 (기본입출력이 아닌 입출력 자원은 꼭 닫아야 됨)
			oos.close();
		} catch (FileNotFoundException e) { // FileOutputStream
			e.printStackTrace();
		} catch (IOException e) { // ObjectOutputStream
			e.printStackTrace();
		}
	}

}

package jdbc.test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Test {

	public static void main(String[] args) {
		// DB 접속정보
		String url = "jdbc:mysql://localhost:3306/sample"; // SQL 포트번호와 스키마의 이름지정
															
		String user = "root";
		String password = "1234";

		// member 테이블에 INSERT 할 정보
		String id = "bb";
		String passwd = "123";
		String name = "리신";
		String address = "부전동";
		int age = 30;
		
		
		// Calendar cal = Calendar.getInstance();
		// Date date = new Date (cal.getTimeInMillis());
		// Time time = new Time(System.currentTimeMillis());
		Timestamp ts = new Timestamp(System.currentTimeMillis());

		Connection con = null;
		PreparedStatement ps = null;

		try {
			// 드라이버 로딩 (Driver 클래스)
			Class.forName("com.mysql.jdbc.Driver");

			// DB 연결(DB 주소, 아이디, 비밀번호) => Connection 객체
			con = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO member1(id, passwd, name, address, age, reg_date) VALUES (?, ?, ?, ?, ?, ?)";
			// Connection으로부터 PreparedStatement 객체 생성
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, passwd);
			ps.setString(3, name);
			ps.setString(4, address);
			ps.setInt(5, age);
			ps.setTimestamp(6, ts);

			// sql 실행
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용의 역순으로 닫음
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}
}

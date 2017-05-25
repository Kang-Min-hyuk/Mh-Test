package jdbc.test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Test1 {

	public static void main(String[] args) {
		// DB 접속정보
		String url = "jdbc:mysql://localhost:3306/sample"; // SQL 포트번호와 스키마의 이름
															// 지정
		String user = "root";
		String password = "1234";

		Connection con = null; // DB 연결정보
		PreparedStatement ps = null; // SQL 문 실행기능
		ResultSet rs = null; // SELECT 문 결과를 테이블형식으로 갖고있음

		// 드라이버 로딩
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 커넥션 가져오기 (DB 연결작업)
			con = DriverManager.getConnection(url, user, password);

			String sql = "SELECT * FROM member";
			// 쿼리문을 가지는 문장객체를 생성
			ps = con.prepareStatement(sql);
			// 실행(select문)
			rs = ps.executeQuery();

			String id = null;
			String passwd = null;
			String name = null;
			int age = 0;
			Timestamp ts = null;

			while (rs.next()) {
				id = rs.getString("id");
				passwd = rs.getString("passwd");
				name = rs.getString("name");
				age = rs.getInt("age");
				ts = rs.getTimestamp("reg_date");

				System.out.println(id + ", " + passwd + ", " + name + "," + age + ", " + ts);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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

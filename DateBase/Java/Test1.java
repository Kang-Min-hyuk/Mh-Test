package jdbc.test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Test1 {

	public static void main(String[] args) {
		// DB ��������
		String url = "jdbc:mysql://localhost:3306/sample"; // SQL ��Ʈ��ȣ�� ��Ű���� �̸�
															// ����
		String user = "root";
		String password = "1234";

		Connection con = null; // DB ��������
		PreparedStatement ps = null; // SQL �� ������
		ResultSet rs = null; // SELECT �� ����� ���̺��������� ��������

		// ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Ŀ�ؼ� �������� (DB �����۾�)
			con = DriverManager.getConnection(url, user, password);

			String sql = "SELECT * FROM member";
			// �������� ������ ���尴ü�� ����
			ps = con.prepareStatement(sql);
			// ����(select��)
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

package jdbc.test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Test {

	public static void main(String[] args) {
		// DB ��������
		String url = "jdbc:mysql://localhost:3306/sample"; // SQL ��Ʈ��ȣ�� ��Ű���� �̸�����
															
		String user = "root";
		String password = "1234";

		// member ���̺� INSERT �� ����
		String id = "bb";
		String passwd = "123";
		String name = "����";
		String address = "������";
		int age = 30;
		
		
		// Calendar cal = Calendar.getInstance();
		// Date date = new Date (cal.getTimeInMillis());
		// Time time = new Time(System.currentTimeMillis());
		Timestamp ts = new Timestamp(System.currentTimeMillis());

		Connection con = null;
		PreparedStatement ps = null;

		try {
			// ����̹� �ε� (Driver Ŭ����)
			Class.forName("com.mysql.jdbc.Driver");

			// DB ����(DB �ּ�, ���̵�, ��й�ȣ) => Connection ��ü
			con = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO member1(id, passwd, name, address, age, reg_date) VALUES (?, ?, ?, ?, ?, ?)";
			// Connection���κ��� PreparedStatement ��ü ����
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, passwd);
			ps.setString(3, name);
			ps.setString(4, address);
			ps.setInt(5, age);
			ps.setTimestamp(6, ts);

			// sql ����
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ����� �������� ����
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

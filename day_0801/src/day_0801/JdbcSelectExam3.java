package day_0801;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSelectExam3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. JDBC 드라이버 로딩(동적로딩)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("JDBC 드라이버 로딩 성공 !");
		
		// 2. DBMS 연결
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String user = "hr";
		String password = "HR";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("DBMS 로그인 성공 !");
		
		// 3. SQL 작성
		String sql = "SELECT * FROM MEMBERS ORDER BY id";
		
		// 4. Statement 생성
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 5. 데이터 설정
		
		// 6. SQL 전송 및 결과 수신 - DML 전송 : executeUpdate(), int 타입 반환 / SELECT 전송 : executeQuery(), ResultSet 반환
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) { // 값이 있을지 없을지 모르기 때문에 체크 필요, 행이 1개 이상일 수도 있기 때문에 반복
			String id = rs.getString("id");
			String name = rs.getString("name");
			String passwd = rs.getString("passwd");
			String status = rs.getString("status");
			System.out.println("id = " + id + ", name = " + name + ", passwd = " + passwd + ", status = " + status);
		}
		
		// 7. 자원 반환
		pstmt.close();
		con.close();
	}
}

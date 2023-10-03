package day_0801;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class 실습1 {
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
		String sql = "INSERT INTO LOGIN(member_id, login_date, login_time) ";
		sql += "VALUES(?, ?, ?)";
		
		// 4. Statement 생성
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 5. 데이터 설정
		pstmt.setString(1, "user03");
		pstmt.setString(2, "20230730");
		pstmt.setString(3, "101000");
		
		// 6. SQL 전송 및 결과 수신
		int count = pstmt.executeUpdate();
		System.out.println(count + "개 행 입력 완료 !");
		
		// 7. 자원 반환
		pstmt.close();
		con.close();
	}
}

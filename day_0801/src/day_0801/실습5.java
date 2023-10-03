package day_0801;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import day_0801.dto.LoginDto;

public class 실습5 {
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
		String sql = "SELECT l.member_id, m.name, l.login_date, l.login_time, l.logout_date, l.logout_time "
				+ "FROM login l "
				+ "JOIN members m ON l.member_id = m.id "
				+ "ORDER BY l.member_id";
		
		// 4. Statement 생성
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 5. 데이터 설정
		
		// 6. SQL 전송 및 결과 수신
		ArrayList<LoginDto> loginList = new ArrayList<>();
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) { 
			String member_id = rs.getString("member_id");
			String member_name = rs.getString("name");
			String login_date = rs.getString("login_date");
			String login_time = rs.getString("login_time");
			String logout_date = rs.getString("logout_date");
			String logout_time = rs.getString("logout_time");
			loginList.add(new LoginDto(member_id, member_name, login_date, login_time, logout_date, logout_time));
		}
		
		// 7. 자원 반환
		pstmt.close();
		con.close();
		
		for(LoginDto info : loginList) {
			System.out.println(info);
		}
	}
}

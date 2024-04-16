package board.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {

	public static Connection connect() throws Exception  /* throws NamingException, SQLException */ {
		// Connection Pool 로딩
		Context init = new InitialContext();
        DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/oraxe");
        Connection con = ds.getConnection();
		
		return con;
	}

	public static void close(PreparedStatement pstmt, Connection con) {
		try {
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {}
		
		try {
			if(con != null) con.close();
		} catch (SQLException e) {}
	}

}

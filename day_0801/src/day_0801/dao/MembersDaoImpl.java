package day_0801.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import day_0801.dto.MemberDto;
import day_0801.util.JdbcUtil;

public class MembersDaoImpl implements MembersDao {

	@Override
	public void add(MemberDto m) throws SQLException, DuplicatedIdException { // 오버라이딩 규칙 - 예외 개수는 부모보다 작거나 같아야 하며, 예외 타입은 부모와 같거나 자식 타입이어야 함
		// DBMS 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.connect();
			String sql = "INSERT INTO MEMBERS(id, name, passwd, status) VALUES(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getPasswd());
			pstmt.setString(4, m.getStatus());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { // ClassNotFoundException의 오류 메세지를 SQLException으로 감싸서 던짐
			throw new SQLException(e);
		} finally {
			// DBMS 해제
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void update(MemberDto m) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.connect();
			String sql = "UPDATE MEMBERS SET name = ?, passwd = ?, status = ? WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getPasswd());
			pstmt.setString(3, m.getStatus());
			pstmt.setString(4, m.getId());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void delete(String id) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.connect();
			String sql = "DELETE MEMBERS WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberDto> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

package day_0802.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day_0802.dto.MemberDto;
import day_0802.util.JdbcUtil;

public class MembersDaoImpl implements MembersDao {

	@Override
	public void add(MemberDto m) throws SQLException, DuplicatedIdException { // 오버라이딩 규칙 - 예외 개수는 부모보다 작거나 같아야 하며, 예외 타입은 부모와 같거나 자식 타입이어야 함
		// DBMS 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 등록 여부 검사
			if(findById(m.getId()) != null) {
				throw new DuplicatedIdException(m.getId() + "는 사용중인 아이디입니다.");
			}
			
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
			if(findById(m.getId()) == null) {
				throw new RecordNotFoundException(m.getId() + "를 찾을 수 없습니다.");
			}
			
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
			if(findById(id) == null) {
				throw new RecordNotFoundException(id + "를 찾을 수 없습니다.");
			}
			
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
		int count = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.connect();
			String sql = "SELECT count(*) FROM MEMBERS";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		
		return count;
	}

	@Override
	public List<MemberDto> list() throws SQLException {
		List<MemberDto> list = new ArrayList<MemberDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.connect();
			String sql = "SELECT * FROM MEMBERS ORDER BY id";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String passwd = rs.getString("passwd");
				String status = rs.getString("status");
				list.add(new MemberDto(id, name, passwd, status));
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		
		return list;
	}

	@Override
	public MemberDto findById(String id) throws SQLException {
		MemberDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.connect();
			String sql = "SELECT * FROM MEMBERS WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { // 값이 있을지 없을지 모르기 때문에 체크 필요, id는 PK이므로 1개 행만 반환
				String name = rs.getString("name");
				String passwd = rs.getString("passwd");
				String status = rs.getString("status");
				dto = new MemberDto(id, name, passwd, status);
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		
		return dto;
	}

}

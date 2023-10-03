package day_0802.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day_0802.dto.LoginDto;
import day_0802.util.JdbcUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public void add(LoginDto l) throws SQLException, DuplicatedIdException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			if(findById(l.getMember_id()) != null) {
				throw new DuplicatedIdException(l.getMember_id() + "는 사용중인 아이디입니다.");
			}
			
			con = JdbcUtil.connect();
			String sql = "INSERT INTO LOGIN(member_id, login_date, login_time) VALUES(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, l.getMember_id());
			pstmt.setString(2, l.getLogin_date());
			pstmt.setString(3, l.getLogin_time());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void update(LoginDto l) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			if(findById(l.getMember_id()) == null) {
				throw new RecordNotFoundException(l.getMember_id() + "를 찾을 수 없습니다.");
			}
			
			con = JdbcUtil.connect();
			String sql = "UPDATE LOGIN SET logout_date = ?, logout_time = ? WHERE member_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, l.getLogout_date());
			pstmt.setString(2, l.getLogout_time());
			pstmt.setString(3, l.getMember_id());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void delete(String member_id) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			if(findById(member_id) == null) {
				throw new RecordNotFoundException(member_id + "를 찾을 수 없습니다.");
			}
			
			con = JdbcUtil.connect();
			String sql = "DELETE LOGIN WHERE member_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);
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
			String sql = "SELECT count(*) FROM LOGIN";
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
	public List<LoginDto> list() throws SQLException {
		List<LoginDto> list = new ArrayList<LoginDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.connect();
			String sql = "SELECT * FROM LOGIN ORDER BY member_id";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String member_id = rs.getString("member_id");
				String login_date = rs.getString("login_date");
				String login_time = rs.getString("login_time");
				String logout_date = rs.getString("logout_date");
				String logout_time = rs.getString("logout_time");
				list.add(new LoginDto(member_id, login_date, login_time, logout_date, logout_time));
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		
		return list;
	}

	@Override
	public LoginDto findById(String member_id) throws SQLException {
		LoginDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.connect();
			String sql = "SELECT * FROM LOGIN WHERE member_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String login_date = rs.getString("login_date");
				String login_time = rs.getString("login_time");
				String logout_date = rs.getString("logout_date");
				String logout_time = rs.getString("logout_time");
				dto = new LoginDto(member_id, login_date, login_time, logout_date, logout_time);
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		
		return dto;
	}

}

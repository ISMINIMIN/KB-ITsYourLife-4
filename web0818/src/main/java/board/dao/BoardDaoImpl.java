package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import board.dto.BoardDto;
import board.exception.DuplicatedIdException;
import board.exception.RecordNotFoundException;
import board.util.JdbcUtil;


public class BoardDaoImpl implements BoardDao {

	@Override
	public void add(BoardDto dto) throws SQLException, DuplicatedIdException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.connect();
			String sql = "INSERT INTO BOARD(no, writer, title, content, regdate) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) { 
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		
	}

	@Override
	public void update(BoardDto dto) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			if(findById(dto.getNo()) == null) {
				throw new RecordNotFoundException(dto.getNo() + "번 게시물을 찾을 수 없습니다.");
			}
			
			con = JdbcUtil.connect();
			String sql = "UPDATE BOARD SET regdate = SYSDATE, title = ?, content = ? WHERE no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void delete(int no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.connect();
			String sql = "DELETE BOARD WHERE no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
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
			String sql = "SELECT count(*) FROM BOARD";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		
		return count;
	}

	@Override
	public List<BoardDto> list() throws SQLException {
		List<BoardDto> result = new ArrayList<BoardDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			String sql = "SELECT * FROM BOARD order by no DESC";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate"); 
				String content = rs.getString("content");
				BoardDto dto = new BoardDto(no, title, writer, content, regdate);
				result.add(dto);
			}
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		
		return result;
	}

	@Override
	public BoardDto findById(int no) throws SQLException {
		BoardDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.connect();
			String sql = "SELECT * FROM BOARD WHERE no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { 
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate"); 
				String content = rs.getString("content");
				dto = new BoardDto(no, title, writer, content, regdate);
			}
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		
		return dto;
	}
}
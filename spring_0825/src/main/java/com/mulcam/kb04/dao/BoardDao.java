package com.mulcam.kb04.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mulcam.kb04.dto.BoardDto;

@Component
public class BoardDao {

	@Autowired
	private JdbcTemplate jdbcTpl;
	
	public void insert(BoardDto dto) {
		String sql = "INSERT INTO BOARD(NO, TITLE, WRITER, CONTENT, REGDATE) ";
		sql += "VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
		jdbcTpl.update(sql, dto.getTitle(), dto.getWriter(), dto.getContent());
	}

	public List<BoardDto> list() {
		String sql = "SELECT * FROM BOARD ORDER BY NO DESC";
		List<BoardDto> list = jdbcTpl.query(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		return list;
	}

	public BoardDto findByNo(int no) {
		String sql = "SELECT * FROM BOARD WHERE NO = ?";
		BoardDto dto = jdbcTpl.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class), no);
		return dto;
	}
}

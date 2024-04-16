package com.mulcam.kb04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mulcam.kb04.dto.BoardDto;

@Controller
public class JdbcController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/ds_check")
	public String check() throws Exception {
		System.out.println("jdbcTemplate : " + jdbcTemplate);
		return "check";
	}
	
	@GetMapping("/jt_select_test")
	public String jt_select_test() {
		String sql = "SELECT * FROM BOARD ORDER BY NO DESC";
		List<BoardDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		System.out.println("list 개수 : " + list.size());
		
		return "jt_select_test";
	}
	
	@GetMapping("/jt_insert_test")
	public String jt_insert_test() {
		String sql = "INSERT INTO BOARD(NO, TITLE, WRITER, CONTENT, REGDATE) ";
		sql += "VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
		jdbcTemplate.update(sql, "jdbc test", "jt1", "등록");
		System.out.println("jdbcTemplate.update OK");
		
		return "jt_insert_test";
	}
	
}

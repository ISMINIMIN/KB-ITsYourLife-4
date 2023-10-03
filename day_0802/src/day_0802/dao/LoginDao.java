package day_0802.dao;

import java.sql.SQLException;
import java.util.List;

import day_0802.dto.LoginDto;

public interface LoginDao {
	  //등록
	  public void add(LoginDto l) throws SQLException, DuplicatedIdException;
	  //수정
	  public void update(LoginDto l) throws SQLException, RecordNotFoundException;
	  //삭제
	  public void delete(String id) throws SQLException, RecordNotFoundException;
	  //갯수
	  public int count() throws SQLException;
	  //목록
	  public List<LoginDto> list() throws SQLException;
	  //검색
	  public LoginDto findById(String id) throws SQLException;
}

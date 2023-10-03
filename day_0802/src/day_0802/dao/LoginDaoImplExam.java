package day_0802.dao;

import java.sql.SQLException;
import java.util.List;

import day_0802.dto.LoginDto;

public class LoginDaoImplExam {
	static LoginDao loginDao = new LoginDaoImpl();
	
	public static void main(String[] args) {
		add();
		update();
		delete();
		find();
		count();
		list();
	}

	private static void add() {
		try {
			loginDao.add(new LoginDto("user07", "20230801", "090000", null, null));
			System.out.println("등록 성공");
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
		} catch (DuplicatedIdException e) {
			System.err.println("아이디가 중복됩니다.");
			e.printStackTrace();
		}
	}
	
	private static void update() {
		try {
			loginDao.update(new LoginDto("user07", null, null, "2030801", "180000"));
			System.out.println("수정 성공");
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			System.err.println("정보를 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}
	
	private static void delete() {
		try {
			loginDao.delete("user07");
			System.out.println("삭제 성공");
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
		} catch (RecordNotFoundException e) {
			System.err.println("정보를 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}
	
	private static void find() {
		try {
			LoginDto dto = loginDao.findById("user07");
			if(dto == null) System.out.println("등록되지 않은 아이디입니다.");
			else System.out.println(dto);
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
			e.printStackTrace();
		}
	}
	
	private static void count() {
		try {
			int count = loginDao.count();
			System.out.println("등록 개수 : " + count);
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
		}
	}
	
	private static void list() {
		try {
			List<LoginDto> list = loginDao.list();
			System.out.println("## 전체 조회 ##");
			for(LoginDto dto : list) {
				System.out.println(dto);
			}
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
		}
	}
}

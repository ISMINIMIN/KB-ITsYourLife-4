package day_0802.dao;

import java.sql.SQLException;
import java.util.List;

import day_0802.dto.MemberDto;

public class MembersDaoImplExam {
	static MembersDao membersDao = new MembersDaoImpl();
	
	public static void main(String[] args) {
		
//		add();
//		update();
//		delete();
//		find();
//		count();
		list();
	}
	

	private static void add() {
		try {
			membersDao.add(new MemberDto("user07", "유저7", "7777", "Y"));
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
			membersDao.update(new MemberDto("user07", "유저7", "7777", "N"));
			System.out.println("수정 성공");
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
		} catch (RecordNotFoundException e) {
			System.err.println("정보를 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}
	
	private static void delete() {
		try {
			membersDao.delete("user07");
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
			MemberDto dto = membersDao.findById("user07");
			if(dto == null) System.out.println("등록되지 않은 아이디입니다.");
			else System.out.println(dto);
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
		}
	}
	
	private static void count() {
		try {
			int count = membersDao.count();
			System.out.println("등록 개수 : " + count);
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
		}
	}
	
	private static void list() {
		try {
			List<MemberDto> list = membersDao.list();
			System.out.println("## 전체 조회 ##");
			for(MemberDto dto : list) {
				System.out.println(dto);
			}
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
		}
	}
}

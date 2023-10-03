package day_0801.dao;

import java.sql.SQLException;

import day_0801.dto.MemberDto;

public class MembersDaoImplExam {
	public static void main(String[] args) {
		MembersDao membersDao = new MembersDaoImpl();
		try {
			membersDao.add(new MemberDto("user07", "유저7", "7777", "Y"));
			System.out.println("등록 성공");
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
		} catch (DuplicatedIdException e) {
			System.err.println("아이디가 중복됩니다.");
		}
		
		try {
			membersDao.update(new MemberDto("user07", "유저7", "7777", "N"));
			System.out.println("수정 성공");
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
		} catch (RecordNotFoundException e) {
			System.err.println("정보를 찾을 수 없습니다.");
		}
		
		try {
			membersDao.delete("user07");
			System.out.println("삭제 성공");
		} catch (SQLException e) {
			System.err.println("DBMS 오류 발생");
		} catch (RecordNotFoundException e) {
			System.err.println("정보를 찾을 수 없습니다.");
		}
	}
}

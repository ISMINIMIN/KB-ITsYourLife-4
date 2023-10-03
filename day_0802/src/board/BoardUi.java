package board;

import java.util.List;
import java.util.Scanner;

import board.dao.RecordNotFoundException;
import board.dto.BoardDto;

public class BoardUi {
	public static void main(String[] args) {
		new BoardUi().go();
	}

	private void go() {
		init(); // 필요한 변수 초기화
//		list(); // 게시물 목록 출력
		while (true) {
			mainMenu(); // 메인메뉴 출력
		}
	}

	private BoardService brdSvc; // 게시판 서비스
	private Scanner sc;
	
	private void init() {
		brdSvc = new BoardServiceImpl();
		sc = new Scanner(System.in);
	}

	private void list() {
		System.out.println("[게시물 목록]");
		System.out.println("--------------------------------------");
		System.out.printf("%-5s%-11s%-15s%-40s \n",
				"번호", "작성자", "게시일", "제목");
		System.out.println("--------------------------------------");
		List<BoardDto> list;
		try {
			list = brdSvc.list();
			for(BoardDto dto : list) {
				System.out.printf("%-6s%-12s%-16s%-40s \n",
						dto.getNo(), dto.getWriter(), dto.getRegdate(), dto.getTitle());
			}
			System.out.println();
		} catch (BoardException e) {
			System.err.println("서버에 오류가 발생했습니다.");
			e.printStackTrace();
		}
	}
	
	private void mainMenu() {
		System.out.println("메인 메뉴 : (1)등록 (2)목록 (3)상세 (4)삭제 (5)수정 (6)개수 (7)종료");
		System.out.print("메뉴 선택 : ");
		int menu = Integer.parseInt(sc.nextLine());
		System.out.println();
		if(menu == 1) {
			addBoard();
		} else if(menu == 2) {
			list();
		} else if(menu == 3) {
			readBoard();
		} else if(menu == 4) {
			deleteBoard();
		} else if(menu == 5) {
			updateBoard();
		} else if(menu == 6) {
			count();
		} else if(menu == 7) {
			System.exit(0); // VM 종료
		}
	}

	private void addBoard() {
		System.out.println("[게시물 등록]");
		System.out.print("제목을 입력하세요 : ");
		String title = sc.nextLine();
		System.out.print("작성자를 입력하세요 : ");
		String writer = sc.nextLine();
		System.out.print("내용을 입력하세요 : ");
		String content = sc.nextLine();
		System.out.println();
		BoardDto dto = new BoardDto(0, title, writer, null, content);
		try {
			brdSvc.add(dto);
		} catch (BoardException e) {
			System.out.println("게시물 등록 오류");
		}
	}
	
	private void readBoard() {
		System.out.print("내용을 보고싶은 게시물 번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println();
		try {
			BoardDto dto = brdSvc.read(no);
			if(dto == null) throw new RecordNotFoundException();
			System.out.println("[상세보기]");
			System.out.println("번호 : " + dto.getNo());
			System.out.println("제목 : " + dto.getTitle());
			System.out.println("작성자 : " + dto.getWriter());
			System.out.println("작성일 : " + dto.getRegdate());
			System.out.println("내용 : " + dto.getContent());
			System.out.println();
		} catch (BoardException e) {
			System.out.println("게시물 서버 오류");
		} catch (RecordNotFoundException e) {
			System.out.println("정보를 찾을 수 없습니다.");
		}
	}
	
	private void deleteBoard() {
		System.out.println("[게시물 삭제]");
		System.out.print("삭제하고 싶은 게시물 번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		
		BoardDto dto = null;
		try {
			dto = brdSvc.read(no);
			if(dto == null) throw new RecordNotFoundException();
			System.out.print(no + "번 게시물을 정말 삭제하시겠습니까? (Y/N) : ");
			String check = sc.nextLine();
			System.out.println();
			if(check.equals("Y")) {
				try {
					boolean flag = brdSvc.delete(no);
					if(flag) System.out.println("삭제되었습니다.");
					else System.out.println("삭제를 실패했습니다.");
					System.out.println();
				} catch (BoardException e) {
					System.out.println("게시물 삭제 오류");
				}
			}
		} catch (BoardException e) {
			System.out.println("게시물 서버 오류");
		} catch (RecordNotFoundException e) {
			System.out.println("정보를 찾을 수 없습니다.");
		}
	}
	
	private void updateBoard() {
		System.out.println("[게시물 수정]");
		System.out.print("수정하고 싶은 게시물 번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("제목을 수정합니다. : ");
		String title = sc.nextLine();
		System.out.print("내용을 수정합니다. : ");
		String content = sc.nextLine();
		System.out.println();
		BoardDto dto = new BoardDto(no, title, null, null, content);
		try {
			brdSvc.update(dto);
		} catch (BoardException e) {
			System.out.println("게시물 수정 오류");
		}
	}
	
	private void count() {
		int count = 0;
		
		try {
			count = brdSvc.count();
		} catch (BoardException e) {
			System.out.println("게시물 서버 오류");
		}
		
		System.out.println("현재 게시물 개수는 " + count + "개 입니다.");
		System.out.println();
	}
}

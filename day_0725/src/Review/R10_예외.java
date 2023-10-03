package Review;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class R10_예외 {
	public static void main(String[] args) {
		try {
			readFile2();
			System.out.println("파일 처리 성공");
		} catch (FileNotFoundException e) {
			System.err.println("파일 처리 실패");
		}
		
//		readFile();
	}

	// try-catch를 이용한 예외 처리
	private static void readFile() {
		// 파일에서 문자 읽기
		try {
			FileReader fileReader = new FileReader("poem.txt"); // 현재 디렉토리(프로젝트 폴더)에 있는 파일
			System.out.println("파일 열기 성공");
		} catch (FileNotFoundException e) {
			System.out.println("파일 없음"); // 정상적인 실행 상황에서의 메세지 출력
			System.err.println("파일 없음"); // 오류 상황에서의 메세지 출력
			e.printStackTrace();
		}
	}
	
	// 예외 떠넘기기(throws)
	private static void readFile2() throws FileNotFoundException {
		// 파일에서 문자 읽기
		FileReader fileReader = new FileReader("poem.txt"); // 현재 디렉토리(프로젝트 폴더)에 있는 파일
		System.out.println("파일 열기 성공");
	}
}

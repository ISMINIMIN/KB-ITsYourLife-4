package 그림판;

/** 자바 그림판 메인 테스트 클래스 */

public class PainterExam {
	public static void main(String[] args) {
		
		// 도형객체 생성(선, 원, 사각형, 다각형, 등)
		// 선 : x1, y1, x2, y2
		// 도형 : x, y, radius
		// 사각 : x, y, width, height
		// MyShape : 도형의 부모 클래스로 도형들의 공통 변수, 메서드를 정의(x, y, draw())
		
		MyLine myLine = new MyLine(3, 3, 5, 5); // 선 객체
		System.out.println(myLine.draw());
		System.out.println(myLine);
		
		MyCircle myCircle = new MyCircle(4, 4, 20);
		System.out.println(myCircle.draw());
		System.out.println(myCircle);
		
		MyLine[] lines = new MyLine[100];
		int lineCount = 0; // 저장될 위치, 저장된 개수
		
		// 저장
		lines[lineCount++] = new MyLine(0, 0, 1, 1);
		lines[lineCount++] = new MyLine(3, 3, 9, 9);
		lines[lineCount++] = new MyLine(6, 6, 19, 19);
		lines[lineCount++] = new MyLine(9, 9, 29, 29);
		
		// 저장된 개수 출력
		System.out.println("Line 개수 : " + lineCount);
		
		// 검색(시작 좌표로 검색)
		int findX = 3, findY = 3; // 찾으려는 대상의 좌표
		int findIndex = -1; // 찾으려난 대상의 위치
		for(int i=0; i<lineCount; i++) {
			MyLine line = lines[i];
			
			// 저장된 객체의 x, y가 찾으려는 좌표와 같으면 찾으려는 인덱스 값을 현재 인덱스 값으로 변경 후 break
			if(findX == line.getX() && findY == line.getY()) {
				findIndex = i;
				break;
			}
		} // end for
		
		System.out.println(findIndex == -1 ? "못찾음" : findIndex + "번 인덱스에서 찾음");
	}
}

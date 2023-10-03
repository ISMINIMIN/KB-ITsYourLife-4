package 그림판;

import 그림판.service.MyShapeListService;

public class PainterServiceListExam {
	public static void main(String[] args) {
		// 도형을 관리할 객체 생성
		MyShapeListService myShapeService = new MyShapeListService();
		
		
		myShapeService.add(new MyLine(0, 0, 3, 3));
		myShapeService.add(new MyLine(3, 3, 9, 9));
		myShapeService.add(new MyLine(6, 6, 19, 19));
		myShapeService.add(new MyLine(9, 9, 29, 29));
		
		myShapeService.add(new MyCircle(0, 0, 1));
		
		System.out.println("저장 개수 : " + myShapeService.getCount());
		
		// 검색 - 시작 좌표로 검색, 반환 타입 : 객체의 참조값
		MyShape findShape = myShapeService.findMyPosition(3, 3);
		if(findShape == null) {
			System.out.println("못찾음");
		} else {
			System.out.println("찾음 : " + findShape);
		}
		
		// 삭제
		boolean result = myShapeService.remove(findShape);
		if(!result) {
			System.out.println("삭제 실패");
		} else {
			System.out.println("삭제 성공");
		}
		
		myShapeService.printAll();
	}
}

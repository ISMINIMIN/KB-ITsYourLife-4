package 그림판;

public class PainterExam2 {
	public static void main(String[] args) {
//		MyLine[] lines = new MyLine[100];
//		MyCircle[] circles = new MyCircle[100];
//		
		MyLine myLine = new MyLine(0, 0, 0, 0);
		MyCircle myCircle = new MyCircle(0, 0, 1);
		
		// 업캐스팅
		MyShape[] myShape = new MyShape[100];
		myShape[0] = myLine;
		myShape[1] = myCircle;
		
		MyShape shape  = new MyCircle(0, 0, 1);
		// 오버라이딩한 자식의 메서드가 호출
		System.out.println(shape.draw());
		System.out.println(shape);
	}
}

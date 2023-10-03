package Review;

public class R06_추상클래스 {
	public static void main(String[] args) {
		R06_MyCircle circle = new R06_MyCircle(1, 1, 3);
		circle.startDraw(); // MyShape의 메소드
		circle.draw();
	}
}
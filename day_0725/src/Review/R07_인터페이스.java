package Review;

public class R07_인터페이스 {
	public static void main(String[] args) {
		R07_MyCircle myCircle = new R07_MyCircle(1, 1, 3);
		R07_MyShape myShape = myCircle;
		myCircle.draw();
		// R06_MyShape에는 draw 함수가 선언되어 있지 않기 때문에 호출 불가
		// myShape.draw();
		
		// R07_MyDrawable(인터페이스) 타입으로 접근하는 경우 draw 함수에만 접근할 수 있음
		R07_MyDrawable myDrawable = myCircle;
		myDrawable.draw();
		
		R07_MyLine myLine = new R07_MyLine(1, 1, 3, 3);
		R07_MyDrawable myDrawable2 = myLine;
		myDrawable2.draw();
		
		R07_MyDrawable[] mdArr = new R07_MyDrawable[3];
		mdArr[0] = new R07_MyLine(0, 0, 3, 3);
		mdArr[1] = new R07_MyCircle(5, 5, 9);
		mdArr[2] = new R07_Student("홍길도", "컴공");
		
		// draw 함수만 접근 가능
		mdArr[0].draw();
		mdArr[1].draw();
		mdArr[2].draw();
	}
}
package 그림판;

/** 도형들의 부모 클래스 : 공통 변수와 메서드를 정의 */

public class MyShape {
	private int x, y;
	
	// 생성자 메서드(기본, 모든 멤버를 매개변수로 받는 생성자)
	public MyShape() {
		
	}

	
	public MyShape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	
	// Getter & Setter
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public String draw() {
		return "";
	}


	// toString()
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}
}

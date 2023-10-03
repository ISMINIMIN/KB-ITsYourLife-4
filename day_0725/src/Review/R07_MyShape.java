package Review;

public class R07_MyShape {
	private int x, y;
	
	// 생성자
	public R07_MyShape() {
		
	}
	
	public R07_MyShape(int x, int y) {
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

	// toString()
	@Override
	public String toString() {
		return "x : " + x + ", y : " + y;
	}
}
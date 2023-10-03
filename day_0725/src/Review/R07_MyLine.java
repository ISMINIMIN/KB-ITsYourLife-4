package Review;

public class R07_MyLine extends R07_MyShape implements R07_MyDrawable {
	private int x2, y2;
	
	// 생성자
	public R07_MyLine() {
		
	}
	
	public R07_MyLine(int x, int y, int x2, int y2) {
		super(x, y);
		this.x2 = x2;
		this.y2 = y2;
	}

	// Getter & Setter
	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	// toString()
	@Override
	public String toString() {
		return super.toString() + ", x2=" + x2 + ", y2=" + y2;
	}

	@Override
	public void draw() {
		System.out.println("draw Line");
	}
}
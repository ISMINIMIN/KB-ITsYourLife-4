package 그림판;

public class MyCircle extends MyShape {
	private int radius;
	
	// 생성자
	public MyCircle() {
		
	}

	public MyCircle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	// Getter & Setter
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public String draw() {
		return "CIRCLE";
	}

	// toString()
	@Override
	public String toString() {
		return super.toString() + ", radius=" + radius;
	}
}

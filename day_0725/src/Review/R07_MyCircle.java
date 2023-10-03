package Review;

public class R07_MyCircle extends R07_MyShape implements R07_MyDrawable {
	private int radius;
	
	// 생성자
	public R07_MyCircle() {
		
	}
	
	public R07_MyCircle(int x, int y, int radius) {
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

	// toString()
	@Override
	public String toString() {
		return super.toString() + ", radius=" + radius;
	}

	@Override
	public void draw() {
		System.out.println("draw Circle");
	}
}
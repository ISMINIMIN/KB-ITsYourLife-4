package Review;

//추상 클래스를 상속받은 클래스는 추상 메소드를 반드시 재정의(오버라이딩) 필요
class R06_MyCircle extends R06_MyShape {
	private int radius;
	
	// 생성자
	public R06_MyCircle() {
		
	}
	
	public R06_MyCircle(int x, int y, int radius) {
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
		return "radius=" + radius;
	}

	// 부모 클래스의 추상 메소드 재정의
	@Override
	void draw() {
		System.out.println("반지름이 " + radius + "인 동그라미");
	}
}
package Review;

//추상 메소드를 하나라도 가지고 있는 경우 추상 클래스로 선언해야 하며 추상 메소드가 아닌 메소드를 가질 수 있음
abstract class R06_MyShape {
	private int x, y;
	
	// 생성자
	public R06_MyShape() {
		
	}
	
	public R06_MyShape(int x, int y) {
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

	// 추상 메소드
	abstract void draw(); // 그리는 모양은 부모 클래스에서 정하지 못하므로 추상 클래스로 선언하여 추상 메소드 생성
	
	void startDraw() {
		System.out.println("(" + x + ", " + y + ") 지점에서 시작합니다.");
	}
}
package Review;

// 파이널 메소드는 오버라이딩이 불가능하며 파이널 클래스는 상속이 불가능함

public class R05_파이널 {
	final int I = 100;
	int j = 200;
	
	final int AGE;
	
	public R05_파이널(int AGE) {
		// 파이널 변수는 초기화 이후 값 변경 불가능
		// this.I = 300;
		this.j = 500;
		// 파이널 변수를 외부에서 전달된 값으로 초기화하고 싶다면 생성자에서 초기화 가능
		this.AGE = AGE;
	}
	
	public static void main(String[] args) {
		R05_파이널 r05_파이널 = new R05_파이널(5);
		System.out.println(r05_파이널.I);
		System.out.println(r05_파이널.j);
		System.out.println(r05_파이널.AGE);
		
		r05_파이널.j = 300;
		// 파이널 변수는 값을 변경할 수 없음
		// r05_파이널.AGE = 10;
		
		System.out.println(Math.PI);
	}
}

package Review;

public class R03_메소드오버로딩과오버라이딩 {
	// 메소드 매개변수의 타입이 같기 때문에 오버로딩 불가
	// 오버로딩의 경우 매개변수 타입, 개수, 순서가 달라야 적용 가능
	// 매개변수가 동일한 경우 오버라이딩 적용
	// static void a() {}
	// static int a() {}
	
	// 매개변수가 동일하고 메소드 이름이 같으므로 오버라이딩을 적용해야하지만 상속관계가 아니므로 오류 발생
	// 오버라이딩의 경우 매개변수와 리턴타입이 동일
	// public void a() {}
	// public static void a() {}
	
	// 오버로딩
	public void a(int a) {}
	public void a(boolean b) {}
	public void a(int a, int b) {}
	public int a(String s) {
		return Integer.parseInt(s);
	}
}

package Review;

public class R01_타입변환 {
	public static void main(String[] args) {
		int i = 100;
		long l = 200;
		float f1 = i; // 자동 타입 변환
		float f2 = l; // 자동 타입 변환
		long l2 = (long)f2; // 강제 타입 변환
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(l2);
		
		// boolean 타입은 숫자형이 아니기 때문에 강제 타입 변환 불가
		// boolean b = (boolean)i;
		
		// 객체 또한 숫자형으로 강제 타입 변환 불가, 타입 변환을 원하는 경우 Wrapper 클래스 사용 필요
		// String s = (String)i;
		
		// 연산 결과가 double 타입이기 때문에 int 타입 변수에 저장 불가
		// int j = 1.0 + 2;
		int j = (int)1.5 * 2;
		int k = (int)(1.5 * 2);
		System.out.println(j);
		System.out.println(k);
		
		double d = 1.5 * 2;
		System.out.println(d);
	}
}

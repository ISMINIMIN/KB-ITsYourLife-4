package Review;

public class R02_지역변수와멤버변수 {
	// 초기값을 제공하지 않을 경우 필드는 객체 생성 시 자동으로 기본값으로 초기화
	static int i; // 멤버변수(필드), 기본값 : 0
	static String str1; // 기본값 : null
	
	public static void main(String[] args) {
		int j; // 지역(로컬)변수, 초기화하지 않았기 때문에 사용 불가능
		int k = 0; // 명시적으로 초기화하였기 때문에 사용 가능
		String str2;
		
		System.out.println(i);
		// 지역변수는 자동으로 초기화되지 않기 때문에 초기화 필요, 초기화하지 않은 경우 사용 불가
		// System.out.println(j);
		System.out.println(k);
		
		System.out.println(str1);
		// System.out.println(str2);
	}
}

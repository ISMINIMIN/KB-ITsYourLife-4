package Review;

public class R04_정적멤버 {
	int i = 100;
	static int j = 200;
	
	public static void main(String[] args) {
		// 정적 멤버가 아니므로 객체를 생성한 후 사용 가능
		// System.out.println(i);
		
		R04_정적멤버 r04_정적멤버 = new R04_정적멤버();
		System.out.println(r04_정적멤버.i);
		
		// 정적 멤버는 객체를 생성할 필요 없이 클래스를 통해 바로 사용이 가능함
		System.out.println(j);
		System.out.println(R04_정적멤버.j);
	}
}

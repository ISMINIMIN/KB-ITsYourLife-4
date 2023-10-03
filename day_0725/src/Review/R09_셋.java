package Review;

import java.util.HashSet;

public class R09_셋 {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("홍");
		hashSet.add("김");
		hashSet.add("박");
		hashSet.add("홍");
		System.out.println(hashSet);
		
		hashSet.remove("김");
		System.out.println(hashSet);
	}
}

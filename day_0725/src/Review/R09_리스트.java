package Review;

import java.util.ArrayList;

public class R09_리스트 {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("홍");
		arrayList.add("김");
		arrayList.add("박");
		System.out.println(arrayList);
		
		arrayList.add(1, "최");
		System.out.println(arrayList);
		
		arrayList.set(1, "강");
		System.out.println(arrayList);
		
		System.out.println(arrayList.get(2));
		
		arrayList.remove(0);
		System.out.println(arrayList);
		arrayList.remove("김");
		System.out.println(arrayList);
	}
}

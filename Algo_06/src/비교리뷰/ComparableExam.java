package 비교리뷰;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparableExam {
	
	static class Person implements Comparable<Person> {
		String name;
		int age;
		
		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		public int compareTo(Person o) {
			// 음수 : this 선순위, 양수 : this가 후순위, 0 : 동일순위
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return name;
		}
	} // end Person
	
	static class NameComparator implements Comparator<Person> {

		@Override
		public int compare(Person o1, Person o2) {
			// 음수 : o1 선순위, 양수 : o1가 후순위, 0 : 동일순위
			return o1.name.compareTo(o2.name);
		}
		
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("홍길동", 30);
		Person p2 = new Person("김길동", 35);
		System.out.println(p1.compareTo(p2));
		
		ArrayList<Person> arr = new ArrayList<>();
		arr.add(p2);
		arr.add(p1);
		System.out.println(arr);
		
		Collections.sort(arr);
		System.out.println(arr);
		
		Collections.sort(arr, new NameComparator());
		System.out.println(arr);
	}
}

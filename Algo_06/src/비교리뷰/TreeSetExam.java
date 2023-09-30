package 비교리뷰;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetExam {
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(30);
		treeSet.add(100);
		treeSet.add(200);
		treeSet.add(200);
		
		ArrayList<Integer> list = new ArrayList<>(treeSet);
		System.out.println(list);
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(30);
		hashSet.add(100);
		hashSet.add(200);
		hashSet.add(200);
		list = new ArrayList<>(hashSet);
		System.out.println(list);
	}
}

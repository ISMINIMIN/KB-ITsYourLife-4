package B2661_좋은수열;

import java.util.Scanner;

public class Main {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();

		makeStr("");
	}

	private static void makeStr(String str) {
		if(str.length() == N) {
			System.out.println(str);
			System.exit(0);
		}
		
		for(int i=1; i<=3; i++) {
			if(checkStr(str + i)) makeStr(str + i);
		}
	}

	private static boolean checkStr(String str) {
		int len = str.length() / 2;
		
		for(int i=1; i<=len; i++) {
			if(str.substring(str.length()-i).equals(str.substring(str.length()-i*2, str.length()-i))) {
				return false;
			}
		}
		return true;
	}
}

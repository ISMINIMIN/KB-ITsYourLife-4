package 재귀호출;

import java.util.Scanner;

public class 팩토리얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int N = sc.nextInt();
		int answer = factorial(N);
		System.out.println(answer);
	}

	private static int factorial(int n) {
		// 종료조건
		if(n == 0) return 1;
		// 처리조건
		return n * factorial(n-1);
	}
}

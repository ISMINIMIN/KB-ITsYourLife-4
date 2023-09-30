package J2750_과자;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // 과자 한 개 가격
		int N = sc.nextInt(); // 사려고 하는 과자 개수
		int M = sc.nextInt(); // 현재 가진 돈의 액수
		
		int answer = K * N - M;
		
		if(answer >= 0)
			System.out.println(answer);
		else
			System.out.println("0");
	}
}

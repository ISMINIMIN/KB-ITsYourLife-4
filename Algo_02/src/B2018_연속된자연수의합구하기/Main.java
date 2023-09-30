package B2018_연속된자연수의합구하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int start = 1;
		int end = 1;
		int sum = 1;
		int count = 1;
		int midNum = N/2 + N%2;
		
		while(start < midNum) {
			if(sum > N) {
				sum -= start;
				start++;
			} else if(sum < N) {
				end++;
				sum += end;
			} else {
				end++;
				sum += end;
				count++;
			}
		}
		
		System.out.println(count);
	}
}

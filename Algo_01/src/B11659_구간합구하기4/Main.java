package B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 합의 개수
		
		int[] sum = new int[N+1]; // 합 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken()); // 이전 합 + 현재 입력 숫자
		}
		
		// 합의 개수만큼 연산
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(sum[end] - sum[start-1]);
		}
	}
}

//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		
//		int[] nums = new int[N+1];
//		
//		for(int i=1; i<=N; i++) {
//			nums[i] = nums[i-1] + sc.nextInt();
//		}
//		
//		for(int i=0; i<M; i++) {
//			int start = sc.nextInt();
//			int end = sc.nextInt();
//			System.out.println(nums[end] - nums[start-1]);
//		}
//	}
//}

//시간 초과
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		
//		int[] nums = new int[N+1];
//		
//		for(int i=1; i<=N; i++) {
//			nums[i] = sc.nextInt();
//		}
//		
//		for(int i=0; i<M; i++) {
//			int start = sc.nextInt();
//			int end = sc.nextInt();
//			int sum = 0;
//			
//			for(int j = start; j<=end; j++) {
//				sum += nums[j];
//			}
//			
//			System.out.println(sum);
//		}
//	}
//}

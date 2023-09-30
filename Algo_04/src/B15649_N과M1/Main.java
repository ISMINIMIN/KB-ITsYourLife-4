package B15649_N과M1;

import java.util.Scanner;

public class Main {
	static int M; // 정답 길이
	static int[] nums; // 원소 배열
	static int[] result; // 정답 배열
	static boolean[] visited; // 숫자 사용 여부 확인 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		// 원소 배열에 1부터 N까지의 숫자 저장
		for(int i=1; i<=N; i++) {
			nums[i-1] = i;
		}
		
		// 재귀 호출(깊이 0)
		recursive(0);
	}

	private static void recursive(int depth) {
		// 종료조건
		// 깊이가 정답 길이와 같아지면 정답 출력
		if(depth == M) {
			printResult();
			return;
		}
		
		// 처리코드
		for(int i=0; i<nums.length; i++) {
			if(!visited[i]) { // 원소가 사용되지 않은 경우
				result[depth] = nums[i]; // 정답 배열에 숫자 저장
				visited[i] = true; // 숫자를 사용하였으므로 사용(true)으로 상태 저장
				recursive(depth+1); // 깊이를 증가하여 재귀 호출
				visited[i] = false; // 재귀를 빠져나올 때 숫자 미사용(false)으로 상태 변환
			}
		}
	}

	// 정답 출력
	private static void printResult() {
		// 0번째 인덱스부터 M-2번째 인덱스 까지 오른쪽에 공백 포함하여 출력
		for(int i=0; i<M-1; i++) {
			System.out.print(result[i] + " ");
		}
		// 마지막 원소는 오른쪽에 공백 포함하지 않고 출력 후 줄 바꿈
		System.out.println(result[M-1]);
	}
}

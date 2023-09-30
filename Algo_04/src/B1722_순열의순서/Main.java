package B1722_순열의순서;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 순열의 자릿수
		int Q = sc.nextInt(); // 소문제 번호
		
		int[] factorial = new int[N+1]; // 자리별 조합 가능한 경우의 수 배열
		boolean[] visited = new boolean[N+1]; // 숫자 사용 여부 확인 배열
		
		factorial[0] = 1;
		for(int i=1; i<=N; i++) {
			factorial[i] = factorial[i-1] * i;
		}
		
		if(Q == 1) { // 소문제 번호가 1일 때
			int K = sc.nextInt(); // 찾아야하는 순열 순서
			int[] result = new int[N+1]; // 정답 배열
			
			for(int idx=1; idx<=N; idx++) { // result 배열의 인덱스
				int count = 1;
				
				for(int num=1; num<=N; num++) { // 원소
					if(visited[num]) // 원소를 사용한 경우 다음 원소로 이동
						continue;
					
					if(K <= factorial[N-idx] * count) { 
						K -= factorial[N-idx] * (count - 1);
						result[idx] = num; // result 배열에 현재 원소 저장
						visited[num] = true; // 원소를 사용하였으므로 사용 상태 true로 변경
						break; // result 배열 자리에 원소를 넣었으므로 종료 후 다음 자리로 넘어감
					}
					
					count++;
				}
			}
			
			// result 배열 출력
			for(int i=1; i<=N; i++) {
				System.out.print(result[i] + " ");
			}
		} else {
			int[] result = new int[N+1]; // 순열의 원소 배열
			int K = 1;
			
			for(int idx=1; idx<=N; idx++) { // result 배열의 인덱스
				result[idx] = sc.nextInt(); // 원소 입력받음
				int count = 0; // 미사용 원소 개수
				
				for(int num=1; num<result[idx]; num++) {
					if(!visited[num]) {
						count++;
					}
				}
				
				K += factorial[N-idx] * count;
				visited[idx] = true;
			}
			
			System.out.println(K);
		}
	}
}

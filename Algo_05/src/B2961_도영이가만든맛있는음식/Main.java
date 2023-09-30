package B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long min = Integer.MAX_VALUE; // 신맛과 쓴맛 차이의 최솟값
	static int N; // 재료의 개수
	static int[][] SB; // 재료의 신맛과 쓴맛을 담은 2차원 배열
	static boolean[] visited; // 재료 사용 여부 확인 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 재로 개수 입력 받음
		
		visited = new boolean[N];
		SB = new int[N][2];
		for(int i=0; i<N; i++) { // 각 재료의 신맛과 쓴맛을 배열에 저장
			st = new StringTokenizer(br.readLine());
			SB[i][0] = Integer.parseInt(st.nextToken()); // 재료의 신맛은 0번째 인덱스에 저장
			SB[i][1] = Integer.parseInt(st.nextToken()); // 재료의 쓴맛은 1번째 인덱스에 저장
		}
		
		powerSet(0); // 재귀 호출
		
		System.out.println(min); // 최솟값 출력
	}
	
	private static void powerSet(int depth) {
		// 종료조건
		if(depth == N) {
			checkMin(); // 현재의 조합이 최솟값인지 확인하는 함수 호출
			return;
		}
		
		// 처리코드
		visited[depth] = false;
		powerSet(depth+1);
		
		visited[depth] = true;
		powerSet(depth+1);
	}
	
	private static void checkMin() {
		long ST = 1; // 선택된 재료들의 신맛을 곱한 합계값(신맛은 곱해야하므로 1로 초기화)
		long BT = 0; // 선택된 재료들의 쓴맛을 합한 합계값(쓴맛은 합해야하므로 0으로 초기화)
		
		for(int i=0; i<N; i++) {
			if(visited[i]) { // 재료가 선택된 경우
				ST *= SB[i][0]; // 신맛은 곱
				BT += SB[i][1]; // 쓴맛은 합
			}
		}
		
		if(ST != 1 && BT != 0) { // 재료를 적어도 하나 이상 사용한 경우
			min = Math.min(Math.abs(ST - BT), min);
		}
	}
}

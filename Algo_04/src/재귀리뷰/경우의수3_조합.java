package 재귀리뷰;

public class 경우의수3_조합 {
	static int N; // 답의 길이
	static int[] arr; // 원소 배열
	static int[] result; // 답 저장 배열
	static boolean[] visited; // 원소 사용 여부 확인 배열
	
	public static void main(String[] args) {
		// 원소 {1, 2, 3}에 대한 숫자 조합(중복 배제, 순서 고려)
		
		N = 2; // 출력할 숫자 조합 길이
		arr = new int[] {1, 2, 3}; // 반복할 숫자
		result = new int[N]; // 정답 저장할 배열
		visited = new boolean[arr.length];
		
		recursive(0, 0); // 깊이 0, 시작 위치 0 전달
	}

	private static void recursive(int depth, int start) {
		// 종료조건
		if(depth == N) { // 깊이와 답 길이가 동일하면 답 출력
			printResult();
			return;
		}
		
		// 처리코드(result에 숫자 누적)
		for(int i=start; i<arr.length; i++) {
			// arr[i] 숫자가 미사용인 경우에만 사용
			if(!visited[i]) {
				result[depth] = arr[i]; // 인덱스가 깊이와 같은 자리에 원소 배열 i번째 숫자 저장
				visited[i] = true;
				recursive(depth+1, i+1); // 깊이 증가, 시작위치 증가 후 재귀 호출
				visited[i] = false;
			}
		}
	}

	// 답 출력
	private static void printResult() {
		for(int i : result) { // result에서 순서대로 추출
			System.out.print(i); // 줄바꿈 하지 않고 붙여서 출력
		}
		System.out.println(); // 줄바꿈
	}
}

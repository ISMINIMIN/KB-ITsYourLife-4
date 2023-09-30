package 재귀리뷰;

public class 경우의수 {
	static int N; // 답의 길이
	static int[] arr; // 원소 배열
	static int[] result; // 답 저장 배열
	
	public static void main(String[] args) {
		// 원소 {1, 2, 3}에 대한 모든 숫자 조합
		
		N = 3; // 출력할 숫자 조합 길이
		arr = new int[] {1, 2, 3}; // 반복할 숫자
		result = new int[N]; // 정답 저장할 배열
		
		recursive(0); // 깊이 0 전달
	}

	private static void recursive(int depth) {
		// 종료조건
		if(depth == N) { // 깊이와 답 길이가 동일하면 답 출력
			printResult();
			return;
		}
		
		// 처리코드(result에 숫자 누적)
		for(int i=0; i<arr.length; i++) {
			result[depth] = arr[i]; // 인덱스가 깊이와 같은 자리에 원소 배열 i번째 숫자 저장
			recursive(depth+1); // 깊이 증가 후 재귀 호출
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

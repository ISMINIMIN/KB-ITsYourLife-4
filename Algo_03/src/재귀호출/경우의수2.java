package 재귀호출;

public class 경우의수2 {
	static int N;
	static int[] arr, result;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// 주어진 원소를 이용한 생성 가능한 모든 경우의 수
		// {1, 2} 중복 사용 불가능 : 12, 21
		
		N = 3; // 답의 길이(추출 개수)
		
		arr = new int[] {1, 2, 3}; // 원소 저장 배열
		visited = new boolean[arr.length];
		result = new int[N]; // 답 저장 배열
		
		recursive(0);
	}

	private static void recursive(int depth) {
		// 종료조건
		if(depth == N) {
			print();
			return;
		}
		
		// 처리조건(깊이의 숫자 위치에 i 값을 저장)
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				result[depth] = arr[i];
				visited[i] = true;
				recursive(depth+1);
				visited[i] = false;
			}
		}
	}

	private static void print() {
		for(int i : result) {
			System.out.print(i);
		}
		System.out.println();
	}
}

package B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // 찾아야하는 순서
	static int count; // 만든 문자열 순서
	static String str; // 입력받은 문자열
	static char arr[]; // 문자열의 원소 배열
	static char result[]; // 정답 배열
	static boolean visited[]; // 원소 사용 여부 확인 배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line; // 라인 단위로 입력 받음
		
		// 입력한 라인이 없을 때까지 반복
		while((line = br.readLine()) != null) {
			count = 0; // 테스트케이스마다 순서 0으로 초기화
			StringTokenizer st = new StringTokenizer(line);
			str = st.nextToken(); // 입력받은 문자열
			arr = str.toCharArray(); // 문자열을 문자 단위로 쪼개서 배열에 저장
			N = Integer.parseInt(st.nextToken()); // 입력받은 순서
			
			result = new char[arr.length]; // 정답 배열 초기화
			visited = new boolean[arr.length]; // 사용 여부 확인 배열 초기화
			
			// N(입력받은 순서)가 조합 개수를 벗어나는 경우 "No permutation" 출력
			// N(입력받은 순서)가 조합 개수를 벗어나지 않는 경우 재귀 호출
			if(factorial(arr.length) < N) {
				System.out.println(str + " " + N + " = " + "No permutation");
			} else {
				recursive(0); // 재귀 호출(깊이 0)
			}
		}
	}

	// 조합 개수를 반환하는 함수
	private static int factorial(int n) {
		if(n == 0) return 1;
		return n * factorial(n-1);
	}

	// 재귀함수
	private static void recursive(int depth) {
		// 종료조건
		// 깊이가 입력받은 문자열의 길이와 같아지면 순서 증가
		if(depth == arr.length) {
			count++;
			// 현재 순서가 찾아야하는 순서와 같아지면 출력
			if(count == N) {
				printResult();
				return;
			}
			return;
		}
		
		// 처리코드
		for(int i=0; i<arr.length && count != N; i++) {
			if(!visited[i]) { // 원소를 사용하지 않은 경우
				result[depth] = arr[i]; // 인덱스가 깊이와 같은 자리에 원소 배열 i번째 문자 저장
				visited[i] = true; // 원소를 사용하였으므로 사용(ture) 상태 저장
				recursive(depth+1); // 깊이 증가해서 재귀 호출
				visited[i] = false; // 재귀를 빠져나올 때 다시 원소를 사용해야하므로 미사용(false)으로 상태 변환
			}
		}
	}

	// 현재 정답 배열에 있는 원소들을 문자열로 출력하는 함수
	private static void printResult() {
		StringBuilder sb = new StringBuilder();
		for(char c : result)
			sb.append(c);
		System.out.println(str + " " + N + " = " + sb.toString());
	}
}

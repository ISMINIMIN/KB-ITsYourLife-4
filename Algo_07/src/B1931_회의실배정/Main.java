package B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] times = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 끝나는 시간을 기준으로 오름차순 정렬, 끝나는 시간이 같은 경우 시작 시간을 기준으로 오름차순 정렬
		Arrays.sort(times, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		int count = 0;
		int endTime = -1; // 시작 시간과 끝나는 시간의 최솟값이 0이므로 -1로 초기화
		
		for(int i=0; i<N; i++) {
			if(endTime <= times[i][0]) { // 끝나는 시간이 시작시간보다 이전인 경우
				count++; // 회의 가능하므로 카운트 증가
				endTime = times[i][1]; // 현재 회의의 끝나는 시간을 저장
			}
		}
		
		System.out.println(count);
	}
}

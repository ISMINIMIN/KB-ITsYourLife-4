package B14501_퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] TP;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		TP = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			TP[i][0] = Integer.parseInt(st.nextToken());
			TP[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0, 0);
	}

	private static void dfs(int depth, int sumK, int sumP) {
		if(depth >= N) {
			max = Math.max(sumP, max);
			return;
		}
		
	}
}

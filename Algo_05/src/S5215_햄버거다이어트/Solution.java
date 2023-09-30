package S5215_햄버거다이어트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, K;
	static int[][] arr;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N][2];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, 0);
			
			System.out.println("#" + t + " " + max);
		}
	}

	private static void dfs(int depth, int sumT, int sumK) {
		if(sumK > K)
			return;
		
		if(depth == N) {
			max = Math.max(sumT, max);
			return;
		}
		
		dfs(depth+1, sumT+arr[depth][0], sumK+arr[depth][1]);
		dfs(depth+1, sumT, sumK);
	}
}

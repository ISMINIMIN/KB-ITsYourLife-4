//시간초과
package B2042_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int sum = 0;
			
			if(type == 1) {
				int idx = Integer.parseInt(st.nextToken());
				int change = Integer.parseInt(st.nextToken());
				nums[idx] = change;
			} else {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				for(int j=start; j<=end; j++) {
					sum += nums[j];
				}
				System.out.println(sum);
			}
		}
	}
}

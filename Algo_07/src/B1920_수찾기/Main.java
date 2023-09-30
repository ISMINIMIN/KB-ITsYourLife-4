package B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int findNum = Integer.parseInt(st.nextToken());
			boolean flag = false;
			int left = 0;
			int right = N-1;
			while(left <= right) {
				int center = (left + right) / 2;
				int value = nums[center];
				if(findNum < value) {
					right = center - 1;
				} else if(findNum > value) {
					left = center + 1;
				} else {
					flag = true;
					break;
				}
			}
			
			if(flag) System.out.println(1);
			else System.out.println(0);
		}
	}
}

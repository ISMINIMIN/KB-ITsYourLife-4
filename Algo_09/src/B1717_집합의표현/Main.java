package B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		for(int i=1; i<N+1; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int task = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(task == 0) {
				union(a, b);
			} else {
				if(check(a, b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}

	private static boolean check(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return true;
		else return false;
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			arr[b] = a;
		}
	}

	private static int find(int a) {
		if(a == arr[a]) return a;
		else return arr[a] = find(arr[a]);
	}
}

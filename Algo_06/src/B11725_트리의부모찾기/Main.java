package B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> tree[];
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		result = new int[N+1];
		
		for(int i=0; i<N+1; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			tree[node1].add(node2);
			tree[node2].add(node1);
		}
		
		dfs(1);
		
		for(int i=2; i<N+1; i++) {
			System.out.println(result[i]);
		}
	}

	private static void dfs(int idx) {
		visited[idx] = true;
		
		for(int i : tree[idx]) {
			if(!visited[i]) {
				result[i] = idx;
				dfs(i);
			}
		}
	}
}

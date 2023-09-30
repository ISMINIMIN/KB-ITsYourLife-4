package B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer> list[];
	static int result = 0;
	static int N, E;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		
		visited = new boolean[N+1];
		
		for(int i=1; i<N+1; i++) {
			if(!visited[i]) {
				result++;
				dfs(i);				
			}
		}
		
		System.out.println(result);
	}

	private static void dfs(int node) {
		if(visited[node]) return;
		
		visited[node] = true;
		for(int i : list[node]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
}

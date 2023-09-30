package B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> tree[];
	static boolean[] visited;
	static int deleteNode;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		for(int i=1; i<N; i++) {
			int node = Integer.parseInt(st.nextToken());
			tree[i].add(node);
			tree[node].add(i);
		}
		
		deleteNode = Integer.parseInt(br.readLine());
		if(deleteNode == 0) {
			System.out.println(0);
		} else {
			dfs(0);
			System.out.println(answer);
		}
	}

	private static void dfs(int node) {
		int count = 0;
		
		visited[node] = true;
		for(int i : tree[node]) {
			if(!visited[i] && i != deleteNode) {
				count++;
				dfs(i);
			}
		}
		
		if(count == 0) {
			answer++;
		}
	}
}

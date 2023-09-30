package B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> list[];
	static boolean[] visited;
	static int N, M, V;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			list[node1].add(node2);
			list[node2].add(node1);
//			Collections.sort(list[node1]);
//			Collections.sort(list[node2]);
		}
		
		for(int i=1; i<N+1; i++) {
			Collections.sort(list[i]);
		}
		
		visited = new boolean[N+1];
		dfs(V);
		
		System.out.println();
		
		visited = new boolean[N+1];
		bfs(V);
	}

	private static void dfs(int node) {
		System.out.print(node + " ");
		visited[node] = true;
		for(int i : list[node]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		visited[node] = true;
		System.out.print(node + " ");
		
		while(!queue.isEmpty()) {
			int currentNode = queue.poll();
			
			for(int i : list[currentNode]) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
}

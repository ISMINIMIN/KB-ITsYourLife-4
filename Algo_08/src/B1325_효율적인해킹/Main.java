package B1325_효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> list[];
	static int N, M;
	static int max = 0;
	static int[] counts;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		counts = new int[N+1];
		list = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[B].add(A);
		}
		
		bfs();
		
		for(int i=1; i<N+1; i++) {
			if(counts[i] == max) System.out.print(i + " ");
		}
	}

	private static void bfs() {
		Queue<Integer> queue;
		boolean[] visited;
		
		for(int node=1; node<N+1; node++) {
			queue = new LinkedList<Integer>();
			visited = new boolean[N+1];
			queue.add(node);
			visited[node] = true;
			int count = 0;
			
			while(!queue.isEmpty()) {
				int currentNode = queue.poll();
				
				for(int i : list[currentNode]) {
					if(!visited[i]) {
						queue.add(i);
						visited[i] = true;
						count++;
					}
				}
			}
			
			counts[node] = count;
			if(max < count) max = count;
		}
	}
}

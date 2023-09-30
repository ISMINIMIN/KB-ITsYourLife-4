package B1012_유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int M, N, K;
	static int[][] farm;
	static boolean[][] visited;
	
	static class Node {
		int y;
		int x;
		
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=0; t<TC; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이
			K = Integer.parseInt(st.nextToken()); // 배추개수
			
			farm = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[y][x] = 1; 
			}
			
			int count = 0;
			for(int y=0; y<N; y++) {
				for(int x=0; x<M; x++) {
					if(!visited[y][x] && farm[y][x] == 1) {
						count++;
						bfs(y, x);
					}
				}
			}
			
			System.out.println(count);
		}
	}

	private static void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(inRange(ny, nx) && !visited[ny][nx] && farm[ny][nx] == 1) {
					queue.add(new Node(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
	}

	private static boolean inRange(int ny, int nx) {
		if(ny >= 0 && nx >= 0 && ny < N && nx < M) return true;
		else return false;
	}
}

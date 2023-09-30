package B7562_나이트의이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static int N, endY, endX;
	static int[][] map;
	static boolean[][] visited;
	
	static class Node {
		int y;
		int x;
		int count;
		
		public Node(int y, int x, int count) {
			super();
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=0; t<TC; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			endY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			
			bfs(startY, startX);
			
		}
	}

	private static void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x, 0));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.y == endY && node.x == endX) {
				System.out.println(node.count);
				break;
			}
			
			for(int i=0; i<8; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(inRange(ny, nx) && !visited[ny][nx]) {
					queue.add(new Node(ny, nx, node.count+1));
					visited[ny][nx] = true;
				}
			}
		}
	}

	private static boolean inRange(int ny, int nx) {
		if(ny >= 0 && nx >= 0 && ny < N && nx < N) return true;
		return false;
	}
}

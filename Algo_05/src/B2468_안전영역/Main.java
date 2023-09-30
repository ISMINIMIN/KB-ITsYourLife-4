package B2468_안전영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = 0;
	static int N;
	static int[][] map;
	static boolean[][] check;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		int maxHeigth = 0;
		int maxCount = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > maxHeigth)
					maxHeigth = map[i][j];
			}
		}
		
		for(int h=0; h<=maxHeigth; h++) {
			check = new boolean[N][N];
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!check[i][j] && map[i][j] > h) {
						count += dfs(i, j, h);
					}
				}
			}
			
			maxCount = Math.max(count, maxCount);
		}
		
		System.out.println(maxCount);
	}

	private static int dfs(int y, int x, int h) {
		check[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >=0 && nx >= 0 && ny < N && nx < N && !check[ny][nx] && map[ny][nx] > h) {
				check[ny][nx] = true;
				dfs(ny, nx, h);
			}
		}
		
		return 1;
	}
}

package S1210_Ladder1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int TC = Integer.parseInt(st.nextToken());
			
			int row = 99;
			int col = 0;
			
			int[][] map = new int[100][102];
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						col = j;
					}
				}
			}

			while(row > 0) {
				if(col-1 >= 0 && col-1 < 100 && map[row][col-1] == 1) {
					map[row][col] = 0;
					col -= 1;
				} else if(col+1 >= 0 && col+1 < 100 && map[row][col+1] == 1) {
					map[row][col] = 0;
					col += 1;
				} else {
					row--;
				}
			}
			
			System.out.println("#" + TC + " " + (col-1));
		}
	}
}

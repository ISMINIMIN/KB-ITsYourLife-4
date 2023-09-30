package S2806_NQueen;

import java.util.Scanner;

public class Solution {
	static int[] board;
	static int answer, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			N = sc.nextInt();
			board = new int[N];
			answer = 0;
			dfs(0);
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void dfs(int depth) {
		boolean check;
		if(depth == N) {
			answer++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			check = true;
			for(int j=0; j<depth; j++) {
				if(board[j] == i || i == board[j]+(depth-j) || i == board[j]-(depth-j)) {
					check = false;
					break;
				}
			}
			
			if(check) {
				board[depth] = i;
				dfs(depth+1);
			}
		}
	}
}

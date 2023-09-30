package B1697_숨바꼭질;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] multi = {1, 1, 2};
	static int[] plusMinus = {1, -1, 0};
	
	static int N, K;
	static boolean[] visited;
	
	static class Node {
		int location;
		int count;
		
		public Node(int location, int count) {
			super();
			this.location = location;
			this.count = count;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		visited = new boolean[100001];
		
		bfs(N);
	}

	private static void bfs(int n) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(n, 0));
		visited[n] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.location == K) {
				System.out.println(node.count);
				break;
			}
			
			for(int i=0; i<3; i++) {
				int nextLocation = node.location * multi[i] + plusMinus[i];
				
				if(inRange(nextLocation) && !visited[nextLocation]) {
					queue.add(new Node(nextLocation, node.count+1));
					visited[nextLocation] = true;
				}
			}
		}
	}

	private static boolean inRange(int nextLocation) {
		if(nextLocation >= 0 && nextLocation <= 100000) return true;
		return false;
	}
}

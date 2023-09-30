package S1232_사칙연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hint {
	static class Node {
		int value; // 노드 값
		String opr; // 노드 연산자
		int left, right; // 자식 노드 번호
		
		public Node(int value) {
			super();
			this.value = value;
			this.opr = "";
		}
		
		public Node(int value, String opr, int left, int right) {
			super();
			this.value = value;
			this.opr = opr;
			this.left = left;
			this.right = right;
		}
	}
	
	static Node[] nodes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			nodes = new Node[N+1];
			for(int i=1; i<N+1; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				String str = st.nextToken();
				if(st.hasMoreTokens()) {
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					nodes[num] = new Node(0, str, left, right);
				} else {
					nodes[num] = new Node(Integer.parseInt(str));					
				}
			}
			
			int answer = calc(nodes[1]);
			System.out.println("#" + t + " " + answer);
		}
	}

	private static int calc(Node node) {
		String opr = node.opr;
		
		if(opr.equals("-")) {
			return calc(nodes[node.left]) - calc(nodes[node.right]);
		} else if(opr.equals("+")) {
			return calc(nodes[node.left]) + calc(nodes[node.right]);
		} else if(opr.equals("*")) {
			return calc(nodes[node.left]) * calc(nodes[node.right]);	
		} else if(opr.equals("/")) {
			return calc(nodes[node.left]) / calc(nodes[node.right]);			
		} else {
			return node.value;
		}
	}
}

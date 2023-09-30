package B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 막대기 개수
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		int max = 0;
		int count = 0;
		
		// stack이 비어있을 때까지 반복
		while(!stack.isEmpty()) {
			// 현재 막대기 길이
			int current = stack.pop();
			// 현재 막대기가 max 보다 크면 현재 값이 max 값이 되고 count++
			if(current > max) {
				count++;
				max = current;
			}
		}
		
		System.out.println(count);
	}
}
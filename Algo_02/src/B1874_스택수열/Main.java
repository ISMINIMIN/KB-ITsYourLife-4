package B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = 0;
		int count = 1;
		
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		
		while(idx < N) {
			// 스택이 비어있을 때
			if(stack.isEmpty()) {
				stack.push(count++);
				sb.append("+\n");
			}
			
			// 빼야할 숫자가 스택에 들어있는 숫자보다 클 때 빼야할 숫자까지 삽입 
			if(nums[idx] >= count) {
				stack.push(count++);
				sb.append("+\n");
			}
			
			// 스택의 맨 위 값이 빼야할 숫자와 같으면 삭제, 다음 숫자를 비교하기 위해 idx++
			// 스택의 맨 위 값이 빼야할 숫자보다 크면 연산 불가능하므로 break
			if(stack.peek() == nums[idx]) {
				stack.pop();
				idx++;
				sb.append("-\n");
			} else if(stack.peek() > nums[idx]) {
				flag = false;
				break;
			}
		}
		
		if(flag) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}
}

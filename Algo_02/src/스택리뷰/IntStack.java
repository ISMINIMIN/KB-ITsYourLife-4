package 스택리뷰;

import 스택리뷰.IntStack.EmptyIntStackException;
import 스택리뷰.IntStack.OverflowIntStackException;

public class IntStack {
	public class OverflowIntStackException extends RuntimeException {

	}

	public class EmptyIntStackException extends RuntimeException {

	}

	private int[] stk;
	private int capacity; // 최대 저장 개수
	private int ptr = 0; // 현재 저장할 위치(현재 저장 개수)

	public IntStack() {
		this(64);
	}
	
	public IntStack(int len) {
		stk = new int[len];
		capacity = len;
		
	}

	public boolean push(int i) {
		if(ptr == capacity)
			throw new OverflowIntStackException();
		stk[ptr++] = i;
		return true;
	}

	public int pop() throws EmptyIntStackException {
		if(ptr == 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
}

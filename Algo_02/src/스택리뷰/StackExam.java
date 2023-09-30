package 스택리뷰;

public class StackExam {
	public static void main(String[] args) {
		IntStack st = new IntStack();
		st.push(100);
		st.push(500);
		st.push(300);
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
}

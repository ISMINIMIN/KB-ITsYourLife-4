package B1043_거짓말;

import java.util.Scanner;

public class Main {
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int P = sc.nextInt();
		if(P != 0) {
			int[] persons = new int[P];
			for(int i=0; i<P; i++) {
				persons[i] = sc.nextInt();
			}
		}
		
		arr = new int[N+1];
		for(int i=1; i<N+1; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			int V = sc.nextInt();
			int[] visits = new int[V];
			for(int j=0; j<V; j++) {
				visits[j] = sc.nextInt();
			}
		}
	}
}

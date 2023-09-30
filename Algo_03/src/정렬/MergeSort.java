package 정렬;

import java.util.Scanner;

public class MergeSort {
	static int N;
	static int[] nums, temp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		temp = new int[N];
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		mergeSort(0, N-1);
		
		for(int i=0; i<N; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	private static void mergeSort(int left, int right) {
		if(left < right) {
			int i;
			int center = (left + right) / 2;
		}
	}
}

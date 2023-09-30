package 정렬;

import java.util.Scanner;

public class QuickSort {
	static int N;
	static int[] nums;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 요소 개수
		
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		quickSort(0, N-1);
		
		for(int i=0; i<N; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	private static void quickSort(int left, int right) {
		int start = left; // 왼쪽 인덱스
		int end = right; // 오른쪽 인덱스
		int pivot = nums[(start+end)/2]; // 기준 값(피벗)
		
		while(start <= end) {
			while(nums[start] < pivot) start++;
			while(nums[end] > pivot) end--;
			if(start <= end) {
				swap(start++, end--);
			}
		}
		
		if(left < end) quickSort(left, end);
		if(right > start) quickSort(start, right);
	}

	private static void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

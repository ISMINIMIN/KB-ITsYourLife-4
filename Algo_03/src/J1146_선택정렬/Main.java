package J1146_선택정렬;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] nums;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		selectionSort();
	}

	private static void selectionSort() {
		for(int i=0; i<N-1; i++) {
			int min = i;
			for(int j=i+1; j<N; j++) {
				if(nums[min] > nums[j]) {
					min = j;
				}
			}
			swap(i, min);
			
			for(int k=0; k<N-1; k++) {
				System.out.print(nums[k] + " ");
			}
			System.out.println(nums[N-1]);
		}
	}

	private static void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

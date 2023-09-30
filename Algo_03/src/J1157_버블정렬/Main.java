package J1157_버블정렬;

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
		
		bubbleSort();
	}

	private static void bubbleSort() {
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-1-i; j++) {
				if(nums[j] > nums[j+1]) {
					swap(j, j+1);
				}
			}
			
			for(int k=0; k<N-1; k++) {
				System.out.print(nums[k] + " ");				
			}
			System.out.println(nums[N-1]);
		}
	}

	private static void swap(int j, int i) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
package J1158_삽입정렬;

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
		
		insertionSort();
	}

	private static void insertionSort() {
		for(int i=1; i<N; i++) {
			int j;
			int temp = nums[i];
			for(j=i; j>0 && nums[j-1] > temp; j--) {
				nums[j] = nums[j-1];
			}
			nums[j] = temp;
			
			for(int k=0; k<N-1; k++) {
				System.out.print(nums[k] + " ");
			}
			System.out.println(nums[N-1]);
		}
	}
}

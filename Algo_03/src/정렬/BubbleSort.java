package 정렬;

import java.util.Scanner;

public class BubbleSort {
	static int N;
	static int nums[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 요소 개수
		
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		bubbleSort();
		
		// 오름차순으로 정렬된 배열 출력
		for(int i=0; i<N; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	// 끝 요소 부터 비교, 요소를 비교하였을 때 앞의 요소가 뒤의 요소보다 큰 경우 swap
	private static void bubbleSort() {
		for(int i=0; i<N-1; i++) {
			for(int j=N-1; j>i; j--) {
				if(nums[j-1] > nums[j]) {
					swap(j-1, j);
				}
			}
		}
	}

	private static void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

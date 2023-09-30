package B1541_잃어버린괄호;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] minus = sc.next().split("-");
		int result = 0;
		
		for(int i=0; i<minus.length; i++ ) {
			String[] plus = minus[i].split("\\+"); // "+"로 문자열을 나눌 때는 "\\+"
			int sum = 0;
			for(int j=0; j<plus.length; j++) {
				sum += Integer.parseInt(plus[j]);
			}
			
			if(i == 0) result = sum; // 첫번째 값이 기준이 되므로 result 변수에 저장
			else result -= sum;
		}
		
		System.out.println(result);
	}
}
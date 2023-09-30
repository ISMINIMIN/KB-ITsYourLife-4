package B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] check, my_check;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken()); // DNA 문자열의 길이
		int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이
		
		String str = br.readLine(); // DNA 문자열
		char[] cArr = str.toCharArray();
		
		check = new int[4]; // A, C, G, T
		my_check = new int[4];
		count = 0;
		int answer = 0;
		
		// 부분 문자열에 포함되어야 할 A, C, G, T의 최소 개수 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			check[i] = Integer.parseInt(st.nextToken());
			// 최소 개수가 0인 경우 언제나 유효하기 때문에 충족했다고 판단
			if(check[i] == 0) {
				count++;
			}
		}
		
		for(int i=0; i<P; i++) {
			add(cArr[i]);
		}
		
		if(count == 4) {
			answer++;
		}
		
		// 슬라이딩 윈도우
		for(int i=P; i<S; i++) {
			int j = i - P;
			
			add(cArr[i]);
			delete(cArr[j]);
			
			if(count == 4) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	// 문자 더하기
	private static void add(char c) {
		switch(c) {
		case 'A' :
			my_check[0]++;
			if(my_check[0] == check[0])
				count++;
			break;
		case 'C' :
			my_check[1]++;
			if(my_check[1] == check[1])
				count++;
			break;
		case 'G' :
			my_check[2]++;
			if(my_check[2] == check[2])
				count++;
			break;
		case 'T' :
			my_check[3]++;
			if(my_check[3] == check[3])
				count++;
			break;
		}
	}
	
	// 문자 빼기
	private static void delete(char c) {
		switch(c) {
		case 'A' :
			if(my_check[0] == check[0])
				count--;
			my_check[0]--;
			break;
		case 'C' :
			if(my_check[1] == check[1])
				count--;
			my_check[1]--;
			break;
		case 'G' :
			if(my_check[2] == check[2])
				count--;
			my_check[2]--;
			break;
		case 'T' :
			if(my_check[3] == check[3])
				count--;
			my_check[3]--;
			break;
		}
	}
}
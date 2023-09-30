package S1233_사칙연산유효성검사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			boolean flag = true;
			int N = Integer.parseInt(br.readLine());
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String str = st.nextToken();
				
				if(st.hasMoreTokens( )) {
					if(!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
						flag = false;
					}
				} else {
					if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
						flag = false;
					}
				}
			}
			
			if(flag) System.out.println("#" + t + " 1");
			else System.out.println("#" + t + " 0");
		}
	}
}

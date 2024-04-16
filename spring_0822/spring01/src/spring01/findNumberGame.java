package spring01;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class findNumberGame {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(GameContext.class);
		
		// 난수생성, 판정메서드
		// NumberGuess numberGuess = new NumberGuess();
		NumberGuess numberGuess = context.getBean(NumberGuess.class);
		
		Scanner sc = new Scanner(System.in);
		while(true) { // 정답을 맞출 때까지 무한 반복
			int num = sc.nextInt();
			String result = numberGuess.checkNumber(num);
			System.out.println(result);
			
			if(result.equals("정답")) break;
		}
		
	}
	
}

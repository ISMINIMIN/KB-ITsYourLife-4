package Review;

import java.util.Random;

public class R08_랜덤 {
	public static void main(String[] args) {
		Random random = new Random(0); // 기준값을 주지 않은 경우
		int randomInt = random.nextInt(45) + 1; // 0 이상 3 미만의 난수
		System.out.println(randomInt);
		randomInt = random.nextInt(45) + 1;
		System.out.println(randomInt);
		randomInt = random.nextInt(45) + 1;
		System.out.println(randomInt);
		
		Random random1 = new Random(500); // 기준값을 준 경우
		int randomInt1 = random1.nextInt(45) + 1; // 0 이상 3 미만의 난수
		System.out.println(randomInt1);
		randomInt1 = random1.nextInt(45) + 1;
		System.out.println(randomInt1);
		randomInt1 = random1.nextInt(45) + 1;
		System.out.println(randomInt1);
	}
}

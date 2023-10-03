package Review;

import java.util.HashMap;

public class R09_맵 {
	public static void main(String[] args) {
		// HashMap에 홍길동의 수학점수 90, 영어점수 80 저장하기
		
		HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
		scoreMap.put("수학", 90);
		scoreMap.put("영어", 80);
		
		HashMap<String, HashMap<String, Integer>> mainMap = new HashMap<String, HashMap<String,Integer>>();
		mainMap.put("홍길동", scoreMap);
		
		System.out.println(mainMap);
	}
}

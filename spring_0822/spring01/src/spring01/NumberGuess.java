package spring01;

/** 난수와 판정 메서드를 제공 */
public class NumberGuess {
	private int com_num = new java.util.Random().nextInt(100) + 1;
	
	public String checkNumber(int num) {
		if(com_num == num) return "정답입니다";
		if(com_num < num) return "내려주세요";
		if(com_num > num) return "올려주세요";
		
		return null;
	}
	
}

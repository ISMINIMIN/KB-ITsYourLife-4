package spring01;

public class MyCalc {

	private MyLog log = null;
	
	public MyCalc() {

	}
	
	public void setLog(MyLog log) {
		this.log = log;
	}
	
	public MyCalc(MyLog log) {
		this.log = log;
	}
	
	public int plus(int a, int b) {
		int sum = a + b;
		log.log(a + " + " + b + " = " + sum);
		return sum;
	}

}

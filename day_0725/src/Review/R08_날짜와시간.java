package Review;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class R08_날짜와시간 {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getHours());
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year);
		System.out.println(month+1); // month는 하나씩 작게 나옴
		System.out.println(day);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		String today = dateFormat.format(new Date());
		System.out.println(today);
	}
}

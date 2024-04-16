package spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain2 {

	public static void main(String[] args) {

//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//
//		MyCalc mc = context.getBean(MyCalc.class);
//		int result = mc.plus(3, 4);
//		System.out.println(result);

		ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class, AppContext2.class);

		MyCalc mc = context.getBean(MyCalc.class);
		int result = mc.plus(3, 4);
		System.out.println(result);

//		MyCalc mc2 = context.getBean(MyCalc.class);
//		System.out.println(mc == mc2);
		
	}

}

package spring02_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AopContext.class);
		Calc calc = context.getBean(Calc.class);
		System.out.println("Calc 이름 : " + calc.getClass().getName());
		long factorial = calc.factorial(10);
		System.out.println(factorial);
	}
}

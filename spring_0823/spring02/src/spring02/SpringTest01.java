package spring02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest01 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		HelloService hs = context.getBean(HelloService.class);
//		System.out.println(hs.hello());
		
		// id로 찾는 경우에는 Object가 반환되어 캐스팅 필요
		HelloService hsKr = (HelloService)context.getBean("hello");
		System.out.println(hsKr.hello());
		
		HelloService hsEng = (HelloService)context.getBean("helloEng");
		System.out.println(hsEng.hello());
	}
}

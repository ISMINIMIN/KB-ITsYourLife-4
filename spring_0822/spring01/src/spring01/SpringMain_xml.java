package spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain_xml {

	public static void main(String[] args) {

		// 애플리케이션이 동작하는 환경정보(xml 설정 파일 읽어오기)
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		// 설정 파일에서 HelloService 검색
		HelloService hs = context.getBean(HelloService.class); // Spring이 관리
		// 서비스 메소드 호출
		String msg = hs.hello();
		System.out.println(msg);

	}

}

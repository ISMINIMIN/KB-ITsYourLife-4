package spring01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppContext2.class)
public class AppContext {

	@Autowired
	private MyLog log;
	
	@Bean
	public HelloService hello() {
		return new HelloServiceEn();
	}
	
	@Bean
	public MyCalc calc() {
		// 생성자를 통한 DI
		// return new MyCalc( fileLog() );
		
		// setter를 통한 DI
		MyCalc mc = new MyCalc();
		mc.setLog(log);
		return mc;
	}
	
}

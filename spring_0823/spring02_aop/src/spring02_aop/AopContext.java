package spring02_aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"spring02_aop"})
@EnableAspectJAutoProxy // 프록시를 자동으로 만들어줌
public class AopContext {
	
}

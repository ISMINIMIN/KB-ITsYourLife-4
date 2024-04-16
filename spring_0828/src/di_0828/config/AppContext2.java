package di_0828.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"di_0828.service"}) // 검색할 컴포넌트가 1개인 경우 중괄호 생략 가능, 여러 개일 경우 중괄호 필수
public class AppContext2 {

}

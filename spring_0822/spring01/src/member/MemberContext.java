package member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberContext {
	
	@Bean
	MemberService memberService() {
		return new MemberService();
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDaoImpl();
	}
	
	@Bean
	public MemberDao memberDaoMySql() {
		return new MemberDaoMySqlImpl();
	}
	
}

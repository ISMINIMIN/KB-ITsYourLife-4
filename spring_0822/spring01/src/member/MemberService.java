package member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberService {
	@Autowired(required = false)
	@Qualifier("memberDao") // 같은 타입의 빈이 여러개 등록된 경우 이름으로 빈을 특정
	private MemberDao dao;
	
	public boolean login(String id, String pw) {
		System.out.println("dao : " + dao);
		return false;
	}
}

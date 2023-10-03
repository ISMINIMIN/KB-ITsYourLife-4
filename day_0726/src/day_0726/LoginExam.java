package day_0726;

public class LoginExam {
	public static void main(String[] args) {
		String id = "user100";
		String passwd = "1111";
		
		try {
			login(id, passwd);
			System.out.println("로그인 성공");
		} catch (미등록아이디Exception e) {
			e.printStackTrace();
			System.out.println("메시지 : " + e.getMessage());
		} catch (비밀번호틀림Exception e) {
			e.printStackTrace();
			System.out.println("메시지 : " + e.getMessage());
		}
	} // end main()

	private static void login(String id, String passwd) throws 미등록아이디Exception, 비밀번호틀림Exception {
		if(id != "user100") {
			// throw new Exception("미등록 ID");
			throw new 미등록아이디Exception(id + "는 없는 아이디 입니다.");
		}
		
		if(passwd != "1111") {
			throw new 비밀번호틀림Exception("비밀번호가 틀립니다.");			
		}
	} // end login()
}

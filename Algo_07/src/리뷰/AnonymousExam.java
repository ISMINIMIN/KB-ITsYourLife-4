package 리뷰;

public class AnonymousExam {
	public static void main(String[] args) {
		// 일회용 임시 자식 클래스 만드는 법
		A a= new A() { 
			// 선언부(A의 자식 클래스 정의)
			// A를 상속받은 익명(이름 없는) 클래스
			int j = 100;
			@Override
			public void p() {
				System.out.println("B " + j);
			}
		};
		
		a.p();
		System.out.println(a.getClass().getName()); // 클래스 이름 출력
		
		MySwim mySwim = new MySwim() {
			@Override
			public void swimming() {
				System.out.println("수영 0^~");
			}
		};
		
		mySwim.swimming();
		System.out.println(mySwim.getClass().getName());
	}
}

class A {
	public void p() {
		System.out.println("A");
	}
}

//class B extends A {
//	@Override
//	public void p() {
//		System.out.println("B");
//	}
//}

interface MySwim {
	void swimming();
}

//class MySwimImpl implements MySwim {
//	@Override
//	public void swimming() {
//		
//	}	
//}
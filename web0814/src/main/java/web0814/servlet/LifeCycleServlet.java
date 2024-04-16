package web0814.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// 서블릿 초기화 메서드
		System.out.println("** init() **");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청마다 실행되는 메서드
		super.service(req, resp);
		System.out.println("** service() **");
	}
	
	@Override
	public void destroy() {
		// 객체 삭제 시 실행되는 메서드 - 서블릿 코드를 수정하면 톰캣이 자동으로 기존 서블릿을 종료하고 새로운 서블릿을 생성함
		System.out.println("** destroy() **");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청마다 실행되는 메서드
		System.out.println("** doGet() **");
	}
	
}

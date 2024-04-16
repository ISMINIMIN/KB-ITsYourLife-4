package web0814.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	response.setCharacterEncoding("UTF-8");
    	
//    	response.setContentType("text/plain"); // 디폴트 - 생략가능
//    	response.setCharacterEncoding("EUC-KR");
    	
    	String name = request.getParameter("name");
    	String tel = request.getParameter("tel");
    	String gender = request.getParameter("gender");
    	String major = request.getParameter("major");
    	
		response.getWriter().append("이름 : " + name + "<br>");
		response.getWriter().append("연락처 : " + tel + "<br>");
		response.getWriter().append("성별 : " + gender + "<br>");
		response.getWriter().append("전공 : " + major + "<br>");
    	
//		response.getWriter().append("이름 : " + name + "\n");
//		response.getWriter().append("연락처 : " + tel + "\n");
//		response.getWriter().append("성별 : " + gender + "\n");
//		response.getWriter().append("전공 : " + major + "\n");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

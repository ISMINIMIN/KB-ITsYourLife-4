package web0816.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0816.dto.MemberDto;

@WebServlet("/memberRegistServlet")
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MemberDto dto = new MemberDto();
    	String name = request.getParameter("name");
    	String param_age = request.getParameter("age");
    	int age = Integer.parseInt(param_age);
    	
    	dto.setName(name);
    	dto.setAge(age);
    	
    	// 생성한 dto를 request에 속성으로 저장
    	request.setAttribute("dto", dto);
    	request.setAttribute("msg", "Hello");
    	
    	// member_regist2.jsp로 포워드
    	request.getRequestDispatcher("/member_regist2.jsp").forward(request, response); // 포워딩 후 추가 작업 불가
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

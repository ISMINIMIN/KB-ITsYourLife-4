package web0814.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudanServlet")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	response.setCharacterEncoding("EUC-KR");
    	
    	String dan = request.getParameter("dan");
    	try {
			int my_dan = Integer.parseInt(dan);
			if(my_dan < 2) throw new IllegalArgumentException("입력 값은 2 이상이어야 합니다.");
			if(my_dan > 9) throw new IllegalArgumentException("입력 값은 9 이하이어야 합니다.");
			
			response.getWriter().append(dan + "단 <br>");
			for(int i=1; i<10; i++) {
				response.getWriter().append(dan + " x " + i + " = " + Integer.toString(my_dan * i) + "<br>"); 		
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().append("잘못된 입력 : " + e.getMessage());
		}
    	
	}

}

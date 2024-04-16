package web0814.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findServlet")
public class FindNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int com_num = (int)(Math.random() * 100 + 1);
	// private int com_num_2 = new java.util.Random().nextInt(100) + 1;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String result = "";
    	String num = request.getParameter("num");
    	
    	try {
			int my_num = Integer.parseInt(num);
			if(my_num < 1) throw new IllegalArgumentException("값은 1 이상이어야 합니다.");
			if(my_num > 100) throw new IllegalArgumentException("값은 100 이하여야 합니다.");
			
			if(my_num == com_num) {
				result = "정답입니다.";
				com_num = (int)(Math.random() * 100 + 1);
			}
			else if(my_num > com_num) result = "내려주세요.";
			else if(my_num < com_num) result = "올려주세요.";
		} catch (Exception e) {
			e.printStackTrace();
			result = "잘못된 입력 : " + e.getMessage();
		}
    	
    	response.setCharacterEncoding("EUC-KR");
		response.getWriter().append(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

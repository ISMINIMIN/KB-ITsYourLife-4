package web0816.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findNumberMvcServlet")
public class FindNumberMvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int com_num = new java.util.Random().nextInt(100) + 1;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String param_num = request.getParameter("num");
    	try {
			int num = Integer.parseInt(param_num);
			if(num < 1) throw new IllegalArgumentException("입력 값은 1 이상이어야 합니다.");
			if(num > 100) throw new IllegalArgumentException("입력 값은 100 이하이어야 합니다.");
			
			if(com_num == num) {
				request.setAttribute("msg", num + " 추카추카, 정답입니다.");
				com_num = new java.util.Random().nextInt(100) + 1;
			} else if(com_num > num) {
				request.setAttribute("msg", num + " 숫자를 올려주세요");
			} else {
				request.setAttribute("msg", num + " 숫자를 내려주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "잘못된 입력입니다. " + e.getMessage());
			
		}
    	
    	request.getRequestDispatcher("/find_number_mvc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

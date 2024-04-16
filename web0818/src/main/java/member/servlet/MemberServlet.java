package member.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	// 작업 추출
    	String command = "list"; // command가 없이 들어올 경우를 대비(기본 작업은 list)
    	command = request.getParameter("command");
    	if(command == null || command.trim().length() == 0) {
    		command = "list";
    	}
    	
    	String view = null;
    	try {
			if(command.equals("insert_form")) {
				view = insert_form(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			view = "/member/error.jsp";
			request.setAttribute("err_msg", e.getMessage());
		}
    	
    	request.getRequestDispatcher(view).forward(request, response);
	}

	private String insert_form(HttpServletRequest request, HttpServletResponse response) {
		return "/member/insert_form.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

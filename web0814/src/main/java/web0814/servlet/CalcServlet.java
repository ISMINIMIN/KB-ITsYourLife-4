package web0814.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String opr = request.getParameter("opr");
    	int n1 = Integer.parseInt(request.getParameter("n1"));
    	int n2 = Integer.parseInt(request.getParameter("n2"));
    	int result = 0;
    	
    	if(opr.equals("+")) {
    		result = n1 + n2;
    	} else if(opr.equals("-")) {
    		result = n1 - n2;
    	} else if(opr.equals("*")) {
    		result = n1 * n2;
    	} else if (opr.equals("/")) {
    		result = n1 / n2;
    	}
    	
		response.getWriter().append(Integer.toString(result));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

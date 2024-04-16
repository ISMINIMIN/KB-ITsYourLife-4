package web0817_mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0817_mvc.dao.BoardDao;
import web0817_mvc.dao.BoardDaoImpl;
import web0817_mvc.dto.BoardDto;

@WebServlet("/board/update_form")
public class BoradUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String paramNo = request.getParameter("no");
    	int no = Integer.parseInt(paramNo);
    	
    	BoardDao dao = new BoardDaoImpl();
    	String url = "/board_update_form.jsp";
    	try {
			BoardDto dto = dao.findById(no);
			request.setAttribute("dto", dto);
		} catch (Exception e) {
			e.printStackTrace();
			url = "/board_error.jsp";
			request.setAttribute("msg", e.getMessage());
		}
    	
    	request.getRequestDispatcher(url).forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

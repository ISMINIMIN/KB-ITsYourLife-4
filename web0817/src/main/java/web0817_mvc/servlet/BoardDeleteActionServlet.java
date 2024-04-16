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

@WebServlet("/board/delete_action")
public class BoardDeleteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	BoardDto dto = new BoardDto();
    	dto.setNo(Integer.parseInt(request.getParameter("no")));
    	
    	String url = "/board_ok.jsp";
    	
    	try {
			BoardDao dao = new BoardDaoImpl();
			dao.delete(dto.getNo());
			request.setAttribute("msg", "게시물 삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
			url = "/board_error.jsp";
			request.setAttribute("err_msg", e.getMessage());
		}
    	
    	request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package jp.ac.hal;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectMemoServlet
 */
@WebServlet("/SelectMemoServlet")
public class SelectMemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		MemoDAO dao = new MemoDAO();
		ArrayList<Memo>list = dao.select();
		ArrayList<Memo>categoryList = dao.selectCategory();
		
		request.setAttribute("list", list);
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String category = request.getParameter("category");
		MemoDAO dao = new MemoDAO();
		ArrayList<Memo> list = dao.select(category);
		ArrayList<Memo>categoryList = dao.selectCategory();
		
		request.setAttribute("list", list);
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}

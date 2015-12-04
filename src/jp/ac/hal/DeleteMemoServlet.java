package jp.ac.hal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteMemoServlet
 */
@WebServlet("/DeleteMemoServlet")
public class DeleteMemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf8");
		
		String strId = request.getParameter("id");
		int id = 0;
		boolean isErr = false;
		
		// nullチェック
		try{
			id = Integer.parseInt(strId);
		}catch(Exception e){
			isErr = true;
		}
		
		if(!isErr) {
			MemoDAO dao = new MemoDAO();
			int count = dao.delete(id);
			
			if( count <= 0 ) {
				request.setAttribute("msg", "削除されました");
			}else{
				request.setAttribute("msg", "データの更新に失敗しました");
			}
		}
		response.sendRedirect("SelectMemoServlet");
	}

}

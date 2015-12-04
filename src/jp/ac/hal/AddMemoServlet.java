package jp.ac.hal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddMemoServlet
 */
@WebServlet("/AddMemoServlet")
public class AddMemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMemoServlet() {
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
		
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String memo = request.getParameter("memo");
		String url = "";
		
		boolean isErr = false; // エラー判定
		
		// nullチェック
		if( title == "" || title == null ){
			request.setAttribute("titleErr", "タイトルを入力してください");
			isErr = true;
		}
		if( memo == "" || memo == null ){
			request.setAttribute("memoErr", "メモを入力してください");
			isErr = true;
		}
		
		if(!isErr) {
			MemoDAO dao = new MemoDAO();
			int count = dao.add(title, category, memo);
			if( count <= 0 ){
				request.setAttribute("mes", "更新されませんでした");
			}else{
				request.setAttribute("mes", "更新されました");
			}
			url = "SelectMemoServlet";
		}else{
			url = "./add.jsp";
		}
		
		if(isErr){
			request.getRequestDispatcher(url).forward(request, response);
		}else{
			response.sendRedirect(url);
		}
	}
}

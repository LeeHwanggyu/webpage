package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BbsModifyServlet
 */
@WebServlet("/bbsModify.do")
public class BbsModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("ID");
		String btn = request.getParameter("BTN");
		String seqno = request.getParameter("SEQNO");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("LOGIN");
		if(id == null) {
			response.sendRedirect("login.jsp?MSG=M");
		}else {
			if(btn.equals("삭제")) {
				String delete = "delete from bbs where seqno=?";
				int result = -1;
				Connection c = null; PreparedStatement pstmt = null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
					pstmt = c.prepareStatement(delete);
					pstmt.setInt(1, Integer.parseInt(seqno));
					result = pstmt.executeUpdate();
					response.sendRedirect("bbsDeleteResult.jsp?R="+result);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(c != null) c.close(); if(pstmt != null) pstmt.close();
					}catch(Exception e) {}
				}
			}else if(btn.equals("수정")){
				 String update = "update bbs set title=?,content=? where seqno=?";
				 String content = request.getParameter("CONTENT");
				 String title = request.getParameter("TITLE");
				 int result = -1;
				 Connection c = null; PreparedStatement pstmt = null;
				 try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
						pstmt = c.prepareStatement(update);
						pstmt.setString(1, title);pstmt.setString(2, content);
						pstmt.setInt(3, Integer.parseInt(seqno));
						result = pstmt.executeUpdate();
						response.sendRedirect("bbsUpdateteResult.jsp?R="+result);
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(c != null) c.close(); if(pstmt != null) pstmt.close();
						}catch(Exception e) {}
					}
			}else {
				response.sendRedirect("noWriter.jsp");
			}
		}
	}

}

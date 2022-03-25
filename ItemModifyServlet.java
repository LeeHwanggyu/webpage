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

/**
 * Servlet implementation class ItemModifyServlet
 */
@WebServlet("/itemModify.do")
public class ItemModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemModifyServlet() {
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
		String pid = request.getParameter("PID");
		String btn = request.getParameter("BTN");
		if(btn.equals("삭제")) {
			String delete = "delete from selling_items where pid =?";
			int result = -1;
			Connection c = null; PreparedStatement pstmt=null;
			try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
					pstmt = c.prepareStatement(delete);
					pstmt.setInt(1, Integer.parseInt(pid));
					result = pstmt.executeUpdate();
					response.sendRedirect("itemDeleteResult.jsp?R="+result);
				}catch(Exception e) {
					e.printStackTrace();
			}finally {
				try {
					if(c != null) c.close(); if(pstmt != null) pstmt.close(); 
				}catch(Exception e) {}
			}
		}else if(btn.equals("수정")) {
			String name = request.getParameter("NAME");
			String price = request.getParameter("PRICE");
			String com = request.getParameter("COM");
			String info = request.getParameter("INFO");
			String update = "update selling_items set pname=?, price=?, ccode=?"+
			"pinfo=? where pid=?";
			int result=-1;
			Connection c = null; PreparedStatement pstmt=null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
				pstmt = c.prepareStatement(update);
				pstmt.setString(1, name); 
				pstmt.setInt(2, Integer.parseInt(price));
				pstmt.setString(3, com);
				pstmt.setString(4, info);
				pstmt.setInt(5, Integer.parseInt(pid));
				result = pstmt.executeUpdate();
				response.sendRedirect("itemUpdateResult.jsp?R="+result);
			}catch(Exception e) {
				e.printStackTrace();
		}finally {
			try {
				if(c != null) c.close(); if(pstmt != null) pstmt.close(); 
			}catch(Exception e) {}
		}
		}
	}
}

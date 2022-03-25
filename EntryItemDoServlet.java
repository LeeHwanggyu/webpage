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
 * Servlet implementation class EntryItemDoServlet
 */
@WebServlet("/entryItemDo.do")
public class EntryItemDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryItemDoServlet() {
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
		String name = request.getParameter("NAME");
		String price = request.getParameter("PRICE");
		String company = request.getParameter("COMPANY");
		String info = request.getParameter("INFO");
		String insert = "insert into selling_items values(?,?,?,?,?)";
		int result = -1;
		Connection c =null; PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
			pstmt = c.prepareStatement(insert);
			pstmt.setInt(1, Integer.parseInt(pid));
			pstmt.setString(2, name);
			pstmt.setInt(3, Integer.parseInt(price));
			pstmt.setString(4, info);
			pstmt.setInt(5, Integer.parseInt(company));
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(c != null) c.close(); if(pstmt != null) pstmt.close();
			}catch(Exception e) {}
		}
		response.sendRedirect("entryItemResult.jsp?R="+result);
	}

}

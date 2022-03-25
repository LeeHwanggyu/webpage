package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EntryItemServlet
 */
@WebServlet("/entryItem.do")
public class EntryItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int pid= -1;
		String select_pid = "select max(pid) from selling_items";
		String[] coms = null;
		String select_com = "select cname from company_info order by ccode";
		Connection c = null; PreparedStatement pstmt = null; ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
			pstmt = c.prepareStatement(select_pid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pid = rs.getInt(1) + 1;
			}else {
				pid = 1;
			}
			pstmt = c.prepareStatement(select_com);
			rs = pstmt.executeQuery();
			int count = 0;
			while(rs.next()) {
				count++;
				
			}
			coms = new String[count];
			rs = pstmt.executeQuery();
			int idx = 0;
			while(rs.next()){
				coms[idx] = rs.getString(1);
				idx++;
			}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(c != null) c.close(); if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		}catch(Exception e) {}
		}
		request.setAttribute("PID", pid);
		request.setAttribute("COMS", coms);
		request.setAttribute("SIZE", coms.length);
		RequestDispatcher rd = request.getRequestDispatcher("entryItem.jsp");
		rd.forward(request, response);
	}	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

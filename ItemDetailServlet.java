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

import model.Item;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/itemDetail.do")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("PID");
		String select = "select * from selling_items where pid=?";
		Item item = null;
		String select_com = "select cname from company_info order by ccode";
		String[] names = null;
		Connection c = null; PreparedStatement pstmt = null; ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
			pstmt = c.prepareStatement(select);
			pstmt.setInt(1, Integer.parseInt(pid));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				item = new Item();
				item.setPid(rs.getInt(1));
				item.setPname(rs.getString(2));
				item.setPrice(rs.getInt(3));
				item.setPinfo(rs.getString(4));
				item.setCcode(rs.getInt(5));
			}
			pstmt = c.prepareStatement(select_com);
			rs = pstmt.executeQuery();
			int count = 0;
			while(rs.next()) {
				count++;
			}
			names = new String[count];
			rs = pstmt.executeQuery();
			int idx = 0;
			while(rs.next()){
				names[idx] = rs.getString(1);
				idx++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(c != null) c.close(); if(pstmt != null) pstmt.close(); if(rs != null) rs.next();
			}catch(Exception e) {}
		}
		request.setAttribute("DETAIL", item);
		request.setAttribute("NAMES", names);
		request.setAttribute("CNT", names.length);
		RequestDispatcher rd = request.getRequestDispatcher("itemDetail.jsp");
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

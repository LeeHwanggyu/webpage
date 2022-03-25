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

import model.BBS;

/**
 * Servlet implementation class BbsDetailServlet
 */
@WebServlet("/bbsDetail.do")
public class BbsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String seqno = request.getParameter("SEQNO");
		String select = "select * from bbs where seqno = ?";
		BBS bbs = null;
		Connection c = null; PreparedStatement pstmt = null; ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
			pstmt = c.prepareStatement(select);
			pstmt.setInt(1, Integer.parseInt(seqno));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bbs = new BBS();
				bbs.setSeqno(rs.getInt(1));
				bbs.setId(rs.getString(2));
				bbs.setTitle(rs.getString(3));
				bbs.setContent(rs.getString(4));
				bbs.setBbs_date(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(c != null) c.close(); if(pstmt != null) pstmt.close(); if(rs != null) rs.close();
			}catch(Exception e) {}
		}
		request.setAttribute("BBS", bbs);
		RequestDispatcher rd = request.getRequestDispatcher("bbsDetail.jsp");
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

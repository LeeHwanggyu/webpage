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
 * Servlet implementation class BbsListServlet
 */
@WebServlet("/bbsList.do")
public class BbsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_no = request.getParameter("PAGE_NO");
		int page = -1;
		if(page_no == null) page = 1;
		else page = Integer.parseInt(page_no);
		String select = "select seqno,id,title,bbs_date "+
				"from (select rownum rn, a.* "+
				"from (select seqno,id,title,bbs_date from bbs "+
				"order by seqno desc) a) "+
				"where rn > ((?-1)*5) and rn < (((?-1)*5)+6)";
		String selectTotal = "select count(*) from bbs";
		BBS[] bbsList = null;
		int totalPageCount = 0;
		Connection c = null; PreparedStatement pstmt= null; ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
			pstmt = c.prepareStatement(select);
			pstmt.setInt(1, page); 
			pstmt.setInt(2, page);
			rs = pstmt.executeQuery();
			int count = 0;
			while(rs.next()) {
				count++;
			}
			bbsList = new BBS[count];
			rs = pstmt.executeQuery();
			int idx = 0;
			while(rs.next()) {
				BBS bbs = new BBS();
				bbs.setSeqno(rs.getInt(1));
				bbs.setId(rs.getString(2));
				bbs.setTitle(rs.getString(3));
				bbs.setBbs_date(rs.getString(4));
				bbsList[idx] = bbs;
				idx++;				
			}
			pstmt = c.prepareStatement(selectTotal);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalPageCount = rs.getInt(1) / 5;
				if(rs.getInt(1) % 5!=0)
					totalPageCount++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(c != null) c.close(); if(pstmt != null) pstmt.close(); if(rs != null) rs.close();
		}catch(Exception e) {}
		}
		request.setAttribute("BBSLIST", bbsList);//조회결과가 저장된 배열을 내장객체에 저장
		request.setAttribute("PAGES", totalPageCount);//페이지 갯수를 내장객체에 저장
		RequestDispatcher rd = request.getRequestDispatcher("showBbs.jsp");
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

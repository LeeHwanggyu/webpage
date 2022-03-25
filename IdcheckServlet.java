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
 * Servlet implementation class IdcheckServlet
 */
@WebServlet("/idCheck.do")
public class IdcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdcheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("MEMBER_ID");
		System.out.println("입력한 계정:"+id);
		//id에 들어있는 계정으로 DB테이블에서 검색
		String select = "select id from custom where id=?";
		String result = null;//조회결과를 저장할 변수
		Connection c=null;PreparedStatement pstmt=null;ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
			pstmt = c.prepareStatement(select);
			pstmt.setString(1, id);//첫번째 물음표에 입력한 계정을 설정
			rs = pstmt.executeQuery();//select 쿼리 실행
			if(rs.next()) result = rs.getString(1);//조회결과를 저장
		}catch(Exception e) {
			
		}finally {
			try {
				if(c != null) c.close(); if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}catch(Exception e) {}
		}
		//검색결과가 존재하면, 중복. 존재하지 않으면, 사용가능
		//위의 결과를 JSP(idCheck.jsp)로 전달한다.
		request.setAttribute("ID", id);//입력한 계정을 내장객체에 저장
		request.setAttribute("DUP", result);//중복 유무를 내장객체에 저장
		RequestDispatcher rd = request.getRequestDispatcher("idCheck.jsp");
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

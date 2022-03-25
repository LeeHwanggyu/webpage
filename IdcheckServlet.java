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
		System.out.println("�Է��� ����:"+id);
		//id�� ����ִ� �������� DB���̺��� �˻�
		String select = "select id from custom where id=?";
		String result = null;//��ȸ����� ������ ����
		Connection c=null;PreparedStatement pstmt=null;ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
			pstmt = c.prepareStatement(select);
			pstmt.setString(1, id);//ù��° ����ǥ�� �Է��� ������ ����
			rs = pstmt.executeQuery();//select ���� ����
			if(rs.next()) result = rs.getString(1);//��ȸ����� ����
		}catch(Exception e) {
			
		}finally {
			try {
				if(c != null) c.close(); if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}catch(Exception e) {}
		}
		//�˻������ �����ϸ�, �ߺ�. �������� ������, ��밡��
		//���� ����� JSP(idCheck.jsp)�� �����Ѵ�.
		request.setAttribute("ID", id);//�Է��� ������ ���尴ü�� ����
		request.setAttribute("DUP", result);//�ߺ� ������ ���尴ü�� ����
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

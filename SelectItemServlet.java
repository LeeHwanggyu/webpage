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
 * Servlet implementation class SelectItemsServlet
 */
@WebServlet("/selectItems.do")
public class SelectItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select = "select pid,pname,price "+
			"from (select rownum rn, pid, pname, price from "+
			"(select pid,pname,price from selling_items order by pid asc))"+
			"where rn > ((? - 1)*5) and rn < ((? -1)*5 +6)";
		String selectCount = "select count(*) from selling_items";
		int totalPage = 0;
		Item[] items = null;
		String page_num = request.getParameter("PAGE_NUM");
		String page = null;
		if(page_num == null) page = "1";
		else page = page_num;
		Connection c=null; PreparedStatement pstmt=null; ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
			pstmt = c.prepareStatement(select);
			pstmt.setInt(1, Integer.parseInt(page));
			pstmt.setInt(2, Integer.parseInt(page));
			rs = pstmt.executeQuery();
			int count = 0;
			while(rs.next()) {
				count++;//��ȸ�� ����� �� ��
			}
			items = new Item[count];//��ȸ�� ����� ����� �迭 ����
			rs = pstmt.executeQuery();
			int idx = 0;
			while(rs.next()) {
				Item it = new Item();
				it.setPid(rs.getInt(1));//��ȸ�� ��ǰ��ȣ�� DTO�� ����
				it.setPname(rs.getString(2));//��ȸ�� ��ǰ�̸��� DTO�� ����
				it.setPrice(rs.getInt(3));//��ȸ�� ������ DTO�� ����
				items[idx] = it;//DTO�� �迭�� ����
				idx++;//�迭�� �ε����� ����
			}
			pstmt = c.prepareStatement(selectCount);
			rs = pstmt.executeQuery();
			if(rs.next()) {//��ȸ����� �����ϴ� ���
				totalPage = rs.getInt(1);//��ȸ����� totalPage�� ����
				totalPage = totalPage / 5;
				if((rs.getInt(1)) % 5 != 0) totalPage++;
			}else {//��ȸ����� �������� �ʴ� ���
				totalPage = 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(c != null) c.close(); if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}catch(Exception e) {}
		}
		//�� ��ǰ������ �˻��ؼ� ������ ������ ã�´�.
		//��ǰ������ ������ ������ JSP�� �����Ѵ�.
		request.setAttribute("TP", totalPage);//������ ������ ���尴ü�� ����
		request.setAttribute("ITS", items);//��ȸ����� ����� �迭�� ���尴ü ����
		RequestDispatcher rd = request.getRequestDispatcher("myItems.jsp");
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







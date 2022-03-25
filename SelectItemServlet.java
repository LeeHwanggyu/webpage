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
				count++;//조회된 결과의 건 수
			}
			items = new Item[count];//조회된 결과가 저장될 배열 생성
			rs = pstmt.executeQuery();
			int idx = 0;
			while(rs.next()) {
				Item it = new Item();
				it.setPid(rs.getInt(1));//조회된 상품번호를 DTO에 저장
				it.setPname(rs.getString(2));//조회된 상품이름을 DTO에 저장
				it.setPrice(rs.getInt(3));//조회된 가격을 DTO에 저장
				items[idx] = it;//DTO를 배열에 저장
				idx++;//배열의 인덱스를 증가
			}
			pstmt = c.prepareStatement(selectCount);
			rs = pstmt.executeQuery();
			if(rs.next()) {//조회결과가 존재하는 경우
				totalPage = rs.getInt(1);//조회결과를 totalPage에 저장
				totalPage = totalPage / 5;
				if((rs.getInt(1)) % 5 != 0) totalPage++;
			}else {//조회결과가 존재하지 않는 경우
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
		//총 상품갯수를 검색해서 페이지 갯수를 찾는다.
		//상품정보와 페이지 갯수를 JSP로 전달한다.
		request.setAttribute("TP", totalPage);//페이지 갯수를 내장객체에 저장
		request.setAttribute("ITS", items);//조회결과가 저장된 배열을 내장객체 저장
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







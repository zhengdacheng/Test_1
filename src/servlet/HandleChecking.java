package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.check;
import util.DBHelper;

/**
 * Servlet implementation class HandleChecking
 */
@WebServlet("/HandleChecking")
public class HandleChecking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HandleChecking() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		int phone_number, qq_id;
		String first_wish;
		String second_wish;
		String reason;
		String favourite;
		phone_number = Integer.parseInt(request.getParameter("phonenumber").trim());
		qq_id = Integer.parseInt(request.getParameter("QQ_id").trim());
		first_wish = request.getParameter("first").trim();
		second_wish = request.getParameter("second").trim();
		reason = request.getParameter("reason");
		favourite = request.getParameter("favourite");
		check ck = new check();
		ck.setPhone_number(phone_number);
		ck.setQq_id(qq_id);
		ck.setFirst_wish(first_wish);
		ck.setFavourite(favourite);
		ck.setSecond_wish(second_wish);
		ck.setReason(reason);
		request.getSession().setAttribute("ck",ck );
		// 数据库处理代码
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "INSERT into message(phone_number,QQ_id,first_wish,second_wish,reason,favourite) values(?,?,?,?,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, phone_number);
			pre.setInt(2, qq_id);
			pre.setString(3, first_wish);
			pre.setString(4, second_wish);
			pre.setString(5, reason);
			pre.setString(6, favourite);
			int i = pre.executeUpdate();
			if (i != 0) {
				System.out.println("INSERT 语句执行成功");
				request.getRequestDispatcher("../login_success.jsp").forward(request, response);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (pre != null) {
				try {
					pre.close();
					pre = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

	}

}

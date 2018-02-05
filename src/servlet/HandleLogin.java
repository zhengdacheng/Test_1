package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBHelper;

/**
 * Servlet implementation class HandleLogin
 */
@WebServlet("/HandleLogin")
public class HandleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HandleLogin() {
		super();
		// TODO Auto-generated constructor stub
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
		String password;
		int id;
		id = Integer.parseInt(request.getParameter("userid").trim());
		password = request.getParameter("password").trim();		
		// 数据库处理代码
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "SELECT * FROM users ";
			st = conn.createStatement();
			
			if (id > 0 && password.length() > 0) {
				rs = st.executeQuery(sql);
				while (rs.next()) {
					int i =rs.getInt("QQ_id");
					String s =(rs.getString("password")).trim();
					if (i==id&&s.equals(password)) {
						System.out.println("登录成功");
						request.getRequestDispatcher("../eroll.jsp").forward(request, response);
					}else {
						request.getRequestDispatcher("../register.jsp").forward(request, response);
					}
				}
				

			} 

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (st != null) {
					try {
						st.close();
						st = null;
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}

			}
		}

	}
}

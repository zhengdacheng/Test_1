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

import entity.Register;
import util.DBHelper;;
/**
 * Servlet implementation class HandleRegister
 */
@WebServlet("/HandleRegister")
public class HandleRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleRegister() {
        super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8"); 
		String password , again_password;
		int qq_id;
		qq_id =Integer.parseInt(request.getParameter("userid").trim());
		password=request.getParameter("password").trim();
		again_password=request.getParameter("again_password").trim();
		if (!password.equals(again_password)) {	
			System.out.println("两次密码不一样");				
			request.getRequestDispatcher("../register.jsp").forward(request, response);
			return;			
		}else {
		Register rg= new Register();
		rg.setPassword(password);
		rg.setQq_id(qq_id);
		System.out.println(qq_id+"-----------"+password);
		//数据库处理代码
		Connection conn=null;
		PreparedStatement pre=null;
		try {
			conn=DBHelper.getConnection();
			String sql ="INSERT into users(qq_id,password) values(?,?)";
			pre = conn.prepareStatement(sql);
			if (qq_id>0&&password.length()>0 ) {
				pre.setInt(1, qq_id);
				pre.setString(2, password);
				
			}
			int i = pre.executeUpdate();
			if (i!=0) {
				System.out.println("INSERT 语句执行成功");
				request.getRequestDispatcher("../login.jsp").forward(request, response);;
			}			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if (pre!=null) {
				try {
					pre.close();
					pre=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}			
		}
	}
	}
}

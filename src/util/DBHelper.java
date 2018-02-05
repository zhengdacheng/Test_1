package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private static final String driver = "com.mysql.jdbc.Driver"; //���ݿ�����
	//�������ݿ��URL��ַ
	private static final String url="jdbc:mysql://localhost:3306/Student?useUnicode=true&characterEncoding=utf-8&useSSL=false"; 
	private static final String username="root";//���ݿ���û���
	private static final String password="zdclhy+.";//���ݿ������
    
	private static Connection conn=null;
	
	static
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace()	;		
		}
	}
	////����ģʽ�������ݿ����Ӷ���
	public static Connection getConnection() throws SQLException {
		if (conn==null) {
			conn=DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;		
	}
	public static void main(String[] args) {
		
		try
		{
		   Connection conn = DBHelper.getConnection();
		   if(conn!=null)
		   {
			   System.out.println("���ݿ�����������");
		   }
		   else
		   {
			   System.out.println("���ݿ������쳣��");
		   }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
}

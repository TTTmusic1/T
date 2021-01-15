package dao;

import java.sql.*;

public class UserDaoImpl {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
	private static final String url= "jdbc:mysql://localhost:3306/music?useSSL=false" ;
	private static final String user= "root" ;
	private static final String password= "123456" ;
	private Connection conn = null ;
	/**
	 * @author ��ķ���Ϲ�
	 * �ڹ��췽������ʱ���������ݿ����Ӷ����ȡ��
	 */
	public UserDaoImpl() {
		try {
			Class.forName(DBDRIVER) ;	// �������ݿ���������
			this.conn = DriverManager.getConnection(url, user,password) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ȡ�����ݿ����Ӷ���
	 * @return ʵ������Connection�����������null����ʾû�����ӳɹ�
	 */
	public Connection getConnection() {
		return this.conn ;
	}
	/**
	 * �������ݿ�Ĺرղ���
	 */
	public void close() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace(); 
			}
		}
	}
}

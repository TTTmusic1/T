package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author ��ķ���Ϲ�
 *
 *����MySQL���ݿ������
 */
public class NewUserImpl {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
	private static final String DBURL = "jdbc:mysql://localhost:3306/music?useSSL=false" ;
	private static final String DBUSER = "root" ;
	private static final String PASSWORD = "123456" ;
	private Connection conn = null ;
	/**
	 * �ڹ��췽������ʱ���������ݿ����Ӷ����ȡ��
	 */
	public NewUserImpl() {
		try {
			Class.forName(DBDRIVER) ;	// �������ݿ���������
			this.conn = DriverManager.getConnection(DBURL, DBUSER,PASSWORD) ;
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

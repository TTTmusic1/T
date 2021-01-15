package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//�û���½
public class UserDao {
	UserDaoImpl user=new UserDaoImpl();
	/**
	 * �û���¼����
	 * @author ��ķ���Ϲ�
	 * 
	 * @param name �û����˻�
	 * @param pwd �˻�������
	 * 
	 * @return �������ݿ����Ƿ���ڶ�Ӧ���ݵı�ǣ�trueΪ���ڣ�falseΪ������
	 */
	public boolean Login(String name,String pwd){
		boolean flag=false;
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		con=user.getConnection();
		try {
			stmt=con.createStatement();//Ԥ�������
			//���ݿ��ѯ���(�����û���������)
			String sql="select * from user where UserName='"+name+"' and Password='"+pwd+"'";
			rs=stmt.executeQuery(sql);//ִ�в�ѯ���
			//rs�������ݣ��򽫱�Ǹ�Ϊtrue
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		    user.close();
		}
		return flag;
	}
}

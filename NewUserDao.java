package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//�û�ע��
public class NewUserDao {
	NewUserImpl newuser=new NewUserImpl();
	/**
	 * @author ��ķ���Ϲ�
	 * �û�ע�Ṧ��
	 * @param name �û����˻�
	 * @param pwd �˻�������
	 * 
	 * @return �������ݿ����Ƿ���ڶ�Ӧ���ݵı�ǣ�trueΪ���ڣ�falseΪ������
	 */
	public boolean Create(String name,String pwd){
		boolean flag=false;
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		con=newuser.getConnection();
		
		try {
			stmt=con.createStatement();//Ԥ�������
			//���ݿ�������
			String sql="insert * from user where UserName='"+name+"' and Password='"+pwd+"'";
			rs=stmt.executeQuery(sql);//ִ�в�ѯ���
			//rs�������ݣ��򽫱�Ǹ�Ϊtrue
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		    newuser.close();
		}
		return flag;
	}
}

package JDBC;

import java.sql.*;



public class JDBCcomment {
    String url = "jdbc:mysql://localhost:3306/music";
    String driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String password = "123456";
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;

    public void connectionDB() {

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}

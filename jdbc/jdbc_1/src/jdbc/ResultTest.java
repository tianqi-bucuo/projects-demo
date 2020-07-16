package jdbc;

import java.sql.*;

public class ResultTest {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "select * from student";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdb?useSSL=false", "root", "026035" );
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            int id = rs.getInt(1);
            System.out.println(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

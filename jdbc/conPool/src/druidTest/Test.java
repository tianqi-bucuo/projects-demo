package druidTest;

import utils.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "insert into users values(null, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"cky");
            pstmt.setString(2,"026035");
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(pstmt, conn);
        }
    }
}

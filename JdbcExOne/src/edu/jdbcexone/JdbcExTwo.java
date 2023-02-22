package edu.jdbcexone;

import java.sql.*;

public class JdbcExTwo {
    public static void main(String[] args) {
        System.out.println("JDBC Start");

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/malldb?useSSL=false&serverTimezone=Asia/Seoul",
                    "root", "dh990921");
            if (conn != null){
                System.out.println("DB 연결 완료");
                stmt = conn.createStatement();
                ResultSet srs = stmt.executeQuery("select * from userTbl");
                System.out.println("\t\t\t----------- userTbl -----------");
                printData(srs, "userID", "name", "birthYear", "addr", "mobile1", "mobile2", "height", "mDate");
                System.out.println();
                System.out.println("\t\t\t----------- buyTbl -----------");
                srs = stmt.executeQuery("select * from buyTbl");
                printbuyData(srs, "num", "userID", "prodName", "groupName", "price", "amount");

            }
        } catch (SQLException e) {
            System.out.println("DB 연결 오류");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 오류");
        }
        finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printbuyData(ResultSet srs, String col1, String col2, String col3, String col4, String col5, String col6) throws SQLException {
        while(srs.next()) {
            if (!col1.equals(""))
                System.out.print(srs.getString("num"));
            if (!col2.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("userID"));
            if (!col3.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("prodName"));
            if (!col4.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("groupName"));
            if (!col5.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("price"));
            if (!col6.equals(""))
                System.out.println("\t|\t" +
                        srs.getString("amount"));
            else
                System.out.println();
        }//end of while(rs.next() )
    }

    private static void printData(ResultSet srs, String col1, String col2, String col3, String col4, String col5, String col6, String col7, String col8) throws SQLException {
        while(srs.next()) {
            if (!col1.equals(""))
                System.out.print(srs.getString("userID"));
            if (!col2.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("name"));
            if (!col3.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("birthYear"));
            if (!col4.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("addr"));
            if (!col5.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("mobile1"));
            if (!col6.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("mobile2"));
            if (!col7.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("height"));
            if (!col8.equals(""))
                System.out.println("\t|\t" +
                        srs.getString("mDate"));
            else
                System.out.println();
        }//end of while(rs.next() )
    }
}

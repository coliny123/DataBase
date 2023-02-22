package edu.jdbcexone;

import java.sql.*;

public class JdbcExOne {
    public static void main(String[] args) {
        System.out.println("JDBC Start");

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // JDBC 드라이버 로드
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sampledb?useSSL=false&serverTimezone=Asia/Seoul",
                    "root", "dh990921");

            if (conn != null){
                System.out.println("DB 연결 완료");
                stmt = conn.createStatement();
                ResultSet srs = stmt.executeQuery("select * from student");  // where문에 의해 name = 이기자만 나옴
                printData(srs, "name", "id", "dept");
                stmt.executeUpdate("insert into student (name, id, dept) values('아무개', '0893012', '컴퓨터공학');");
                // printData(srs, "name", "id", "dept");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 오류");
        } catch (SQLException e){
            System.out.println("DB 연결 오류");
        }
        finally {  // try문에서 오류 있어도 무조건 실행되는 구문
            try {
                stmt.close();  // try{}안에서 만든 객체들 finally에서 close();로 닫아줘야함
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }

    private static void printData(ResultSet srs, String col1, String col2, String col3) throws SQLException {
        while (srs.next()) {
            if (!col1.equals(""))
                System.out.print(srs.getString("name"));
            if (!col2.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("id"));
            if (!col3.equals(""))
                System.out.println("\t|\t" +
                        srs.getString("dept"));
            else
                System.out.println();
        }//end of while(rs.next() )
    }
}

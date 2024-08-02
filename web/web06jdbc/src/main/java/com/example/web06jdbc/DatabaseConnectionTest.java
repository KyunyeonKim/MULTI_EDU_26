package com.example.web06jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionTest {

    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "hr";
    private static final String PASSWORD = "hi123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            System.out.println("Attempting to connect to the database...");

            // 데이터베이스 연결
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful.");

            // 데이터베이스 메타데이터 확인
            if (conn != null) {
                System.out.println("Database URL: " + conn.getMetaData().getURL());
                System.out.println("Database User: " + conn.getMetaData().getUserName());
                System.out.println("Database Product Name: " + conn.getMetaData().getDatabaseProductName());
                System.out.println("Database Product Version: " + conn.getMetaData().getDatabaseProductVersion());
            }

            // 예제 쿼리 실행
            stmt = conn.createStatement();
            String query = "SELECT 1 FROM dual"; // Oracle에서 사용 가능한 쿼리
            stmt.executeQuery(query);
            System.out.println("Query executed successfully.");

        } catch (SQLException e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
            System.out.println("Database connection failed: " + e.getMessage());
        } finally {
            // 자원 해제
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
package com.example.module5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:derby:myDB;create=true";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL);
        createTableIfNeeded(conn);
        return conn;
    }

    private static void createTableIfNeeded(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            if (!doesTableExist("USERINFO",conn)) {
                String sqlCreate = "CREATE TABLE USERINFO" +
                        "(ACCOUNT VARCHAR(255)," +
                        "PASSWORD VARCHAR(255))";
                stmt.execute(sqlCreate);

                String sqlInsert = "INSERT INTO USERINFO (ACCOUNT, PASSWORD) VALUES ('001','1234')";
                stmt.execute(sqlInsert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean doesTableExist(String tableName, Connection conn) {
        try (ResultSet rs = conn.getMetaData().getTables(null,null,tableName.toUpperCase(),null)) {
            return rs.next();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean validateLogin(String username, String password) {
        String query = "SELECT * FROM USERINFO WHERE ACCOUNT = ? AND PASSWORD = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1,username);
            pstmt.setString(2,password);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void addUser(String username, String password) {
        String query = "INSERT INTO USERINFO (ACCOUNT, PASSWORD) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1,username);
            pstmt.setString(2,password);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

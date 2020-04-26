package dataManagement;

import java.sql.*;

public class ConnectionToSQLServer {
    Connection connection;

    public ConnectionToSQLServer() {
        connectToSQLServer();
    }

    public void connectToSQLServer() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; databaseName = StudentManagement";
            String user = "sa";
            String password = "123456";

            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
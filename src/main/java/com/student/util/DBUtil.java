package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver"); --> mysql 5.0 version
        String url = "jdbc:mysql://localhost:3306/samplestudent";
                //  protocol :// server name or domain : port number / databasename
        String user = "root";
        String password = "root@123";
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}

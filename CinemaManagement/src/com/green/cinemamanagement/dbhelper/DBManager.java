package com.green.cinemamanagement.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost/cinema?user=root&password=sapassword";
    private Connection connection = null;

    public DBManager() {

    }

    public Connection getDBManager() {
        if (connection != null) {
            return connection;
        }
        try {
            Class.forName(DRIVER);
            connection= DriverManager.getConnection(DB_CONNECTION);
        }catch (ClassNotFoundException e){
            System.out.println("Could not load Driver : "+e.getMessage());
        }catch (SQLException e){
            System.out.println("SQLExecption : "+e.getMessage());
        }
        System.out.println("Connect DB success! ");
        return connection;
    }
}

package com.ra.ulti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private  static  final String DRIVER_JDBC="com.mysql.cj.jdbc.Driver";
    private  static  final  String URL ="jdbc:mysql://localhost:3306/secsion09_student";
    private static final String USER="dung";
    private static final String PASSWORD="123456";
    public static Connection openConnection(){
        Connection connection = null;
        try {
            Class.forName(DRIVER_JDBC);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static void closeConnection (Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

package com.c1.testproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private Connection con;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://188.166.91.15:3306/fog";
    private static final String ID = "fog";
    private static final String PW = "fog1234";

    public Connection getConnection() {
        con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, ID, PW);  // The connection will be released upon program 
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("\n*** Remember to insert your  ID and PW in the DBConnector class! ***\n");
            System.out.println("error in DBConnector.getConnection()");
            System.out.println(e);
        }
        return con;
    }

    public void releaseConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}


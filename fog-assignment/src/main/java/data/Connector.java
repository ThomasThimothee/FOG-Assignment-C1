package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static final String USER = "fog";
    private static final String USERPW = "fog1234";
    private static final String DBNAME = "fog";
    private static final String HOST = "188.166.91.15";
    
    public static Connection getConnection() {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, USER, USERPW);  
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("\n*** Remember to insert your  ID and PW in the DBConnector class! ***\n");
            System.out.println("error in DBConnector.getConnection()");
            System.out.println(e);
        }
        return null;
    }

    public void releaseConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}


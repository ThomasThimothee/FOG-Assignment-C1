package com.c1.testproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author mathiasjepsen
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = new Connector().getConnection();
                PreparedStatement updateCustomer = null;
        String str = "INSERT INTO customer(email, password, firstName, lastName, address, phone) VALUES (?,?,?,?,?,?);";
        updateCustomer = con.prepareStatement(str);
        con.setAutoCommit(false);
        String email = "Mathias@wpsnet.com";
        String password = "12345678";
        String firstName = "Mathias";
        String lastName = "Jepsen";
        String address = "Kongevejen 438";
        String phone = "30664636";
        updateCustomer.setString(1, email);
        updateCustomer.setString(2, password);
        updateCustomer.setString(3, firstName);
        updateCustomer.setString(4, lastName);
        updateCustomer.setString(5, address);
        updateCustomer.setString(6, phone);

        int rowAffected = updateCustomer.executeUpdate();
        if (rowAffected == 1) {
            con.commit();
        } else {
            con.rollback();
        }
    }
}

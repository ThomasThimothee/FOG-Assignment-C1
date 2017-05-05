/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facades;

import business.Partlist;
import business.parts.Part;
import data.DataMapper;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thomasthimothee
 */
public class OrderFacade {

    public static void createOrder(int customerId, int salesRepId, Timestamp date, Boolean status, double price) {
        try {
            DataMapper dm = new DataMapper();
            dm.createOrder(customerId, salesRepId, date, status, price);
        } catch (SQLException | NullPointerException e) {

        }
    }

    public static int getOrderId(int customerId, Timestamp date) {
        int id = 0;
        try {
            DataMapper dm = new DataMapper();
            id = dm.retrieveOrderId(customerId, date);

        } catch (SQLException | NullPointerException e) {

        }
        return id;
    }

    public static void createOrderLines(Partlist partlist, int orderId) {
        try {
            Iterator partIterator = partlist.getPartList().iterator();
            while (partIterator.hasNext()) {
                Part part = (Part) partIterator.next();
                double standardPrice = getPartPrice(part.getName());
                double finalPrice = part.partPrice(standardPrice);
                createOrderline(part.getName(), orderId, part.getLength(), part.getQuantity(), part.getName(), finalPrice);
            }
        } catch (NullPointerException e) {
        }
    }

    public static double getPartPrice(String partName) {
        double price = 0;
        try {
            DataMapper dm = new DataMapper();
            price = dm.retrievePartPrice(partName);
        } catch (SQLException |NullPointerException e) {
        }
        return price;
    }

    public static void createOrderline(String partName, int orderId, double length, int quantity, String explanation, double price) {
        try {
            DataMapper dm = new DataMapper();
            dm.createOrderline(partName, orderId, length, quantity, explanation, price);
        } catch (SQLException|NullPointerException e) {
        } 
    }
}

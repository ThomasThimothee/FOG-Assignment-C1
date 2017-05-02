/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facades;

import data.DataMapper;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author thomasthimothee
 */
public class OrderFacade {
    
        public static void createOrder(int customerId, int salesRepId, Timestamp date, Boolean status, double price){
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
}

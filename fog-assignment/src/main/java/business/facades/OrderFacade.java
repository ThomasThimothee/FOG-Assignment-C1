/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facades;

import data.DataMapper;
import java.sql.SQLException;

/**
 *
 * @author thomasthimothee
 */
public class OrderFacade {
    
        public static void createOrder(int customerId, int salesRepId, Boolean status, double price){
        try {
            DataMapper dm = new DataMapper();
            dm.createOrder(customerId, salesRepId, status, price);
        } catch (SQLException | NullPointerException e) {

        }
    }

        public static int getOrderId(int customerId, int salesRepId) {
            int id = 0;
        try {
            DataMapper dm = new DataMapper();
            id = dm.retrieveOrderId(customerId, salesRepId);
            
        } catch (SQLException | NullPointerException e) {
            
        }
        return id;
    }
}

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
public class CarportFacade {
    
        public static void createCarport(String concat){
        try {
            DataMapper dm = new DataMapper();
            dm.newCarport(concat);
        } catch (SQLException | NullPointerException e) {

        }
    }
        public static int getCarportId(String concat) {
        int id = 0;
        try {
            DataMapper dm = new DataMapper();
            id = dm.retrieveCarportId(concat);
        } catch (SQLException | NullPointerException e) {

        }
        return id;
    }
}

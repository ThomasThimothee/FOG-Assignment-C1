/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.parts.Part;
import java.util.ArrayList;

/**
 *
 * @author mathiasjepsen
 */
public interface IPartlist {
    
    public ArrayList<Part> createPartList();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author mathiasjepsen
 */
public class Main {
    
    public static void main(String[] args) {
        Flat flat = new Flat("Flat", "Plastmo Ecolite Blue", 480, 180, 300, 150, 100);
        System.out.println(flat.createPartList());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facades;

/**
 *
 * @author Lovro
 */
public class PointyFacade {
    
    public static int[] getCarportWidth() {
        int[] carportWidth = {240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690, 720, 750};
                return carportWidth;
    }
      public static int[] getCarportLength() {
        int[] carportLength = {240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690, 720, 750, 780};
                return carportLength;
}
      public static int[] getShedWidth() {
          int[] shedWidth = {210, 240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690, 720};
          return shedWidth;
      }
      public static int[] getShedLength(){
          int[] shedLength = {150, 180, 210, 240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690};
          return shedLength;
      }
      public static int[] getAngle() {
          int[] angle = {15, 20, 25, 30, 35, 40, 45};
          return angle;
      }
      public static String[] getRoofType() {
          String[] type = {"Plastmo Ecolite Blue"};
                  return type;
      }
}

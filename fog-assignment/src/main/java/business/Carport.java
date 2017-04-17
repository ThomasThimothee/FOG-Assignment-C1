/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;

/**
 *
 * @author thomasthimothee
 */
public class Carport {
    private String type;
    private String roofType;
    private double carportLength;
    private double shedLength;
    private double carportWidth;
    private double shedWidth;
    private double carportHeight;
    private double roofHeight;
    private double nonShedLength;
    private String partList;

    public Carport(String type, String roofType, double carportLength, double shedLength, double carportWidth, double shedWidth, double carportHeight, double roofHeight) {
        this.type = type;
        this.roofType = roofType;
        this.carportLength = carportLength;
        this.shedLength = shedLength;
        this.carportWidth = carportWidth;
        this.shedWidth = shedWidth;
        this.carportHeight = carportHeight;
        this.roofHeight = roofHeight;
        nonShedLength = this.carportLength - this.shedLength;
    }
    
    private List<String> flatRoofBu

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the roofType
     */
    public String getRoofType() {
        return roofType;
    }

    /**
     * @param roofType the roofType to set
     */
    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    /**
     * @return the carportLength
     */
    public double getCarportLength() {
        return carportLength;
    }

    /**
     * @param carportLength the carportLength to set
     */
    public void setCarportLength(double carportLength) {
        this.carportLength = carportLength;
    }

    /**
     * @return the shedLength
     */
    public double getShedLength() {
        return shedLength;
    }

    /**
     * @param shedLength the shedLength to set
     */
    public void setShedLength(double shedLength) {
        this.shedLength = shedLength;
    }

    /**
     * @return the carportWidth
     */
    public double getCarportWidth() {
        return carportWidth;
    }

    /**
     * @param carportWidth the carportWidth to set
     */
    public void setCarportWidth(double carportWidth) {
        this.carportWidth = carportWidth;
    }

    /**
     * @return the shedWidth
     */
    public double getShedWidth() {
        return shedWidth;
    }

    /**
     * @param shedWidth the shedWidth to set
     */
    public void setShedWidth(double shedWidth) {
        this.shedWidth = shedWidth;
    }

    /**
     * @return the carportHeight
     */
    public double getCarportHeight() {
        return carportHeight;
    }

    /**
     * @param carportHeight the carportHeight to set
     */
    public void setCarportHeight(double carportHeight) {
        this.carportHeight = carportHeight;
    }

    /**
     * @return the roofHeight
     */
    public double getRoofHeight() {
        return roofHeight;
    }

    /**
     * @param roofHeight the roofHeight to set
     */
    public void setRoofHeight(double roofHeight) {
        this.roofHeight = roofHeight;
    }

    /**
     * @return the nonShedLength
     */
    public double getNonShedLength() {
        return nonShedLength;
    }

    /**
     * @param nonShedLength the nonShedLength to set
     */
    public void setNonShedLength(double nonShedLength) {
        this.nonShedLength = nonShedLength;
    }

    /**
     * @return the partList
     */
    public String getPartList() {
        return partList;
    }

    /**
     * @param partList the partList to set
     */
    public void setPartList(String partList) {
        this.partList = partList;
    }
    
            
    
}

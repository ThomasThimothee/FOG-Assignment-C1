package business;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author thomasthimothee
 */
public class Order {


    private int orderId, customerId, salesRepId;
    private Timestamp date;
    private String carportType;
    private String roofType;
    private double carportWidth;
    private double carportLength;
    private double shedWidth;
    private double shedLength;
    private double roofHeight;
    private double angle;
    private boolean status;
    private double discount;
    private double standardPrice;
    private double finalPrice;
    
    public ArrayList<String> createVariableArray(Order order) {
        ArrayList<String> array = new ArrayList<>();
        array.add(String.valueOf(order.getOrderId()));
        array.add(String.valueOf(order.getCustomerId()));
        array.add(String.valueOf(order.getSalesRepId()));
        String newDate = new SimpleDateFormat("yyyy-MM-dd").format(order.getDate());    
        
        array.add(newDate);
//        array.add(carportType);
//        array.add(roofType);
//        array.add(String.valueOf(carportWidth));
//        array.add(String.valueOf(carportLength));
//        array.add(String.valueOf(shedWidth));
//        array.add(String.valueOf(shedLength));
//        array.add(String.valueOf(roofHeight));
//        array.add(String.valueOf(angle));
        array.add(String.valueOf(order.isStatus()));
        array.add(String.valueOf(order.getDiscount()));
        array.add(String.valueOf(order.getStandardPrice()));
        array.add(String.valueOf(order.getFinalPrice()));
        return array;
    }
    
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(int salesRepId) {
        this.salesRepId = salesRepId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getCarportType() {
        return carportType;
    }

    public void setCarportType(String carportType) {
        this.carportType = carportType;
    }

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public double getCarportWidth() {
        return carportWidth;
    }

    public void setCarportWidth(double carportWidth) {
        this.carportWidth = carportWidth;
    }

    public double getCarportLength() {
        return carportLength;
    }

    public void setCarportLength(double carportLength) {
        this.carportLength = carportLength;
    }

    public double getShedWidth() {
        return shedWidth;
    }

    public void setShedWidth(double shedWidth) {
        this.shedWidth = shedWidth;
    }

    public double getShedLength() {
        return shedLength;
    }

    public void setShedLength(double shedLength) {
        this.shedLength = shedLength;
    }

    public double getRoofHeight() {
        return roofHeight;
    }

    public void setRoofHeight(double roofHeight) {
        this.roofHeight = roofHeight;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(double standardPrice) {
        this.standardPrice = standardPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

}

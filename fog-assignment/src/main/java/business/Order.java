package business;

import java.sql.Timestamp;

/**
 *
 * @author thomasthimothee
 */
public class Order {

    private int orderId;
    private Customer customer;
    private Employee employee;
    private Carport carport;
    private Timestamp date;
    private boolean status;
    private double discount;
    private double standardPrice;
    private double finalPrice;

    public int getOrderId() {
        return orderId;
    }

    public Order setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Order setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public Carport getCarport() {
        return carport;
    }

    public Order setCarport(Carport carport) {
        this.carport = carport;
        return this;
    }

    public Timestamp getDate() {
        return date;
    }

    public Order setDate(Timestamp date) {
        this.date = date;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public Order setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public double getDiscount() {
        return discount;
    }

    public Order setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public double getStandardPrice() {
        return standardPrice;
    }

    public Order setStandardPrice(double standardPrice) {
        this.standardPrice = standardPrice;
        return this;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public Order setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
        return this;
    }
    


}

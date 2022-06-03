package entity;

import java.util.Date;

public class Visit extends Customer {

    public Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(String name, Date date) {
        super(name);
        customer = new Customer(name);
        this.date = date;
    }

    public String getName() {
        return customer.getName();
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double ex) {
        this.serviceExpense = ex;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double ex) {
        this.productExpense = ex;
    }

    public double getTotalExpense() {
        double productDiscountRate = 0;
        double serviceDiscountRate = 0;
        if (customer.isMember()) {
            productDiscountRate = DiscountRate.getProductDiscountRate(customer.getMemberType());
            serviceDiscountRate = DiscountRate.getServiceDiscountRate(customer.getMemberType());
        }
        return this.serviceExpense * (1 - serviceDiscountRate) + this.productExpense * (1 - productDiscountRate);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "customer=" + customer +
                ", date=" + date +
                ", serviceExpense=" + serviceExpense +
                ", productExpense=" + productExpense +
                '}';
    }
}

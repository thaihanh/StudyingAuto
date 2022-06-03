package main;

import entity.Customer;
import entity.Visit;

import java.text.DecimalFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("hanh");
        customer.setMember(true);
        customer.setMemberType("Gold");

        Date date = new Date();
        Visit visit = new Visit("hanh", date);
        visit.setProductExpense(5.3);
        visit.setServiceExpense(6.3);
        visit.customer.setMemberType("Premium");
        visit.customer.setMember(true);

        System.out.println(customer);
        System.out.println(visit);

        //Compute the total bill if a customer purchases $x of products and $y of services, for a visit
        System.out.println(Math.round(visit.getTotalExpense() * 100.0) / 100.0);

        //DecimalFormat f = new DecimalFormat("##.00");
        //System.out.println(f.format(visit.getTotalExpense()));
    }

}

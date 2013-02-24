/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmb.discountstrategy;

/**
 *
 * @author tim
 */
public class Customer {
    
    private String customerId;
    private String customerName;

    // Constructor: requires customerId and customerName
    public Customer(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    } 

    public final void getCustomer() {
        System.out.println(customerId + "\t" + customerName);
    }
}

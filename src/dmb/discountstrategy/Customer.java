package dmb.discountstrategy;

/**
 *
 * @author Dawn Bykowski
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
        if (customerId != null) {
            this.customerId = customerId;
        } else {
            System.out.println("Customer Id cannot be blank");
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if (customerName != null) {
            this.customerName = customerName;
        } else {
            System.out.println("Customer name cannot be blank");
        }
    }

    public final void getCustomer() {
        System.out.println(customerId + "\t" + customerName);
    }
}

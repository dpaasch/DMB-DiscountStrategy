package dmb.discountstrategy;

/**
 * This class is responsible for maintaining information on the customer.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class Customer {

    private String customerId;
    private String customerName;

    // Constructor: requires customerId and customerName
    public Customer(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    /**
     * This method gets the customer id, which is a number unique to the
     * customer.
     *
     * @return the customer identifier
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method sets the customer identifier to the value entered by the
     * user.
     *
     * @param customerId
     */
    public void setCustomerId(String customerId) {
        if (customerId != null) {
            this.customerId = customerId;
        } else {
            System.out.println("Customer Id cannot be blank");
        }
    }

    /**
     * This method gets the customer name.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method sets the customer name to the value entered by the user.
     *
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        if (customerName != null) {
            this.customerName = customerName;
        } else {
            System.out.println("Customer name cannot be blank");
        }
    }

    /** This method represents the state of the customer object. */
    @Override
    public String toString() {
        String customer = customerId + customerName;
        return customer;
    }
}
//    public final void getCustomer() {
//        System.out.println(customerId + "\t" + customerName);
//    }


package dmb.discountstrategy;

/**
 * This is a Low-level class that is responsible for providing a discount on the 
 * quantity of items purchased.
 *
 * @author dawn bykowski, dpaasch@my.wctc.edu
 */
public class QuantityDiscount implements DiscountStrategy {

    private double discountRate = .10;

    // No-arg constructor
    public QuantityDiscount() {
    }

    // Constructor: accepts discountRate as parameter
    public QuantityDiscount(double discountRate) {
        this.discountRate = discountRate;
    }

    /** This method gets the discount rate.
     * @return the discounted rate */
    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    /** This method sets the discounted rate to the value specified by the 
     * parameter.
     * @param discountRate */
    @Override
    public void setDiscountRate(double discountRate) {
        // Validation of discountRate parameter
        if (discountRate <= 0.00) {
            System.out.println("Discount Rate cannot be 0.00");
        } else {
            this.discountRate = discountRate;
        }
    }

    /** This method calculates the discount given the cost and the quantity. 
     * @param cost
     * @param quantity
     * @return discount amount */
    @Override
    public double getDiscount(double cost, int quantity) {
        if (quantity >= 3) {
            return cost * quantity * discountRate;
        } else {
            return 0.00;
        }
    }
//    public static void main(String[] args) {
//        QuantityDiscount discount = new QuantityDiscount();
//        double amount = discount.getDiscount(10, 6);
//        System.out.println(amount);
//    }
}

package dmb.discountstrategy;

/**
 * This is a Low-level class that is responsible for providing a $0.00 amount 
 * discount on items purchased.
 *
 * @author dawn bykowski, dpaasch@my.wctc.edu
 */
public class NoDiscount implements DiscountStrategy {

    private double discountRate = 0.00;

    /** No-argument constructor */
    public NoDiscount() {
    }
    
    /** Constructor: accepts discountRate as parameter */
    public NoDiscount(double discountRate) {
        this.discountRate = discountRate;
    }

    /** This method gets the discount rate.
     * 
     * @return the discounted rate */
    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    /** This method sets the discounted rate to the value specified by the 
     * parameter.
     * 
     * @param discountRate */
    @Override
    public void setDiscountRate(double discountRate) {
        // Validation of discountRate parameter
        if (discountRate < 0.00 || discountRate > 0.00) {
            System.out.println("Discount Rate cannot be greater than 0.00");
        } else {
            this.discountRate = discountRate;
        }
    }

    /** This method calculates the discount given the cost and the quantity.
     * 
     * @param cost
     * @param quantity
     * @return discount amount */
    @Override
    public double calculateDiscount(double cost, int quantity) {
        if (cost <= 0.00) {
            System.out.println("Cost must be greater than 0.00");
        } 
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0");
        }
        if (cost <= 0.00 && quantity <= 0) { 
            System.out.println("Cost & Quantity must be greater than 0");
        }
        return discountRate;
    }

//    public static void main(String[] args) {
//        NoDiscount discount = new NoDiscount();
//        double amount = discount.getDiscount(10, 2);
//        double amount = discount.getDiscount(1, 0);
//        double amount = discount.getDiscount(0.00, 1);
//        System.out.println(amount);
//        discount.setDiscountRate(1.00);
//        System.out.println(discount.getDiscountRate());
//    }
}

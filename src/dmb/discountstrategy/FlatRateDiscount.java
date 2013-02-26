package dmb.discountstrategy;

/**
 * A Low-level class that calculates a discount
 *
 * @author dawn bykowski
 */
public class FlatRateDiscount implements DiscountStrategy {

    private double discountRate = .10;

    // No-arg constructor
    public FlatRateDiscount() {
    }

    // Constructor: accepts discountRate as parameter
    public FlatRateDiscount(double discountRate) {
        this.discountRate = discountRate;
    }

    // Accessor / Mutator Methods from Discount Strategy
    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        // Validation of discountRate parameter
        if (discountRate <= 0.00) {
            System.out.println("Discount Rate cannot be 0.00");
        } else {
            this.discountRate = discountRate;
        }
    }

    @Override
    public double getDiscount(double cost, int quantity) {
         if (cost <= 0.00) {
            System.out.println("Cost must be greater than 0.00");
        } 
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0");
        }
        if (cost <= 0.00 && quantity <= 0) { 
            System.out.println("Cost & Quantity must be greater than 0");
        }
        return cost * quantity * discountRate;
    }
//    public static void main(String[] args) {
//        FlatRateDiscount discount = new FlatRateDiscount();
//        double amount = discount.getDiscount(10,2);
//        System.out.println(amount);
//    }
}

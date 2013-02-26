package dmb.discountstrategy;

/**
 * Low-level class provides the amount of the discount on the quantity
 * purchased.
 *
 * @author Dawn Bykowski
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

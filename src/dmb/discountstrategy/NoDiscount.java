package dmb.discountstrategy;

/**
 * Low level class returns a $0.00 amount.
 *
 * @author Dawn Bykowski
 */
public class NoDiscount implements DiscountStrategy {

    private double discountRate = 0.00;

    // No-arg constructor
    public NoDiscount() {
    }
    
    // Constructor: accepts discountRate as parameter
    public NoDiscount(double discountRate) {
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
        if (discountRate < 0.00 || discountRate > 0.00) {
            System.out.println("Discount Rate cannot be greater than 0.00");
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

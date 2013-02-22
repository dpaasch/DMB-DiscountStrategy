package dmb.discountstrategy;

/**
 * Low level class provides a $0.00 amount.
 * @author Dawn Bykowski
 */
public class NoDiscount implements DiscountStrategy {
    private double discountRate = 0.00;

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    @Override
    public double getDiscount(double price, int quantity) {
        return discountRate;
    }

//    public static void main(String[] args) {
//        NoDiscount discount = new NoDiscount();
//        double amount = discount.getDiscount(10,2);
//        System.out.println(amount);
//    }
}

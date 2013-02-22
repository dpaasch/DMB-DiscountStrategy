package dmb.discountstrategy;

/**
 * A Low-level class that calculates a discount
 * @author dawn bykowski
 */
public class FlatRateDiscount implements DiscountStrategy {
    private double discountRate = .10;

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
        return price * quantity * discountRate;
    }
    
    public static void main(String[] args) {
        FlatRateDiscount discount = new FlatRateDiscount();
        double amount = discount.getDiscount(10,2);
        System.out.println(amount);
    }
}

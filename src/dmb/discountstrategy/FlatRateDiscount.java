package dmb.discountstrategy;

/**
 * A Low-level class that calculates a discount
 * @author dawn bykowski
 */
public class FlatRateDiscount implements DiscountStrategy {
    private double discountRate = .10;

    public FlatRateDiscount() {
    }

    public FlatRateDiscount(double discountRate) {
        this.discountRate = discountRate; 
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double getDiscount(double cost, int quantity) {
        return cost * quantity * discountRate;
    }
    
//    public static void main(String[] args) {
//        FlatRateDiscount discount = new FlatRateDiscount();
//        double amount = discount.getDiscount(10,2);
//        System.out.println(amount);
//    }
}

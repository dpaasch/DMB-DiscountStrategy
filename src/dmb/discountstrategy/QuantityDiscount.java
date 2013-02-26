package dmb.discountstrategy;

/**
 * Low-level class provides the amount of the discount on the quantity
 * purchased.
 *
 * @author Dawn Bykowski
 */
public class QuantityDiscount implements DiscountStrategy {

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
    public double getDiscount(double cost, int quantity) {
        if (quantity >= 5) {
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

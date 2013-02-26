package dmb.discountstrategy;

/**
 * Lab #1 Activity: build just the strategy class hierarchy for the discount 
 * strategies. Now test it. Write a test class with a main method and use the 
 * liskov substitution principal and hard coded input to test that your strategy 
 * objects work as expected. 
 * 
 * @author Dawn Bykowski
 */
public interface DiscountStrategy {

    public abstract double getDiscount(double cost, int quantity);

    public abstract double getDiscountRate();

    public abstract void setDiscountRate(double discountRate);
    
}

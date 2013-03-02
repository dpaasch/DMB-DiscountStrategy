package dmb.discountstrategy;

/**
 * This is an abstraction class that is responsible for providing common discount 
 * rate and discount calculation methods for the low-level classes to use.
 *
 * @author dawn bykowski, dpaasch@my.wctc.edu
 */
public interface DiscountStrategy {

    /** This method calculates the discount given the cost and the quantity. 
     * @param cost
     * @param quantity
     * @return discount amount */
    public abstract double getDiscount(double cost, int quantity);

    /** This method gets the discount rate.
     * @return the discounted rate */
    public abstract double getDiscountRate();

    /** This method sets the discounted rate to the value specified by the 
     * parameter.
     * @param discountRate */
    public abstract void setDiscountRate(double discountRate);
    
}

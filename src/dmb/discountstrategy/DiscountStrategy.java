/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmb.discountstrategy;

/**
 *
 * @author Dawn Bykowski
 */
public interface DiscountStrategy {

    public abstract double getDiscount(double price, int quantity);

    public abstract double getDiscountRate();

    public abstract void setDiscountRate(double discountRate);
    
}

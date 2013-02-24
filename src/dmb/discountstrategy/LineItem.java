package dmb.discountstrategy;

/**
 * Lab #3: Create a LineItem class that has a Product component. Think about
 * what a LineItem class should be responsible for? Given a prodId it should be
 * able to lookup the product in the database, create the product and store it
 * internally as a property. Then, it should be able to return all the
 * information about that lineItem that the receipt would need to know. Now
 * write some test code in this class to see if it works.
 *
 * @author Dawn Bykowski
 */
public class LineItem {

    private String productId;
    private int quantity;
    private Product product;

    public LineItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
        
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitCost() {
        return product.getUnitCost();
    }

    public double getSubtotal() {
        double savings = (product.getUnitCost() * quantity) 
                - product.getDiscount(quantity);
        return savings;
    }
    
    public final String getLineItem() {
        double extCost = (getUnitCost() * quantity);
        return product.getProductId() + " " + product.getProductName() + " "
                + getUnitCost() + " " + quantity + " " + extCost + " "
                + product.getDiscount(quantity);
    }

//    public static void main(String[] args) {
//        LineItem lineItem = new LineItem("A101",3);
//        System.out.println(lineItem.getLineItem());
//    }
}
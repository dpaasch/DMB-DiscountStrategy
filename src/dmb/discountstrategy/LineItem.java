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

    public double getExtendedUnitCost() {
        return (product.getUnitCost() * quantity);
    }

    public final String getLineItem() {
        String prodId = product.getProductId();
        String prodName = product.getProductName();
        double unitCost = product.getUnitCost();
        int qty = quantity;
        double extCost = getExtendedUnitCost();
        double discount = product.getDiscount(quantity);
        return  prodId + "\t" + prodName + "\t" + unitCost + "\t" + qty + "\t" 
                + extCost + "\t" + discount;
    }

//    public static void main(String[] args) {
//        LineItem lineItem = new LineItem("A101",3);
//        System.out.println(lineItem.getLineItem());
//    }
}
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
    private double extendedUnitCost;
    private Product product;

    public LineItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
        product = new Product();
    }

    public Product getProductId(String productId) {
        return product.findProduct(productId);
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getExtendedUnitCost() {
        return extendedUnitCost;
    }

    public void setExtendedUnitCost(double extendedUnitCost) {
        this.extendedUnitCost = extendedUnitCost;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getLineItem() {
        return product.toString();
    }

    public static void main(String[] args) {
        LineItem lineItem = new LineItem("A100", 3);
        System.out.println(lineItem.getLineItem());

    }
}

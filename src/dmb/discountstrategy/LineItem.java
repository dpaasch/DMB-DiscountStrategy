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
    private double itemTotalBefore;
    private double itemTotalAfter;
    private Product product;

    public LineItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
        product = new Product("A100", "Queensize Comforter", 150.00,
                new FlatRateDiscount());
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getItemTotalBeforeDiscount() {
        itemTotalBefore = (product.getUnitCost() * quantity);
        return itemTotalBefore;
    }

    public double getItemTotalAfterDiscount() {
        itemTotalAfter = (product.getUnitCost() * quantity)
                - product.getDiscount(quantity);
        return itemTotalAfter;
    }
    
    public double getItemTotalSavings() {
        double itemSavings = itemTotalBefore - itemTotalAfter;
        return itemSavings;
    }

    public final String getLineItem() {
        return "Id " + "     Product Name \t\t" + " Unit Cost \t"
                + " Quantity \t" + " Amount Saved \n"
                + "----------------------------------------------------------"
                + "-------------------\n"
                + product.getProductId() + "\t" + product.getProductName() + " \t "
                + product.getUnitCost() + " \t\t " + quantity + " \t\t "
                + product.getDiscount(quantity);
    }

    public static void main(String[] args) {
        LineItem lineItem = new LineItem("A101", 3);
        System.out.println(lineItem.getQuantity());
        System.out.println(lineItem.getItemTotalBeforeDiscount());
        System.out.println(lineItem.getItemTotalAfterDiscount());
        System.out.println(lineItem.getItemTotalSavings());
        System.out.println(lineItem.getLineItem());
    }
}
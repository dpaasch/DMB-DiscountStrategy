package dmb.discountstrategy;

import java.text.DecimalFormat;

/**
 * This class is responsible for gathering information from the product class to
 * be used in creating the line item for the Receipt class.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class LineItem {

    private int quantity;
    private Product product;

    // Constructor: Accepts productId, which it finds in the database, and the
    // quantity as parameters.
    public LineItem(String productId, int quantity) {
        FakeDatabase db = new FakeDatabase();
        product = db.findProduct(productId);
        this.quantity = quantity;
//        product = new Product("A100", "Queensize Comforter", 150.00,
//                new FlatRateDiscount());  // creating product here is rigid!
    }

    // Constructor: Accepts a product and quantity as parameters.
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /** This method gets the quantity of the product being purchased.     
     * @return quantity */
    public int getQuantity() {
        return quantity;
    }

    /** This method sets the quantity provided by the user     
     * @param quantity */
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity must be greater than 0");
        }
    }

    /** This method gets the subtotal by calculating the unit cost * quantity.
     * @return total */
    public double getSubtotal() {
        double total = product.getUnitCost() * quantity;
        return total;
    }

    /** This method gets the amount of the discount from the product class.
     * @return the amount of the discount */
    public double getDiscount() {
        double discount = product.getDiscount(quantity);
        return discount;
    }

    /** This method gets the information for the line item that is created within
     * the Receipt class.
     * @return line item values */
    public final String getLineItem() {
        String pId = product.getProductId();
        String pName = product.getProductName();
        double uCost = product.getUnitCost();
        double extendedCost = (product.getUnitCost() * quantity);
        double pDiscount = product.getDiscount(quantity);
        
        // Create a decimal format object to format the dollar amounts
        DecimalFormat df = new DecimalFormat("$#,##0.00");  
        return pId + "   " + pName + "   " + df.format(uCost) + " \t " + quantity
                + "\t" + df.format(extendedCost) + "\t\t" + df.format(pDiscount);
    }
//    public static void main(String[] args) {
//        LineItem lineItem = new LineItem("A101", 3);
//        System.out.println(lineItem.getQuantity());
//        System.out.println(lineItem.getSubtotal());
//        System.out.println(lineItem.getDiscount());
//        System.out.println(lineItem.getLineItem());
//        Product prod = new Product("A100", "Queensize Comforter", 150.00,
//                new FlatRateDiscount());
//        LineItem item = new LineItem(prod, 3);
//        System.out.println(item.getLineItem());
//    }
}
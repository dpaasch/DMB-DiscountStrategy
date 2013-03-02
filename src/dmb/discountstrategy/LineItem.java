package dmb.discountstrategy;

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
    // quantity.
    public LineItem(String productId, int quantity) {
        FakeDatabase db = new FakeDatabase();
        product = db.findProduct(productId);
        this.quantity = quantity;
//        product = new Product("A100", "Queensize Comforter", 150.00,
//                new FlatRateDiscount());  // creating product here is rigid!
    }

    // Constructor: Accepts a product and quantity
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * This method gets the quantity of the product being purchased.
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method sets the quantity provided by the user
     * @param quantity
     */
    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0");

        }
        this.quantity = quantity;
    }

    public double getSubtotal() {
        double total = product.getUnitCost() * quantity;
        return total;
    }

    public double getDiscount() {
        double discount = product.getDiscount(quantity);
        return discount;
    }

    public final String getLineItem() {
        return product.getProductId() + " \t " + product.getProductName() + " \t "
                + product.getUnitCost() + " \t\t " + quantity + " \t\t "
                + (product.getUnitCost() * quantity) + " \t\t "
                + product.getDiscount(quantity);
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
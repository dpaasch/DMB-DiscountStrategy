package dmb.discountstrategy;

/**
 * This class will act as our database for the time being, holding both the
 * customer and the product arrays full of data.
 *
 * @author Dawn Bykowski
 */
public class FakeDatabase {


    // Customer Array
    private Customer[] customers = {
        new Customer("1001","Francesca Piccinini"),
        new Customer("1002","Dale Earnhardt Jr."),
        new Customer("1003","Natalie Gulbis"),
        new Customer("1004","Donald Driver"),
        new Customer("1005","Tina Charles"),
        new Customer("1006","Kevin Durant"),
        new Customer("1007","Michelle Wie"),
        new Customer("1008","Phil Mickelson"),
        new Customer("1009","Natalie Coughlin"),
        new Customer("1010","Ricky Fowler")};
    // Products Array
   private Product[] products = {
        new Product("92303192","4-pc. Comforter Set - Queen",359.99,new FlatRateDiscount()),
        new Product("93056001","Sateen Sheet Set - Queen   ",149.99,new FlatRateDiscount()),
        new Product("92021665","Regular Jeans - Men        ", 58.00,new QuantityDiscount()),
        new Product("90889775","Classic-Fit Pleated Pants  ", 55.00,new FlatRateDiscount()),
        new Product("93099876","Solid Pique Polo           ", 39.50,new QuantityDiscount()),
        new Product("89174290","3-pk. Cushioned-Sole Socks ", 18.00,new QuantityDiscount()),
        new Product("93208741","Colorblock Sheath Dress    ", 90.00,new NoDiscount()),
        new Product("90261977","Curvy Bootcut Jeans        ", 54.00,new QuantityDiscount()),
        new Product("93516223","Solid Empire Knot-Front Top", 36.00,new FlatRateDiscount()),
        new Product("93017033","Floral Net-to-Waist Tights ", 12.50,new NoDiscount())};

    /** 
     * This method is used to find the customer within the database by it's id.
     * 
     * @return customer information (returns null if not found)
     */
   public final Customer findCustomer(final String custId) {
        // validation is needed
        Customer customer = null;
        for (Customer c : customers) {
            if (custId.equals(c.getCustomerId())) {
                customer = c;
                break;
            }
            // Requires additional validation, such as a NullPointerException
            // error for a null value.        
        }

        return customer;
    }

   /** 
    * This method is used to find the product information within the database by
    * it's id.
    * 
    * @return product information (returns null if not found)
    */
    public final Product findProduct(final String prodId) {
        // validation is needed
        Product product = null;
        for (Product p : products) {
            if (prodId.equals(p.getProductId())) {
                product = p;
                break;
            }
            // Requires additional validation, such as a NullPointerException
            // error for a null value.            
        }
        return product;
    }
}


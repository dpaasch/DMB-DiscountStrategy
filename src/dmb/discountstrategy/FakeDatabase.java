package dmb.discountstrategy;

/**
 * This class will act as our database for the time being, holding both the
 * customer and the product arrays full of data.
 *
 * @author Dawn Bykowski
 */
public class FakeDatabase {


    // Customer Array
    Customer[] customers = {
        new Customer("1001", "Francesca Piccinini"),
        new Customer("1002", "Dale Earnhardt Jr."),
        new Customer("1003", "Natalie Gulbis"),
        new Customer("1004", "Donald Driver"),
        new Customer("1005", "Tina Charles"),
        new Customer("1006", "Kevin Durant"),
        new Customer("1007", "Michelle Wie"),
        new Customer("1008", "Phil Mickelson"),
        new Customer("1009", "Natalie Coughlin"),
        new Customer("1010", "Ricky Fowler")};
    // Products Array
   Product[] products = {
        new Product("A100", "Queensize Comforter", 150.00, new FlatRateDiscount()),
        new Product("A110", "Queensize Sheetset", 45.75, new NoDiscount()),
        new Product("B101", "Men's Dress Shirt - Peacock Blue", 35.50, new QuantityDiscount()),
        new Product("B200", "Men's Golf Slacks - Black", 44.75, new FlatRateDiscount()),
        new Product("B278", "Men's Belt - Large", 18.95, new QuantityDiscount()),
        new Product("C410", "Women's Dress - Medium", 38.50, new NoDiscount()),
        new Product("C222", "Women's Tights - Navy", 12.50, new QuantityDiscount()),
        new Product("D268", "Bath Towel - Beige", 18.95, new FlatRateDiscount()),
        new Product("D345", "Hand Towel - Beige", 12.50, new NoDiscount()),
        new Product("D654", "Washcloth - Beige", 12.50, new QuantityDiscount())};

    public final Customer findCustomer(final String custId) {
        // validation is needed
        Customer customer = null;
        for (Customer c : customers) {
            if (custId.equals(c.getCustomerId())) {
                customer = c;
                break;
            }
        }

        return customer;
    }

    // Just call this method to find a product in the array by its id.
    // Returns null if not found.
    public final Product findProduct(final String prodId) {
        // validation is needed
        Product product = null;
        for (Product p : products) {
            if (prodId.equals(p.getProductId())) {
                product = p;
                break;
            }
        }

        return product;
    }
}


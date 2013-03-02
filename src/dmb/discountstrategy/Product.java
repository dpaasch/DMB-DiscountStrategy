package dmb.discountstrategy;

/**
 * This is a High-level class that is responsible for providing the product
 * information and it's discount on items purchased.
 *
 * @author dawn bykowski, dpaasch@my.wctc.edu
 */
public class Product {

    private String productId;
    private String productName;
    private double unitCost;
//    private FlatRateDiscount discount;
//    private QuantityDiscount discount;
//    private NoDiscount discount;
    private DiscountStrategy discount;

    // Constructor takes productId, productName, unitCost, and discount.
    //    public Product(String prodId, String prodName, double cost) {
    public Product(String productId, String productName, double unitCost,
            DiscountStrategy discount) {
        this.productId = productId;
        this.productName = productName;
        this.unitCost = unitCost;
//        discount = new FlatRateDiscount();
//        discount = new QuantityDiscount();
//        discount = new NoDiscount();
        this.discount = discount;
    }

    // No-arg constructor, in case it is needed.
    public Product() {
    }

    /**
     * This method gets the amount of the discount, after a quantity has been
     * provided.
     * @param quantity
     * @return the amount of the discount
     */
    public double getDiscount(int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0");
        }
        return discount.getDiscount(unitCost, quantity);
    }

    /**
     * This method gets the product id, which is a number unique to the product.
     * @return the product identifier
     */
    public String getProductId() {
        return productId;
    }

    /** 
     * This method sets the product identifier to the value entered by the user.
     * @param productId
     */
    public void setProductId(String productId) {
        if (productId == null) {
            System.out.println("The productId cannot be blank");
        }
        this.productId = productId;
    }

    /**
     * This method gets the product name.
     * @return the product name
     */
    public String getProductName() {
        return productName;
    }

    /** 
     * This method sets the product name to the value entered by the user.
     * @param productName
     */
    public void setProductName(String productName) {
        if (productName == null) {
            System.out.println("The product name cannot be blank");
        }
        this.productName = productName;
    }

    /**
     * This method gets the product unit cost to be used in calculating the
     * discount later.
     * @return the unit cost
     */
    public double getUnitCost() {
        return unitCost;
    }

    /**
     * This method sets the product unit cost to the value entered by the user.
     * @param unitCost 
     */
    public void setUnitCost(double unitCost) {
        if (unitCost <= 0.00) {
            System.out.println("The unit cost must be greater than 0.00");
        }
        this.unitCost = unitCost;
    }
//    public static void main(String[] args) {
//        Product product = new Product("123", "Scarf", 20.00);
//        double amt = discount.getDiscount(15);
//        System.out.println(amt);
//        DiscountStrategy discount = new FlatRateDiscount();
//        DiscountStrategy discount = new QuantityDiscount();
//        DiscountStrategy discount = new NoDiscount();
//        discount.setDiscountRate(.10);
//        double amt = discount.getDiscount(10.00, 5);
//        System.out.println(amt);
//    }
}

package dmb.discountstrategy;

/**
 * High-level class provides the product information and it's discount.
 *
 * @author Dawn Bykowski
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
    public double getDiscount(int quantity) {
        return discount.getDiscount(unitCost, quantity);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
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

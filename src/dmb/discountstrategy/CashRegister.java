package dmb.discountstrategy;

/**
 * This class is responsible for beginning the transaction, adding line items
 * to the Receipt and finalizing the transaction.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class CashRegister {  

    private Receipt receipt;
    
    public CashRegister() {
        this.receipt = new Receipt();
    }
    
    /** This method starts the sale by validating the customer id and starting
     * a new receipt.
     * @param customerId */
    public final void startSale(String customerId) {
        if (customerId != null) {
        receipt.getCustomer(customerId);
    } else {
            System.out.println("Customer Id cannot be blank");
        }
    }
    
    /**This method adds a line item to the receipt after receiving the productId
     * and the quantity
     * @param productId
     * @param quantity */
    public final void addLineItem(String productId, int quantity) {
        if (productId == null) {
            System.out.println("Product Id cannot be blank");
        }
        if (quantity == 0) {
            System.out.println("Quantity must be greater than 0");
        }
        if (productId == null && quantity == 0) {
            System.out.println("Product Id cannot be blank and Quantity must be"
                    + " greater than 0");
        }
        receipt.addLineItem(productId, quantity);
    }
    
    /** This method finalizes the sale and generates the required receipt. */
    public final void finalizeSale() {
        receipt.generateReceipt();
    }
    
//    public static void main(String[] args) {
//        Receipt receipt = new Receipt();
//        receipt.getCustomer("1005");
//        receipt.addItemToSale("A100", 3);
//        receipt.addItemToSale("C410", 2);
//        receipt.addItemToSale("C222", 6);
//        receipt.generateReceipt();
//    }
}

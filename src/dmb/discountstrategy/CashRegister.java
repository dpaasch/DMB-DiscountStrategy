package dmb.discountstrategy;

/**
 * Lab #5: Create a CashRegister class and a Startup class. Write code to hook
 * everything together.
 *
 * @author Dawn Bykowski
 */
public class CashRegister {  

    private Receipt receipt;
    
    public CashRegister() {
        this.receipt = new Receipt();
    }
    
    public final void getCustomer(String customerId) {
        receipt.getCustomer(customerId);
    }
    
    public final void addItemToSale(String prodId, int qty) {
        receipt.addItemToSale(prodId, qty);
    }
    
    public final void finalizeSale() {
        receipt.generateReceipt();
    }
    
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.getCustomer("1005");
        receipt.addItemToSale("C410", 2);
        receipt.addItemToSale("C222", 4);
        receipt.generateReceipt();
    }
}

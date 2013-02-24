package dmb.discountstrategy;

import java.text.DecimalFormat;

/**
 * Lab #4: Create a Receipt class that has an array of LineItem objects, and a
 * Customer property. Now give it some responsibilities. Think carefully about
 * these. Then test.
 *
 * @author Dawn Bykowski
 */
public class Receipt {

    private LineItem[] lineItems = new LineItem[0];
    private Customer customer;

    //Retrieve customer information from the database
    public String getCustomer(String customerId) {
        FakeDatabase fakeDatabase = new FakeDatabase();
        customer = fakeDatabase.findCustomer(customerId);
        return customerId ;
    }

    // Retrieve product information from the database
    public final void addItemToSale(String prodId, int qty) {
        FakeDatabase fakeDatabase = new FakeDatabase();
        Product product = fakeDatabase.findProduct(prodId);
        if (product != null) {
            addLineItem(product, qty);
        }
    }

    public final void addLineItem(Product product, int qty) {
        LineItem item = new LineItem(product, qty);
        addToArray(item);
    }

    private final void addToArray(LineItem item) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

    public final double getSubTotal() {
        double sTotal = 0.00;
        for (int i = 0; i < lineItems.length; i++) {
            sTotal += (lineItems[i].getItemTotalBeforeDiscount());
        }
        return sTotal;
    }

    public final double getDiscountedTotal() {
        double dTotal = 0.00;
        for (int i = 0; i < lineItems.length; i++) {
            dTotal += (lineItems[i].getItemTotalAfterDiscount());
        }
        return dTotal;
    }

    public final double getFinalTotal() {
        double gTotal = 0.00;
        for (int i = 0; i < lineItems.length; i++) {
            gTotal += (getSubTotal() - getDiscountedTotal());
        }
        return gTotal;
    }
    
    public final void generateReceipt() {        
        System.out.println("ID\t" + "Customer Name");
//        System.out.println("----------------------------------");
        customer.getCustomer();
        System.out.println("==================================");
        System.out.println("Prod ID" + "  Prod Name\t" + "Qty\t" 
                + "Unit Price\t" + "Subtotal");
        for (int i = 0; i < lineItems.length; i++) {
            System.out.println(lineItems[i].getLineItem());
        }
        // Create a DecimalFormat object to better display the pay rate
        DecimalFormat dollar = new DecimalFormat("#,##0.00");
        System.out.println();        
        System.out.println("Total Before Discount: \t" + dollar.format(getSubTotal()));
        System.out.println("Total With Discount: \t" + dollar.format(getDiscountedTotal()));
        System.out.println("Final Total: \t\t" + dollar.format(getFinalTotal()));
    }    

//    public static void main(String[] args) {
//        Receipt receipt = new Receipt();
//        receipt.getCustomer("1003");
//        receipt.generateReceipt();
//    }
}
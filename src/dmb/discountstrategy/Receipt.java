package dmb.discountstrategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is responsible for gathering the customer information, creating
 * the line items, calculating the subtotal, discount amount, grand total, and
 * generating the receipt.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class Receipt {

    private List<LineItem> lineItems = new ArrayList<LineItem>();
    private Customer customer;
    
    /** No-argument constructor */
    public Receipt() {
        
    }
    /** Constructor: accepts customer parameter (must have a customer to begin a
     * transaction (receipt) */
    public Receipt(Customer customer){
        
    }

    /**
     * This method is responsible for obtaining the customer information from
     * the database.
     *
     * @return customer number and customer name
     */
    public String getCustomer(String customerId) {
            FakeDatabase fakeDatabase = new FakeDatabase();
            customer = fakeDatabase.findCustomer(customerId);
            return customerId;
            // TO DO: need to add valition to this method
    }

    /**
     * This method generates a new line item and then adds it to the line item
     * array.
     *
     * @param productId
     * @param quantity
     */
    public final void addLineItem(String productId, int quantity) {
        LineItem item = new LineItem(productId, quantity);
        if (item != null) {
            addToArray(item);
        }
    }

    /**
     * This method adds the previous line item to the ArrayList
     *
     * @param item
     */
    private final void addToArray(LineItem item) {
        lineItems.add(item);
    }

    /**
     * This method gets the subtotal by totaling each of the line items before
     * the discount is applied.
     *
     * @return subtotal
     */
    public double calculateSubtotal() {
        double total = 0.00;  // Accumulator
        for (LineItem item : lineItems) {
            total += item.calculateSubtotal();
        }
        return total;
    }

    /**
     * This method gets the discount amount for the entire bill by totaling each
     * of the line item discounts.
     *
     * @return amount saved (total discounts)
     */
    public double calculateDiscount() {
        double dTotal = 0.00;  // Accumulator
        for (LineItem item: lineItems) {
            dTotal += item.calculateDiscount();
        }
        return dTotal;
    }

    /**
     * This method gets the overall grand total of the bill by subtracting the
     * total discounts from the subtotal.
     *
     * @return grand total
     */
    public double calculateGrandTotal() {
        double grandTotal = 0.00;  // Accumulator
        for (LineItem item : lineItems) {
            grandTotal += (item.calculateSubtotal() - item.calculateDiscount());
        }
        return grandTotal;
    }

    /**
     * This method generates the actual receipt. It calls both the
     * generateReceiptHeader and generateReceiptFooter private methods.
     */
    public final void generateReceipt() {
        generateReceiptHeader();
        System.out.println(customer.toString());
        System.out.println("Id      " + "   Product Name               "
                + "   Unit Cost   " + "Quantity   " + "Extended Cost   "
                + "Amount Saved \n"
                + "********   ***************************   *********   ********   "
                + "*************   ************");
        for (LineItem lineItem: lineItems) {
            System.out.println(lineItem.getLineItem());
        }
        generateReceiptFooter();
    }

    /**
     * This method generates the receipt header
     */
    private final void generateReceiptHeader() {
        System.out.println("  \t\t\t\t\t KOHL'S  ");
        System.out.println("  \t\t\t\tWestbrook Shopping Center");
        System.out.println("  \t\t\t\t    Waukesha, WI 53186  ");
        System.out.println("  \t\t\t\t      (262) 547-6323  ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-YY HH:mm a");
        String dateTime = dateFormat.format(new Date());
        System.out.println("  \t\t\t " + dateTime + "  0091/0001/7103/2 1008XXX  ");
        System.out.println("  \t\t\t  ID # 999-8983-8787-4675-9908-9828-9647  ");
        System.out.println();
    }

    /**
     * This method generates the receipt footer which includes the subtotal, the
     * total, and the amount saved.
     */
    private final void generateReceiptFooter() {
        System.out.println();
        System.out.printf(" \t\t\t\t\t\tSUBTOTAL  \t$%,.2f%n", calculateSubtotal());
        System.out.printf("\t\t\t\t\t\tTOTAL SAVED  \t$% ,.2f%n", calculateDiscount());
        System.out.printf(" \t\t\t\t\t\tTOTAL     \t$%,.2f%n", calculateGrandTotal());
        System.out.println();
        System.out.println(" \t\t\t\tTHANK YOU FOR SHOPPING AT KOHL'S");
        System.out.println("\n");
    }
    // Retrieve product information from the database - Removed so dependency 
    // upon product is not required.
//    public final void addItemToSale(String productId, int quantity) {
//        FakeDatabase fakeDatabase = new FakeDatabase();
//        Product product = fakeDatabase.findProduct(productId);
//        if (product != null) {
//            addLineItem(product, quantity);
//        }
//    }
//    public static void main(String[] args) {
//        Receipt receipt = new Receipt();
//        receipt.getCustomer("1003");
//        receipt.generateReceipt();
//    }
}
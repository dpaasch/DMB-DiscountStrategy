package dmb.discountstrategy;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        return customerId;
    }

    public final void addLineItem(String productId, int quantity) {
        LineItem item = new LineItem(productId, quantity);
        addToArray(item);
    }

    private final void addToArray(LineItem item) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

    public double getSubTotal() {
        double total = 0.00;  // Accumulator
        for (LineItem item : lineItems) {
            total += item.getSubtotal();
        }
        return total;
    }

    public double getDiscount() {
        double dTotal = 0.00;
        for (int i = 0; i < lineItems.length; i++) {
            dTotal += (lineItems[i].getDiscount());
        }
        return dTotal;
    }

    public double getGrandTotal() {
        double grandTotal = 0.00;
        for (LineItem item : lineItems) {
            grandTotal += (item.getSubtotal() - item.getDiscount());
        }

        return grandTotal;
    }

    public final void generateReceipt() {
        System.out.println(" \t\t\t\t\tWelcome to Kohl's");
        SimpleDateFormat DATE_FORMATTER =
                new SimpleDateFormat(" \t\t\t\t\t EEE, dd MMM YYYY "
                + "\n \t\t\t\t\t HH:mm:ss a");
        String dateTime = DATE_FORMATTER.format(new Date());
        System.out.println(dateTime);
        System.out.println();
        System.out.println(" \t\tCustomer ID: " + customer.getCustomerId()
                + "\tCustomer Name: " + customer.getCustomerName());
        System.out.println("Id \t" + " Product Name \t\t" + "Unit Cost \t"
                + "Quantity \t" + "Extended Cost \t" + "Amount Saved \n"
                + "----------------------------------------------------------"
                + "---------------------------------------------");
        for (int i = 0; i < lineItems.length; i++) {
            System.out.println(lineItems[i].getLineItem());
        }
        System.out.println("\t\t\t\t\t\t\t\t ------------");
        System.out.printf(" \t\t\t\t\t\tSubTotal: \t $%,.2f%n", getSubTotal());
        System.out.printf(" \t\t\t\t\t\tDiscount Amt: \t $% ,.2f%n", getDiscount());
        System.out.printf(" \t\t\t\t\t\tGrand Total: \t $%,.2f%n", getGrandTotal());
        System.out.println();
        System.out.println(" \t\t\tThank you for shopping at Kohl's!");
        System.out.println();
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
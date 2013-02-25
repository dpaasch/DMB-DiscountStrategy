package dmb.discountstrategy;

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

    public double getSubTotal() {
        double total = 0.00;  // Accumulator
        for (LineItem item: lineItems) {
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
        System.out.println(" \t\t\t\t\t\tSubTotal: \t " + getSubTotal());
        System.out.println(" \t\t\t\t\t\tDiscount Amt: \t " + getDiscount());
        System.out.println(" \t\t\t\t\t\tGrand Total: \t " + getGrandTotal());
        System.out.println();
    }    

//    public static void main(String[] args) {
//        Receipt receipt = new Receipt();
//        receipt.getCustomer("1003");
//        receipt.generateReceipt();
//    }
}
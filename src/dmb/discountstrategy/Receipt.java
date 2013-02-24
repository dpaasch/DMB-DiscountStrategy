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

    public Receipt(Customer customer) {
        this.customer = new Customer("1003", "Natalie Gulbis");
    }  

    
    //Retrieve customer information from the database
    public String getCustomer(String customerId) {
        FakeDatabase fakeDatabase = new FakeDatabase();
        customer = fakeDatabase.findCustomer(customerId);
        return customerId;
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
    
    public final double getSubTotal(){
        double total = 0.00;
        for (int i = 0; i < lineItems.length; i++) {
            total += (lineItems[i].getUnitCost() * lineItems[i].getQuantity());
        }
        return total;
    }
    
    public final double getFinalTotal() {
        double total = 0.00;
        for (int i = 0; i < lineItems.length; i++) {
            total += (lineItems[i].getSubtotal());
        }
        return total;
    }
    
    public final void getReceipt() {
        System.out.println("**Store Receipt**");
        System.out.println("**Store #1112**");
        System.out.println("CustomerId \t Customer Name");
        //customer.getCustomer();
        System.out.println("Product Id \t Product Name \t UnitCost \t Qty \t"
                + "Extended Cost \t Amount Saved");
        for (int i = 0; i < lineItems.length; i++) {
            System.out.println(lineItems[i].getLineItem());
        }
        System.out.println("\t\t_____________________");
        System.out.println("\t\tSubtotal: " + getSubTotal());
        System.out.println("\t\tTotal After Discount ");
    }
    public static void main(String[] args) {
        Receipt receipt = new Receipt();

    }

}
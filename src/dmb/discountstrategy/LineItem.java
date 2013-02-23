package dmb.discountstrategy;

/**
 * Lab #3: Create a LineItem class that has a Product component. Think about
 * what a LineItem class should be responsible for? Given a prodId it should be
 * able to lookup the product in the database, create the product and store it
 * internally as a property. Then, it should be able to return all the
 * information about that lineItem that the receipt would need to know. Now
 * write some test code in this class to see if it works.
 *
 * @author Dawn Bykowski
 */
public class LineItem extends FakeDatabase {

    private Product product;
    private double extendedUnitCost;
    


    public double getExtendedUnitCost(double price, int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {



    }
}

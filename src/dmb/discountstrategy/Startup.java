package dmb.discountstrategy;

public class Startup {

    public static void main(String[] args) {
        // Create a CashRegister object
        CashRegister cashRegister = new CashRegister();        
        cashRegister.startSale("1001");
        cashRegister.addLineItem("A100", 1);
        cashRegister.addLineItem("A110", 2);
        cashRegister.finalizeSale();

        CashRegister cashRegister2 = new CashRegister();        
        cashRegister2.startSale("1002");
        cashRegister2.addLineItem("B101", 6);
        cashRegister2.finalizeSale();
        
        CashRegister cashRegister3 = new CashRegister();        
        cashRegister3.startSale("1003");
        cashRegister3.addLineItem("C410", 1);
        cashRegister3.addLineItem("C222", 2);
        cashRegister3.finalizeSale();
        
        CashRegister cashRegister4 = new CashRegister();        
        cashRegister4.startSale("1004");
        cashRegister4.addLineItem("D268", 7);
        cashRegister4.addLineItem("D345", 7);
        cashRegister4.addLineItem("D654", 7);
        cashRegister4.finalizeSale();
        
    }
}

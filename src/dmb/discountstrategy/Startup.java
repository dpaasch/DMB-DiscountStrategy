package dmb.discountstrategy;

public class Startup {

    public static void main(String[] args) {
        // Create a CashRegister object
        CashRegister cashRegister = new CashRegister();        
        cashRegister.startSale("1001");
        cashRegister.addLineItem("90261977", 1);
        cashRegister.addLineItem("93017033", 2);
        cashRegister.finalizeSale();

        CashRegister cashRegister2 = new CashRegister();        
        cashRegister2.startSale("1002");
        cashRegister2.addLineItem("92021665", 6);
        cashRegister2.finalizeSale();
        
        CashRegister cashRegister3 = new CashRegister();        
        cashRegister3.startSale("1003");
        cashRegister3.addLineItem("93208741", 1);
        cashRegister3.addLineItem("93516223", 2);
        cashRegister3.finalizeSale();
        
        CashRegister cashRegister4 = new CashRegister();        
        cashRegister4.startSale("1004");
        cashRegister4.addLineItem("92303192", 1);
        cashRegister4.addLineItem("93056001", 1);
        cashRegister4.addLineItem("90889775", 3);
        cashRegister4.finalizeSale();
        
    }
}

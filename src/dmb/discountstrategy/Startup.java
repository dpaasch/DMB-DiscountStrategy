package dmb.discountstrategy;

public class Startup {

    public static void main(String[] args) {
        // Create a CashRegister object
        CashRegister cashRegister = new CashRegister();        
        cashRegister.startSale("1001");
        cashRegister.addLineItem("92303192", 1);
        cashRegister.addLineItem("93056001", 2);
        cashRegister.finalizeSale();

        CashRegister cashRegister2 = new CashRegister();        
        cashRegister2.startSale("1002");
        cashRegister2.addLineItem("92021665", 4);
        cashRegister2.addLineItem("90889775", 3);
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
        cashRegister4.addLineItem("93099876", 3);
        cashRegister4.addLineItem("89174290", 3);
        cashRegister4.finalizeSale(); 
        
        CashRegister cashRegister5 = new CashRegister();        
        cashRegister5.startSale("1005");
        cashRegister5.addLineItem("90261977", 1);
        cashRegister5.addLineItem("93516223", 1);
        cashRegister5.finalizeSale();
        
        CashRegister cashRegister6 = new CashRegister();        
        cashRegister6.startSale("1006");
        cashRegister6.addLineItem("92303192", 1);
        cashRegister6.addLineItem("93056001", 1);
        cashRegister6.finalizeSale(); 
        
        CashRegister cashRegister7 = new CashRegister();        
        cashRegister7.startSale("1007");
        cashRegister7.addLineItem("93208741", 1);
        cashRegister7.addLineItem("93017033", 5);
        cashRegister7.finalizeSale();
        
        CashRegister cashRegister8 = new CashRegister();        
        cashRegister8.startSale("1008");
        cashRegister8.addLineItem("92021665", 4);
        cashRegister8.addLineItem("93099876", 3);
        cashRegister8.finalizeSale();
        
        CashRegister cashRegister9 = new CashRegister();        
        cashRegister9.startSale("1009");
        cashRegister9.addLineItem("92303192", 1);
        cashRegister9.addLineItem("93056001", 2);
        cashRegister9.addLineItem("93208741", 2);
        cashRegister9.addLineItem("90261977", 3);
        cashRegister9.finalizeSale();
        
        CashRegister cashRegister10 = new CashRegister();        
        cashRegister10.startSale("1010");
        cashRegister10.addLineItem("92021665", 4);
        cashRegister10.addLineItem("90889775", 3);
        cashRegister10.addLineItem("93099876", 4);
        cashRegister10.addLineItem("89174290", 5);
    }
}

package dmb.discountstrategy;

import javax.swing.JOptionPane;

public class ReceiptGUIOutput implements ReceiptOutputStrategy {

    @Override
    public void outputMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }    
    
    public static void main(String[] args) {
        String msg = "Message";
    }
}

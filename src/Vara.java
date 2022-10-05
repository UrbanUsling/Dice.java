import javax.swing.*;

public class Vara {
    public static void main(String[] args) {
        double momsPris = Double.parseDouble(JOptionPane.showInputDialog("Vad kostar varan?"));
        int moms = Integer.parseInt(JOptionPane.showInputDialog("Vad ligger momssatsen på?"));
        double momsSats = ((moms + 100)*0.01);
        double pris = momsPris / momsSats ;
        String m = "Priset :" + momsPris + "kr";
        String p= "Momspriset: "+ (momsPris - pris) + "kr";
        String k = "Pris med moms :" + pris + "kr";
        System.out.println(momsSats);
        System.out.println(m + "\n"+ p + "\n" + k);
        JOptionPane.showMessageDialog(null, m +"\n"+p+"\n"+k);
    }

}

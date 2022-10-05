import javax.swing.*;

public class Ring {
    public static void main(String[] args) {
        int antalMinuter = Integer.parseInt(JOptionPane.showInputDialog("Hur många minuter pratar du i månaden i telefon?"));
        double pris = Double.parseDouble(JOptionPane.showInputDialog("Vad är minutpriset?"));
        double kostnad = antalMinuter*pris;
        String m = "Antal minuter :" + antalMinuter;
        String p= "Pris per minut: "+ pris + "kr";
        String k = "Månadskostnad :" + kostnad + "kr";
        System.out.println(m + "\n"+ p + "\n" + k);
        JOptionPane.showMessageDialog(null, m +"\n"+p+"\n"+k);
    }


}

import javax.swing.*;
import java.text.DecimalFormat;

public class BmiCalc {//klassnamn


    public static void main(String[] args) {//main
        DecimalFormat df = new DecimalFormat("###.##");//avrundning
        double vikt = Double.parseDouble(JOptionPane.showInputDialog("Hur många kilogram väger du?"));
        double längd = Double.parseDouble(JOptionPane.showInputDialog("Hur lång är du i meter?"));
        double BMI = Bmi(vikt, längd);//anrop av metod som beräknar bmi. Parametrar vikt och längd från dialogrutorna
        String typ = KroppsTyp(BMI);//anrop av metod för kroppstyp. Parameter BMI
        String v = "Vikt: " + vikt + "kg";
        String l = "Längd: " + längd + "m";
        String b = "BMI: " + df.format(BMI);
        String t = "Viktklass: " + typ;//ordnad tilldelning av variabler för enklare presentation i dialogruta
        JOptionPane.showMessageDialog(null, v +"\n"+l+"\n"+b+"\n"+t );//resultaten
    }

    private static String KroppsTyp(double bmi) {//metod som läser av vilken viktklass bmi är i och returnerar string
        if (bmi<18.5)
            return "Undervikt";
        else if (bmi>=18.5 && bmi<=25)
            return "Normalvikt";
        else if (bmi>25 && bmi<=30)
            return "Övervikt";
        else if (bmi>30 && bmi<=35)
            return "Fetma klass1";
        else if (bmi>35 && bmi<=40)
            return "Fetma klass2";
        else
            return "Fetma klass3";

    }

    public static double Bmi(double vikt, double längd) {//metod för matematisk bmi beräkning
        double bmi = vikt / Math.pow(längd, 2);
        return bmi;

    }
}
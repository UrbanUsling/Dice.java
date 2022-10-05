import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Boolean.valueOf;

public class Miniräknare {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###.##");
        boolean rätt = true;
        boolean negativ1 = false;
        boolean negativ2 = false;
        boolean slutOperand = false;
        int x = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Skriv in ett matematiskt uttryck med ett av de fyra räknesätten");
        String s1 = scan.nextLine();
        String s = s1.trim();
        StringBuilder t1 = new StringBuilder();
        StringBuilder t3 = new StringBuilder();
        double t2 = 0;
        double t4 = 0;

        if (s.isBlank()) {
            System.out.println("Du måste skriva något");
            System.exit(0);
        }

        if (!Character.isDigit(s.charAt(s.length() - 1))) {
            System.out.println("Beräkningen måste sluta med en siffra och inget annat");
            slutOperand=true;
            rätt = false;
        }
        if (s.indexOf('-') < 0 && s.indexOf('+') < 0 && s.indexOf('*') < 0 && s.indexOf('/') < 0) {
            System.out.println("Innehåller ingen operand för beräkning");
            rätt = false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != '-' && s.charAt(i) != '+' && s.charAt(i) != '*' && s.charAt(i) != '/' && s.charAt(i) != '.') {
                rätt = false;
                System.out.println("Kan inte innehålla bokstäver eller otillåtna tecken");
                break;
            }
        }

        if (s.charAt(0) == '-' && Character.isDigit(s.charAt(1))) {
            negativ1 = true;
            s = s.substring(1);
        } else if ((s.charAt(1) == '-' || s.charAt(1) == '+' || s.charAt(1) == '/' || s.charAt(1) == '*') && !Character.isDigit(s.charAt(0))) {
            System.out.println("För många operander efter varandra framför första uttrycket");
            rätt = false;
        } else if (s.charAt(0) == '+' || s.charAt(0) == '/' || s.charAt(0) == '*') {
            System.out.println("Kan ej börja med en sådan operand");
            rätt = false;

        }


        while (!Character.isDigit(s.charAt(0))) {
            s = s.substring(1);
            if (s.isBlank()) {
                System.out.println("Det finns inga tal i uttrycket");
                rätt = false;
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {


            if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.') {
                t1.append(s.charAt(i));
            } else
                break;
        }

        String s3 = String.valueOf(t1);

        if (s3.indexOf('.') > 0 && !Objects.equals(s3.indexOf('.'), s3.lastIndexOf('.'))) {
            System.out.println("Första talet innehåller två decimaltecken");
            rätt = false;
        } else if (!s3.isBlank())
            t2 = Double.parseDouble(s3);
        if (negativ1)
            t2 = t2 * (-1);
        /*System.out.println(s);
        System.out.println(s3);*/
        if (s.length() > s3.length()) {

            if (s.charAt(s3.length()) == '+')
                x = 1;
            else if (s.charAt(s3.length()) == '-')
                x = 2;
            else if (s.charAt(s3.length()) == '*')
                x = 3;
            else if (s.charAt(s3.length()) == '/')
                x = 4;

            s = s.substring(t1.length() + 1);

            if (s.charAt(0) == '-' && Character.isDigit(s.charAt(1))) {
                negativ2 = true;
                s = s.substring(1);
            } else if (s.charAt(0) == '-' && (s.charAt(1) == '+' || s.charAt(1) == '/' || s.charAt(1) == '*')) {
                System.out.println("För många operander mellan de två talen");
                rätt = false;
            } else if (s.charAt(0) == '+' || s.charAt(0) == '/' || s.charAt(0) == '*') {
                System.out.println("För många operander mellan de två talen");
                rätt = false;
            }

            while (!Character.isDigit(s.charAt(0))) {
                s = s.substring(1);
                if (s.isBlank()) {
                    System.out.println("Ingen andra talföljd finns");
                    rätt = false;
                    break;
                }
            }
        }
        for (int j = 0; j < s.length(); j++) {
            if (Character.isDigit(s.charAt(j)) || s.charAt(j) == '.') {
                t3.append(s.charAt(j));
            } else
                break;
        }
        String s2 = String.valueOf(t3);

        /*System.out.println(s);
        System.out.println(s2);*/


        if (s2.indexOf('.') > 0 && !Objects.equals(s2.indexOf('.'), s2.lastIndexOf('.'))) {
            System.out.println("Andra talet innehåller två decimaltecken");
            rätt = false;
        } else if (!s2.isBlank())
            t4 = Double.parseDouble(s2);
        if (negativ2)
            t4 = t4 * (-1);
        System.out.println(s);
        if (slutOperand && (s.indexOf('-') != s.lastIndexOf('-') || s.indexOf('+') != s.lastIndexOf('+')
            || s.indexOf('*') != s.lastIndexOf('*')|| s.indexOf('/') != s.lastIndexOf('/')) && (
                Character.isDigit(s.charAt(s.indexOf('-') + 1))||Character.isDigit(s.charAt(s.indexOf('+') + 1))
                        || Character.isDigit(s.charAt(s.indexOf('*') + 1))|| Character.isDigit(s.charAt(s.indexOf('/') + 1)))) {
            System.out.println("För många beräkningar");
        }
           else if (!s.equals(s2) && !slutOperand && (Character.isDigit(s.charAt(s.indexOf('-') + 1)) || Character.isDigit(s.charAt(s.indexOf('+') + 1))
                    || Character.isDigit(s.charAt(s.indexOf('*') + 1)) || Character.isDigit(s.charAt(s.indexOf('/') + 1)))
                    && (s.indexOf('-') > 0 || s.indexOf('+') > 0 || s.indexOf('*') > 0 || s.indexOf('/') > 0)) {
                System.out.println("För många beräkningar");
                rätt = false;
            }

        if (!rätt)
            System.exit(0);

        if (Objects.equals(s2, s) && x == 1)
            System.out.println("Summan blir: " + df.format(t2 + t4));
        else if (Objects.equals(s2, s) && x == 2)
            System.out.println("Summan blir: " + df.format(t2 - t4));
        else if (Objects.equals(s2, s) && x == 3)
            System.out.println("Produkten blir: " + df.format(t2 * t4));
        else if (Objects.equals(s2, s) && x == 4) {
            if (t4 == 0)
                System.out.println("Division med 0 ej möjligt");
            else
                System.out.println("Kvoten blir: " + df.format(t2 / t4));
        }


    }
}
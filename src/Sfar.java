import java.util.Scanner;

public class Sfar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Radien?");
        double r = scan.nextDouble();
        double V =(4* Math.PI * Math.pow(r, 3))/3;
        double A = (4 * Math.PI * Math.pow(r, 2));
        System.out.println("Volymen: " + V +"\n" + "Arean: "+ A);
    }
}

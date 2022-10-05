import java.util.Scanner;

public class Pyth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Första kateten?");
        double a = scan.nextDouble();
        System.out.println("Andra kateten?");
        double b = scan.nextDouble();
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("Hypotenusan är: " +c);

    }
}

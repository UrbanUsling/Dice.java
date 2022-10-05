import java.util.Scanner;

public class Farenheit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Grader farenheit?");
        double f = scan.nextDouble();
        double c = (f-32)*5/9;
        System.out.println("Detta motsvarar: " + Math.round(c) + " Celcius");
    }
}

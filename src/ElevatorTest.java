import java.util.Scanner;

public class ElevatorTest {
    public static void main(String[] args) {
        int våning;
        var hiss01 = new Elevator(7);
        var hiss02 = new Elevator(5);
        var scan = new Scanner(System.in);
        System.out.println("Du kliver in i hiss 1 och kan åka(skriv å) eller kolla våning(skriv v)");
        while(true){
            System.out.println("Ny å eller v? Skriv 'klar' om du önskar stoppa hiss 1");
            String val1 = scan.nextLine();
            val1= val1.toLowerCase();
            if (val1.equals("å")) {
                System.out.println("Vilken våning?");
                if (scan.hasNextInt()) {
                    våning = scan.nextInt();
                    hiss01.goTo(våning);
                    val1 = scan.nextLine();
                } else {
                    System.out.println("Detta är ej ett heltal");
                    val1 = scan.nextLine();
                }
            }
            else if (val1.equals("v")){
                System.out.println("Hiss 1 står på våning: " + hiss01.where());
            }
            else if (val1.equals("klar"))
                break;
            else
                System.out.println("Ej giltigt val");
        }
        System.out.println("Du kliver in i hiss 2 och kan åka(skriv å) eller kolla våning(skriv v)");
        while(true){
            System.out.println("Ny å eller v? Skriv 'klar' om du önskar stoppa hiss 2");
            String val1 = scan.nextLine();
            val1= val1.toLowerCase();
            if (val1.equals("å")) {
                System.out.println("Vilken våning?");
                if (scan.hasNextInt()) {
                    våning = scan.nextInt();
                    hiss02.goTo(våning);
                    val1 = scan.nextLine();
                } else {
                    System.out.println("Detta är ej ett heltal");
                    val1 = scan.nextLine();
                }
            }
            else if (val1.equals("v")){
                System.out.println("Hiss 2 står på våning: " + hiss02.where());
            }
            else if (val1.equals("klar"))
                break;
            else
                System.out.println("Ej giltigt val");
        }
    }
}

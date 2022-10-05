import java.util.Scanner;

public class FigurTest {
    public static void main(String[] args) {
        var slacker = new Slacker();
        var athlete = new Athlete();
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Spelet börjar nu! En slacker skapas. \n " +
                "Slackern kan sova (s), äta (ä), promenera (p), kolla energi(e) och lyssna på partners klagande (k)\n" +
                " Ange vad personen ska göra med kommando (t ex 's' för att slackern ska sova)\n" +
                "Om energin tar slut så dör karaktären. Skriv 'klar' när du är färdig. ");
        while (slacker.liv) {
            String val = scan1.nextLine();
            val = val.toLowerCase();
            if (val.equals("s"))
                slacker.sov();
            else if (val.equals("ä"))
                slacker.ät();
            else if (val.equals("p")) {
                Scanner scan2 = new Scanner(System.in);
                System.out.println("Hur lång ska promenaden vara i km?");
                double längd = scan2.nextDouble();
                slacker.promenad(längd);
            } else if (val.equals("e"))
                System.out.println("Slackerns energi ligger på: " + slacker.getEnergi());
            else if (val.equals("k")) {
                Scanner scan3 = new Scanner(System.in);
                System.out.println("Hur länge klagar partnern i minuter?");
                double tid = scan3.nextDouble();
                slacker.partnersKlagande(tid);
            }
            else if (val.equals("klar"))
                break;
            else
                System.out.println("Ogiltigt val");
        }
    }
}
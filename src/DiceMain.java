import java.io.FileWriter;
import java.io.IOException;

public class DiceMain {//Klass för att köra dice
    public static void main(String[] args) throws IOException {//main metod
        Dice.createFile();//klassmetoden createfile i Dice anropas. Textfil med kast skapas
        int[] a = Dice.createArray();//En array skapas och metoden createarray i Dice anropas
        int[] b = Dice.analyzeArray(a);//En array skapas och metoden analyzeArray anropas med parametern a
        System.out.println("Följande 1000 slag erhölls: ");
        for (var tal: a)
            System.out.print(tal + " ");//Samtliga kast i array a loopas och skrivs ut
        System.out.println("\n");
        System.out.println("Så här många slag av varje storlek erhölls (1-6): ");
        for (int i=0; i<=5; i++){
            System.out.println("Antal "+ (i+1) + ":" + b[i]);
        }//for loop för att skriva rätt siffra på kastet (i+1) framför rätt index i array b

        FileWriter writer = new FileWriter("src\\Resource\\dice2.txt");
//Klassen filewriter används igen för att skapa en ny textfil dice2 som också sparas i resource

        for (int i = 0; i < 6; i++) {
            writer.write(b[i] + " ");
        }//Antalet av varje kast (array b:s index) skrivs in i dice2, med mellanslag igen.
        writer.close();//skrivandet slutar

        System.out.println("Antal tecken i textfilen dice: " + FileAnalyzer.Tecken("dice.txt"));
        System.out.println("Antal tecken i textfilen dice2: " + FileAnalyzer.Tecken("dice2.txt"));
    }//metoden Tecken i FileAnalyzer anropas med parametrarna för textfilernas sökväg som string. Utskrift sker


}

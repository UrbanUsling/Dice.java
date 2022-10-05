import java.io.*;
import java.util.Scanner;

public class Dice {//klass dice med 3 statiska klassmetoder
    public static void createFile() throws IOException {//Exception då filadressen kan saknas
        FileWriter writer = new FileWriter("src\\Resource\\dice.txt");
//Objekt av filewriter skapas. Textfil dice.txt ska skapas och sparas i mappen resource
        for (int i = 0; i < 1000; i++) {
            int kast = (int) (6.0 * Math.random() + 1);
            writer.write(kast + " ");
            /*1000 "kast". Eftersom int alltid avrundas neråt så kommer math random*6
            anta värden mellan 0 och 5. Med +1 efteråt blir värdet därför mellan 1 och 6, vilket är en tärning.
            Varje random nummer åtföljs av mellanslag för att kunna särskilja på kasten enkelt
             */
        }
        writer.close();//viktigt så att filen slutar skrivas
    }//void, så inget returneras

    public static int[] createArray() throws FileNotFoundException {//Exception då filen kanske ej existerar
        int[] antalen = new int[1000];//array med 1000 index skapas
        Scanner scan = new Scanner(new File("src\\Resource\\dice.txt"));
        //Scannerklassen är väldigt enkel att använda till filavläsning. dice hämtas
        for (int i = 0; i < 1000; i++) {
            antalen[i] = scan.nextInt();
            //Tack vare mellanrummen läses varje kast av enkelt med nextInt och lagras i arrayen
        }
        return antalen;//returnerar arrayen antal
    }
    public static int[] analyzeArray(int [] antalen) {//Tar in en array som parameter och returnerar en annan
        int ett = 0;
        int två = 0;
        int tre = 0;
        int fyra = 0;
        int fem = 0;
        int sex = 0;

        int[] sort = new int[6];
        for (int i = 0; i < 1000; i++) {
            if (antalen[i] == 1)
                ett++;
            else if (antalen[i] == 2)
                två++;
            else if (antalen[i] == 3)
                tre++;
            else if (antalen[i] == 4)
                fyra++;
            else if (antalen[i] == 5)
                fem++;
            else if (antalen[i] == 6)
                sex++;
            //varje "kast" i arrayen sorteras här i nya variabler. Antal av samma räknas och sparas i en ny array
        }
        sort[0] = ett;
        sort[1] = två;
        sort[2] = tre;
        sort[3] = fyra;
        sort[4] = fem;
        sort[5] = sex;
        return sort;//returnering av array med 6 index

    }

}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileAnalyzer {//Klass som analyserar filer
    static int Tecken(String s) throws FileNotFoundException {
        //Metod som tar in sökväg till textfil som parameter
        Scanner scan = new Scanner(new File("src\\Resource\\"+s));
        //Sökvägen nästan färdigskriven i förväg. Skanner läser av textfilen
            String rad = scan.nextLine();
            //Då bara en rad har sparats i textfilerna så behövs ingen whileloop. Alla tecken sparas i en string
            return rad.length();//returnerar int med stringens längd
    }
}

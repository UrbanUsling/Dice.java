import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        double störst = -Double.MAX_VALUE;
        var scan = new Scanner(System.in);
        System.out.println("Ange tal. avsluta med enter för att se största talet");
        while (scan.hasNextDouble()) {
            double tal = scan.nextDouble();
            if(tal > störst){
                störst = tal;
            }
        }
        System.out.println(störst);
    }
}
//throws NullPointerException ifall man inte har try catch


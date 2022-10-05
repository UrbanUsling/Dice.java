import java.util.Scanner;

public class Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[1000];
        int counter = 0;
        while(scanner.hasNext()) {
            String input = scanner.nextLine();
            names[counter] = input;
            counter++;
        }
        for (String element: names) {
            if (element != null) {
                System.out.println(element.length());
            }
        }
    }
}

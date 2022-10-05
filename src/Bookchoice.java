import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Bookchoice {

    public static void main(String[] args) {
        String[] books = {"Kalle anka", "Narnia", "Bilbo"};
        System.out.println(books[0]);
        System.out.println(books[books.length-1]);
        Arrays.sort(books);
        System.out.println(Arrays.toString(books));
        System.out.println("Antal böcker: " + books.length);
        books = Arrays.copyOf(books, books.length + 1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lägg till bok");
        String input = scanner.nextLine();
        books[books.length - 1] = input;
        System.out.println(Arrays.toString(books));


    }

    public static int primitiveExample(int num) {
        num = num+2;
        return num;
    }
    public static void referenceExample(int[] num) {
        num[0] = 1111111;
    }


    public static void demo(int[] array) {
        array[0] = 9999;
    }

    public static void incrementNumberByX(int valueToIncrement, int x) {
        valueToIncrement += x;
        System.out.println(valueToIncrement);
    }

    public static void printArray(int[] arrayToPrint) {
        for (int element : arrayToPrint) {
            System.out.println(element);
        }
    }

    public static void addToArray(int[] inputArray, int valueToAdd) {
        inputArray = new int[100];
        inputArray[inputArray.length - 1] = valueToAdd;
        System.out.println(inputArray);
    }


}
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Table {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int size;

        while (true) {
            System.out.print("Enter array size (for P×P array): ");

            try {
                size = sc.nextInt();

                if (size <= 0) {
                    System.out.println("Array size must be greater than 0.");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next();
            }
        }

        int[][] table = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = random.nextInt(8) * 2 + 2;
            }
        }

        System.out.println("\nGenerated Table:");
        printTable(table, -1);

        int highlight;

        while (true) {

            System.out.print("\nEnter a number to highlight (even number 2–16): ");

            try {

                highlight = sc.nextInt();

                if (highlight < 2 || highlight > 16 || highlight % 2 != 0) {
                    System.out.println("Please enter an EVEN number between 2 and 16.");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                sc.next();
            }
        }

        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == highlight)
                    count++;
            }
        }

        System.out.println("\nHighlighted Table:");
        printTable(table, highlight);

        System.out.println("\nNumber " + highlight + " occurred " + count + " time(s).");

        sc.close();
    }

    public static void printTable(int[][] table, int highlight) {

        for (int i = 0; i < table.length; i++) {

            for (int j = 0; j < table[i].length; j++) {

                if (table[i][j] == highlight)
                    System.out.printf("[%2d] ", table[i][j]);
                else
                    System.out.printf(" %2d  ", table[i][j]);
            }

            System.out.println();
        }
    }
}
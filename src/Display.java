import java.util.Arrays;
import java.util.Scanner;

public class Display {
    public static int validateInteger(int greaterThan, int lessThan) {
        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            System.out.print("Please enter a number between " + greaterThan + " and " + lessThan + ":" );
            while (!scanner.hasNextInt()) {
                scanner.next();
//                String input =
//                System.out.printf(input + " is not a valid number.");
                System.out.print("Please enter a number between " + greaterThan + " and " + lessThan + ":" );
            }
            number = scanner.nextInt();
        } while (number < greaterThan || number > lessThan);
        return number;
    }

//    public static int[] getHeightWidth(int greaterThan, int lessThan) {
//        System.out.println("Pick a grid height (whole integer greater than 10 and less than 100)");
//        int height = validateInteger(greaterThan, lessThan);
//
//        System.out.println("Pick a grid width (whole integer greater than 10 and less than 100)");
//        int width = validateInteger(greaterThan, lessThan);
//
//        return new int[]{height, width};
//    }
//
//    public static int getDifficulty(int greaterThan, int lessThan) {
//        System.out.println("Pick a difficulty (from 1 to 10, 10 being the most difficult)");
//        return validateInteger(greaterThan, lessThan);
//    }
}

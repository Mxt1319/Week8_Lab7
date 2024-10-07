import java.util.Scanner;

public class AverageAges {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Week7 Lab6");

        System.out.print("How many houses in the street? : ");
        int houseAmount;
        houseAmount = keyboard.nextInt();
        int [] houseNumbers = new int[houseAmount];

        int index;
        for (index = 0; index < houseNumbers.length; index++) {
            System.out.print("What is the next house number? : ");
            houseNumbers[index] = keyboard.nextInt();
        } //end of houseAmount for loop
        System.out.println();

        int [][] houseAges = new int[houseAmount][];

        int rowIndex;
        int columnIndex;

        for(rowIndex = 0; rowIndex < houseAmount; rowIndex++) {
            System.out.print("How many people live in number " + houseNumbers[rowIndex] + ": ");
            int numberOfColumn = keyboard.nextInt();

            houseAges[rowIndex] = new int[numberOfColumn];

            for (columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
                System.out.print("What is the age of person " + (columnIndex + 1) + ": ");
                houseAges[rowIndex][columnIndex] = keyboard.nextInt();

            } //end of columnIndex for loop

        } //end of rowIndex for loop






    } // end of the main method






} // end of AverageAges class

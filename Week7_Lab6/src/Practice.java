import java.util.Scanner;

public class Practice {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Practice Array");

        //declare an array
        int[] myArray = new int[3];

        int[][] yourArray = new int[3][4];

    } // end of the main method

    private static void updateMyArray(int[] myArray) {

        //update an array
        int index;
        for (index = 0; index < myArray.length; index++) {
            System.out.println("At index " + index + " Enter a number to be stored into the array: ");
            myArray[index] = keyboard.nextInt();
        } // end of for loop

        //display array content
        System.out.println("Here the content of the array: ");
        for (index = 0; index < myArray.length; index++) {

            System.out.println(myArray[index]);

        } //end of for loop

    } // end of updateMyArray method

    private static void updateYourArray(int[][] yourArray) {

        int indexRow;
        int indexColumn;

        //update an array
        for (indexRow = 0; indexRow < 3; indexRow++) {
            for (indexColumn = 0; indexColumn < 4; indexColumn++) {

                System.out.println("At index [" + indexRow + "][" + indexColumn + "] Enter the integer number: ");
                yourArray[indexRow][indexColumn] = keyboard.nextInt();

            } //end of indexColumn for loop

        } //end of indexRow for loop

        //display content of 2D yourArray

        for (indexRow = 0; indexRow < 3; indexRow++) {
            for (indexColumn = 0; indexColumn < 4; indexColumn++) {
                System.out.println("At index [" + indexRow + "][" + indexColumn + "]: " + yourArray[indexRow][indexColumn]);

            } //end of indexColumn for loop

        } //end of indexRow for loop


    } //end of updateYourArray method


} // end of the Practice class

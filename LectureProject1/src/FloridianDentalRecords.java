import java.util.Scanner;

public class FloridianDentalRecords {

    private static final Scanner keyboard = new Scanner(System.in);
    private static final int MAXIMUM_FAMILY_MEMBERS = 6;
    private static final int MAXIMUM_UPPER_TEETH = 8;
    private static final int MAXIMUM_LOWER_TEETH = 8;
    private static final int MAXIMUM_TEETH_LAYERS = 2;

    public static void main(String[] args) {

        System.out.println("Lecture Project 1");
        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");

        // Input number of people in family
        int numberOfFamilyMembers;
        System.out.print("Please enter number of people in the family : ");
        numberOfFamilyMembers = keyboard.nextInt();

        while (numberOfFamilyMembers > MAXIMUM_FAMILY_MEMBERS || numberOfFamilyMembers < 0) {
            System.out.print("Invalid number of people, try again : ");
            numberOfFamilyMembers = keyboard.nextInt();
        } // end of numberOfFamilyMembers while loop

        // Input names of family members and tooth types for each
        String[] familyNames = new String[numberOfFamilyMembers];
        char[][][] familyToothTypes = new char[numberOfFamilyMembers][MAXIMUM_TEETH_LAYERS][];

        // Declare variables to fill arrays
        int index;
        int planeIndex;
        int rowIndex;
        int columnIndex;
        char toothType;

        for (index = 0; index < familyNames.length; index++) {
            System.out.print("Please enter the name for family member " + (index + 1) + " : ");
            familyNames[index] = keyboard.next();
            for (planeIndex = 0; planeIndex < numberOfFamilyMembers; planeIndex++) {
                familyToothTypes[planeIndex] = new char[familyNames[index].charAt(0)][];
                for (rowIndex = 0; rowIndex < MAXIMUM_TEETH_LAYERS; rowIndex++) {
                    familyToothTypes[rowIndex] = new char['U'][];
                    for (columnIndex = 0; columnIndex < 1; columnIndex++) {
                        System.out.print("Please enter the uppers for " + familyNames[index] + " : ");
                        String teethTypes = keyboard.next();
                        toothType = teethTypes.charAt(columnIndex);

                    } //end of columnIndex for loop

                } //end of rowIndex for loop

            } //end of planeIndex for loop


        } //end of numberOfFamilyMembers for loop

        System.out.println(familyNames[0] + familyNames[1] + familyNames[2]);










    } // end of the main method



} //end of the FloridianDentalRecords class


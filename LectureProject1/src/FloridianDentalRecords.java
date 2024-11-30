import java.util.Scanner;

/**
 * Record the teeth records for a family.
 * @author Marissa Turja
 */

public class FloridianDentalRecords {

    /**
     * Global Scanner object ot use keyboard
     */
    private static final Scanner keyboard = new Scanner(System.in);
    /**
     * Maximum number of family members is 6.
     */
    private static final int MAXIMUM_FAMILY_MEMBERS = 6;
    /**
     * Maximum number of teeth per layer is 8.
     */
    private static final int MAXIMUM_TEETH = 8;
    /**
     * Maximum number of layers of teeth is two, uppers and lowers.
     */
    private static final int MAXIMUM_TEETH_LAYERS = 2;

    /**
     * The main method
     * @param args Passed in from the command line
     */

    public static void main(String[] args) {

        System.out.println("Lecture Project 1");
        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");

        // Input number of people in family
        int numberOfFamilyMembers;
        System.out.print("Please enter number of people in the family : ");
        numberOfFamilyMembers = keyboard.nextInt();

        while (numberOfFamilyMembers > MAXIMUM_FAMILY_MEMBERS || numberOfFamilyMembers < 0) {
            System.out.print("Invalid number of people, try again         : ");
            numberOfFamilyMembers = keyboard.nextInt();
        } // end of numberOfFamilyMembers while loop

        // Input names of family members and tooth types for each
        String[] familyNames = new String[numberOfFamilyMembers];
        char[][][] familyToothTypes = new char[numberOfFamilyMembers][MAXIMUM_TEETH_LAYERS][MAXIMUM_TEETH];

        // Declare variables to fill arrays
        int index;
        String toothString;
        int rowIndex;
        int columnIndex;
        String newString;

        for (index = 0; index < familyNames.length; index++) {
            System.out.print("Please enter the name for family member " + (index + 1) + "   : ");
            familyNames[index] = keyboard.next();

            for (rowIndex = 0; rowIndex < MAXIMUM_TEETH_LAYERS; rowIndex++) {

                if (rowIndex == 0) {
                    String upperMessage = String.format("Please enter the uppers for %-15s : ", familyNames[index]);
                    System.out.print(upperMessage);
                    toothString = keyboard.next();
                    toothString = toothString.toUpperCase();

                    newString = checkTeethTypes(toothString);
                    newString = checkToothNumber(newString);
                } else {
                    String lowerMessage = String.format("Please enter the lowers for %-15s : ", familyNames[index]);
                    System.out.print(lowerMessage);
                    toothString = keyboard.next();
                    toothString = toothString.toUpperCase();

                    newString = checkTeethTypes(toothString);
                    newString = checkToothNumber(newString);
                }

                for (columnIndex = 0; columnIndex < newString.length(); columnIndex++) {

                    familyToothTypes[index][rowIndex][columnIndex] = newString.charAt(columnIndex);

                } // end of columnIndex for loop

            } // end of rowIndex for loop

        } // end of familyNames for loop

        System.out.println();

        // Switch statement to run all processing

        String optionChoice;
        char switchOption;

        switchOption = getSwitchOption();

        do {
            switch (switchOption) {
                case 'P':
                    printTeeth(familyToothTypes, familyNames);

                    System.out.println();
                    System.out.println();

                    switchOption = getSwitchOption();
                    break;
                case 'E':
                    String extractionMember;
                    boolean realFamilyMember;
                    char toothLayer;
                    int toothNumber;
                    int familyMemberIndex;
                    int toothLayerIndex;

                    System.out.print("Which family member                         : ");
                    extractionMember = keyboard.next();
                    extractionMember = extractionMember.substring(0, 1).toUpperCase() + extractionMember.substring(1);
                    realFamilyMember = checkFamilyMember(extractionMember, familyNames);

                    while (realFamilyMember == false) {
                        System.out.print("Invalid family member, try again            : ");
                        extractionMember = keyboard.next();
                        extractionMember = extractionMember.substring(0, 1).toUpperCase() + extractionMember.substring(1);
                        realFamilyMember = checkFamilyMember(extractionMember, familyNames);
                    } //end of realFamilyMember while loop

                    familyMemberIndex = getFamilyMemberIndex(extractionMember, familyNames, numberOfFamilyMembers);

                    System.out.print("Which tooth layer (U)pper or (L)ower        : ");
                    toothLayer = keyboard.next().charAt(0);
                    toothLayer = Character.toUpperCase(toothLayer);
                    toothLayer = checkToothLayer(toothLayer);

                    if (toothLayer == 'U') {
                        toothLayerIndex = 0;
                    } else {
                        toothLayerIndex = 1;
                    }

                    System.out.print("Which tooth number                          : ");
                    toothNumber = keyboard.nextInt() - 1;
                    toothNumber = checkToothNumber(toothNumber, familyToothTypes, familyMemberIndex, toothLayerIndex);

                    while (familyToothTypes[familyMemberIndex][toothLayerIndex][toothNumber] == 'M') {
                        System.out.print("Missing tooth, try again                    : ");
                        toothNumber = keyboard.nextInt() - 1;
                        toothNumber = checkToothNumber(toothNumber, familyToothTypes, familyMemberIndex, toothLayerIndex);
                    } //end of while loop

                    familyToothTypes[familyMemberIndex][toothLayerIndex][toothNumber] = 'M';

                    System.out.println();

                    switchOption = getSwitchOption();
                    break;
                case 'R':
                    rootCanalIndices(familyToothTypes, numberOfFamilyMembers);
                    switchOption = getSwitchOption();
                    break;
                case 'X':
                    System.out.println();
                    System.out.println("Exiting the Floridian Tooth Records :-)");
                    switchOption = 'F';
                    break;
                default:
                    System.out.print("Invalid menu option, try again              : ");
                    switchOption = keyboard.next().charAt(0);
                    switchOption = Character.toUpperCase(switchOption);
                    break;
            }
        } while (switchOption == 'P' || switchOption == 'E' || switchOption == 'R' || switchOption == 'X');


    } // end of the main method

    /**
     * Get the keyboard input matching one of the cases in the switch.
     * @return Switch Case choice in char
     */
    private static char getSwitchOption() {

        char switchOption;

        System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it          : ");
        switchOption = keyboard.next().charAt(0);
        switchOption = Character.toUpperCase(switchOption);

        return switchOption;

    } //end of getSwitchOption method

    /**
     * Check if the inputted tooth type is a valid type
     * @param toothString Inputted String of teeth types
     * @return Valid String of tooth types
     */
    private static String checkTeethTypes(String toothString) {
        char toothType;
        int toothStringindex = 0;

        for (toothStringindex = 0; toothStringindex < toothString.length(); toothStringindex++) {
            toothType = toothString.charAt(toothStringindex);

            while (toothType != 'I' && toothType != 'B' && toothType != 'M') {
                System.out.print("Invalid teeth types, try again              : ");
                toothString = keyboard.next();
                toothStringindex = 0;
                toothType = toothString.charAt(toothStringindex);
            } //end of while loop

        } //end of for loop

        return toothString;

    } //end of checkTeeth method

    /**
     * Check if inputted tooth types exceed the maximum number of teeth
     * @param newString Inputted String containing valid tooth types
     * @return String containing valid tooth types and a valid number of teeth
     */
    private static String checkToothNumber(String newString) {
        String toothString;

        while (newString.length() > MAXIMUM_TEETH) {
            System.out.print("Too many teeth, try again                   : ");
            toothString = keyboard.next();
            newString = checkTeethTypes(toothString);
        } //end of while loop

        return newString;

    } //end of checkToothNumber method

    /**
     * Output the family's teeth types
     * @param familyToothTypes Array containing the tooth records
     * @param familyNames Array containing the family member names
     */
    private static void printTeeth(char[][][] familyToothTypes, String[] familyNames) {

        int nameIndex;
        int layerIndex;
        int toothIndex;

        for (nameIndex = 0; nameIndex < familyToothTypes.length; nameIndex++) {

            System.out.println();
            System.out.println(familyNames[nameIndex]);

            for (layerIndex = 0; layerIndex < MAXIMUM_TEETH_LAYERS; layerIndex++) {

                if (layerIndex == 0) {
                    System.out.print("  Uppers:  ");
                } else {
                    System.out.println();
                    System.out.print("  Lowers:  ");
                }

                for (toothIndex = 0; toothIndex < familyToothTypes[nameIndex][layerIndex].length; toothIndex++) {
                    if (familyToothTypes[nameIndex][layerIndex][toothIndex] == 'I' || familyToothTypes[nameIndex][layerIndex][toothIndex] == 'M' || familyToothTypes[nameIndex][layerIndex][toothIndex] == 'B'){
                        System.out.print((toothIndex + 1) + ":" + familyToothTypes[nameIndex][layerIndex][toothIndex] + "  ");
                }

                } //end of toothIndex for loop

            } //end of layerIndex for loop

        } //end of nameIndex for loop

    } //end of printTeeth method

    /**
     * Check if the inputted name matches the name of a family member
     * @param extractionMember Inputted name being checked to match the name of a family member
     * @param familyNames Array containing the family member names
     * @return Boolean value indicating if the inputted name matches one of the family members
     */
    private static boolean checkFamilyMember(String extractionMember, String[] familyNames) {
        int extractionIndex = 0;
        boolean realFamilyMember = true;

        for (extractionIndex = 0; extractionIndex < familyNames.length; extractionIndex++) {
            if (!extractionMember.equals(familyNames[extractionIndex])) {
                realFamilyMember = false;
            } else {
                realFamilyMember = true;
                return realFamilyMember;
            }
        }

        return realFamilyMember;
    } //end of checkFamilyMember method

    /**
     * Get the index of the family member whose name was inputted
     * @param extractionMember String name of the inputted family member
     * @param familyNames Array containing the names of the family members
     * @param numberOfFamilyMembers Integer corresponding to the number of family members
     * @return Integer of the inputted family member's index in the array
     */
    private static int getFamilyMemberIndex(String extractionMember, String[] familyNames, int numberOfFamilyMembers) {
        int index;

        for (index = 0; index < numberOfFamilyMembers; index++) {
            if (familyNames[index].equals(extractionMember)) {
                return index;
            }
        } //end of for loop

        return 0;

    } //end of getFamilyMemberIndex method

    /**
     * Check if the tooth layer is a valid layer, upper or lower.
     * @param toothLayer Inputted character value corresponding to the tooth layer.
     * @return Character value of 'U' or 'L' corresponding to the tooth layer.
     */
    private static char checkToothLayer(char toothLayer) {

        while (toothLayer != 'U' && toothLayer != 'L') {
            System.out.print("Invalid layer, try again                    : ");
            toothLayer = keyboard.next().charAt(0);
            toothLayer = Character.toUpperCase(toothLayer);
        } //end of toothLayer while loop

        return toothLayer;

    } //end of checkToothLayer method

    /**
     * Check if the tooth number is a valid option.
     * @param toothNumber Inputted tooth number being checked
     * @param familyToothTypes Array containing the family's tooth records
     * @param familyMemberIndex Integer corresponding to the family member's index in the array
     * @param toothLayerIndex Integer corresponding to the tooth layer's index in the array
     * @return Integer of a valid tooth number
     */
    private static int checkToothNumber(int toothNumber, char[][][] familyToothTypes, int familyMemberIndex, int toothLayerIndex) {

        while (toothNumber > familyToothTypes[familyMemberIndex][toothLayerIndex].length) {
            System.out.print("Invalid tooth number, try again             : ");
            toothNumber = keyboard.nextInt() - 1;
        } //end of while loop

        return toothNumber;

    } //end of checkToothNumber method

    /**
     * Solve and output the root canal indices for the family.
     * @param familyToothTypes Array containing the family's tooth records
     * @param numberOfFamilyMembers Integer representing the number of family members
     */
    private static void rootCanalIndices(char[][][] familyToothTypes, int numberOfFamilyMembers) {

        int nameIndex;
        int layerIndex;
        int toothIndex;
        int countI = 0;
        int countB = 0;
        int countM = 0;

        for (nameIndex = 0; nameIndex < numberOfFamilyMembers; nameIndex++) {
            for (layerIndex = 0; layerIndex < MAXIMUM_TEETH_LAYERS; layerIndex++) {
                for (toothIndex = 0; toothIndex < familyToothTypes[nameIndex][layerIndex].length; toothIndex++) {
                    if (familyToothTypes[nameIndex][layerIndex][toothIndex] == 'I') {
                        countI++;
                    } else if (familyToothTypes[nameIndex][layerIndex][toothIndex] == 'B') {
                        countB++;
                    } else if (familyToothTypes[nameIndex][layerIndex][toothIndex] == 'M') {
                        countM++;
                    }
                } //end of toothIndex for loop

            } //end of layerIndex for loop

        } //end of nameIndex for loop

        //Solve the quadratic equation
        double discriminant;
        double rootOne;
        double rootTwo;

        discriminant = countB * countB - 4 * countI * (-countM);

        rootOne = (-countB + Math.sqrt(discriminant)) / (2 * countI);
        rootTwo = (-countB - Math.sqrt(discriminant)) / (2 * countI);

        System.out.printf("One root canal at %.2f\n", rootOne);
        System.out.printf("Another root canal at %.2f\n", rootTwo);

    } //end of rootCanalIndices method

} //end of the FloridianDentalRecords class


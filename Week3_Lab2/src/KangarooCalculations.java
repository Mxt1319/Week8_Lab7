import java.util.Scanner;

//=====================================================================
public class KangarooCalculations {
    //-----------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //----Roadkill Probability Constant is 1.47
    private static final double ROADKILL_PROBABILITY_CONSTANT = 1.47;

    //-----------------------------------------------------------------
    public static void main(String[] args) {
        ;

        //----Variables to hold data
        double sideLength;
        double roadLength;
        int numKangaroos;
        double numKills;
        double numInjuries;
        double roadSurfaceArea;
        double kangarooDensity;

        //----Gather data from user
        System.out.print("Enter side of square in km : ");
        sideLength = keyboard.nextDouble();

        System.out.print("Enter roads length in km : ");
        roadLength = keyboard.nextDouble();

        System.out.print("Enter number of 'roos : ");
        numKangaroos = keyboard.nextInt();

        //----Perform calculation
        kangarooDensity = numKangaroos / Math.pow(sideLength, 2.0);
        //----Average road width = 10 m, must convert to km
        roadSurfaceArea = roadLength * (0.01);
        numKills = kangarooDensity * roadSurfaceArea * ROADKILL_PROBABILITY_CONSTANT;
        numInjuries = (numKills * 10) % 10;
        if (numInjuries != 0) {
            numInjuries = 1;
        }

        //----Display results
        System.out.println("Expected number of kills is : " + (int) numKills);
        System.out.println("Expected number of injuries : " + (int) numInjuries);
    } //----end of main method
    //-----------------------------------------------------------------
} //----end of KangarooCalculations class
//=====================================================================

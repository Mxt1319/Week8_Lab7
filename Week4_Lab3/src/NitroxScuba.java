import java.util.Scanner;

//=====================================================================
public class NitroxScuba {
    //-----------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //----Feet Per Atmosphere Constant is 33.
    private static final byte FEET_PER_ATMOSPHERE_CONSTANT = 33;
    private static final double MAX_O2_PRESSURE = 1.4;
    private static final double CONTINGENCY_O2_PRESSURE = 1.6;

    //-----------------------------------------------------------------
    public static void main(String[] args) {

        //----Variables to hold data
        int depthAmount;
        int percentageOxygen;
        double ambientPressure;
        double oxygenPressure;
        char oxygenGroup;
        boolean exceedsMaxO2Pressure;
        boolean exceedsContingencyO2Pressure;

        //----Gather data from user
        System.out.print("Enter depth and percentage : ");
        depthAmount = keyboard.nextInt();
        percentageOxygen = keyboard.nextInt();

        //----Calculate Ambient Pressure
        ambientPressure = (depthAmount / FEET_PER_ATMOSPHERE_CONSTANT) + 1;
        System.out.println("Ambient pressure :" + ambientPressure);

        //----Calculate Oxygen Pressure
        oxygenPressure = ambientPressure * (double) percentageOxygen / 100;
        System.out.println("O2 pressure : " + oxygenPressure);

        //----Calculate Oxygen Group
        oxygenGroup = (char) ((int) (oxygenPressure * 10) + (int) 'A');
        System.out.println("O2 group : " + oxygenGroup);

        //----Display OPG status
        if (oxygenPressure > MAX_O2_PRESSURE) {
            exceedsMaxO2Pressure = true;
        } else {
            exceedsMaxO2Pressure = false;
        }
        System.out.println("Exceeds maximal O2 pressure : " + exceedsMaxO2Pressure);

        if (oxygenPressure > CONTINGENCY_O2_PRESSURE) {
            exceedsContingencyO2Pressure = true;
        } else {
            exceedsContingencyO2Pressure = false;
        }
        System.out.println("Exceeds contingency O2 pressure : " + exceedsContingencyO2Pressure);


    } // end of the main method


} // end of NitroxScuba class

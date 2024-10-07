import java.sql.SQLOutput;
import java.util.Scanner;

//=====================================================
public class TaxCalculations {
    //-------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    private static final double STINKING_RICH = 500000;
    private static final double QUITE_RICH = 200000;
    private static final double MIAMI_POOR = 100000;
    private static final double AVERAGE = 50000;
    private static final double REALISTIC = 20000;
    private static final double HIGH_RATE = 0.25;
    private static final double MEDIUM_RATE = 0.10;
    private static final double LOW_RATE = 0.03;

    //-------------------------------------------------
    public static void main(String[] args) {

        double amount, income, deductions;
        double taxableIncome, taxOwed;
        char taxGroup;

        income = 0.0;
        deductions = 0.0;

        do {
            System.out.print("Enter next amount : ");
            amount = keyboard.nextDouble();
            if (amount > 0.0) {
                income += amount;
            } else {
                deductions -= amount;
            }
        } while (amount != 0.0);

        System.out.println();

        taxableIncome = computeTaxableIncome(income, deductions);

        taxGroup = chooseTaxGroup(taxableIncome);

        taxOwed = computeTax(taxableIncome, taxGroup);

        displayTaxInformation(income, deductions, taxableIncome, taxGroup, taxOwed);

    } //----end of the main method

    private static double computeTaxableIncome(double income, double deduction) {

        double taxable;
        if (income >= deduction) {
            taxable = income - deduction;
        } else {
            taxable = 0.0;
        }

        return taxable;
    } //----end of the computeTaxableIncome method

    private static char chooseTaxGroup(double income) {


        if (income >= STINKING_RICH) {
            return 'S';
        } else if (income >= QUITE_RICH) {
            return 'Q';
        } else if (income >= MIAMI_POOR) {
            return 'M';
        } else if (income >= AVERAGE) {
            return 'A';
        } else if (income >= REALISTIC) {
            return 'R';
        } else {
            return 'P';
        }

    } //----end of chooseTaxGroup method

    private static double computeTax(double taxable, char taxGroup) {

        if (taxGroup == 'S' || taxGroup == 'Q') {
            return taxable * HIGH_RATE;
        } else if (taxGroup == 'M') {
            return taxable * MEDIUM_RATE;
        } else if (taxGroup == 'A' || taxGroup == 'R') {
            return taxable * LOW_RATE;
        } else if (taxGroup == 'P') {
            return taxable * 0;
        } else {
            System.out.println("Error!");
            return 0.0;
        }

    } //----end of computeTax method

    private static void displayTaxInformation(double income, double deductions, double taxableIncome, char taxGroup, double taxOwed) {

        System.out.println("Income = $" + income);
        System.out.println("Deductions = $" + deductions);
        System.out.println("Taxable income = $" + taxableIncome);
        System.out.println("Tax group = " + taxGroup);
        System.out.println("Tax owed = $" + taxOwed);

    } //----end of displayTaxInformation method


} //----end of the TaxCalculations class

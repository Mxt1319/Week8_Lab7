import java.util.Scanner;

public class FascinatingNumbers {

    private static final Scanner keyboard = new Scanner(System.in);
    private static final int ARRAY_SIZE = 10;
    private static final int LOOP_STOPPER = 0;

    public static void main(String[] args) {
        int index;


       int[] myCandidateArray = new int[ARRAY_SIZE];
       int numberOfCandidates = getCandidateArray(myCandidateArray);
       for (index = 0; index < numberOfCandidates; ++index) {
         int currentValue = myCandidateArray[index];

         if (isFibonacci(currentValue)) {
             System.out.print(currentValue + " is Fibonacci ");
         } else {
             System.out.print(currentValue + " is not Fibonacci ");
         }
         if (isPrime(currentValue )) {
             System.out.print("and is prime");
         } else {
             System.out.print("and is not prime");

         }
           System.out.println();
       }





    } // end of the main method


    private static int getCandidateArray(int[] candidate) {
        int index = 0;
        int num;

        System.out.println("Please enter numbers (0 to stop)" );

        do {

            num = keyboard.nextInt();
            if (num > LOOP_STOPPER && index < ARRAY_SIZE) {
                candidate[index] = num;
                index++;
            }

        } while (num != LOOP_STOPPER && index < ARRAY_SIZE);

        return index;


    } //end of the getCandidateArray method

    private static boolean isFibonacci(int candidate) {

        int previous = 1;
        int current = 0;
        int next;

        while (current < candidate) {
            next = current + previous;
            previous = current;
            current = next;
        }
        if (candidate == current) {
            return (true);
        } else {
            return (false);
        }

    } //end of isFibonacci method

    /**
     * This method determines if a number is a prime number or not
     * @param candidate is the input parameter of type int
     * @return true if the candidate parameter is a prime number
     */
    private static boolean isPrime(int candidate) {

        long divisor = 2;

        while (divisor <= Math.sqrt(candidate)) {
            if (candidate % divisor == 0) {

                return(false);
            }
            divisor++;
        }
        return(true);
    } // end of the isPrime method


} //end of the FascinatingNumbers class

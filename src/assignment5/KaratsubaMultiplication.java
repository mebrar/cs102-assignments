/**
 * Created by Muhammed Ebrar Erdem on 18/11/15.
 */
package assignment5;

public class KaratsubaMultiplication {


    /**
     * Karatsuba Fast(it is not fast) Multiplication Algorithm's Recursive Implementation
     * more information can be found here: https://en.wikipedia.org/wiki/Karatsuba_algorithm
     *
     * @param x first number to be multiplied
     * @param y other number to be multiplied
     * @return the result of multiplying input x and y
     */
    public static long multiply(long x, long y){
        int xLength = numLength(x);
        int yLength = numLength(y);
        int maxLength = xLength > yLength ? xLength : yLength;


        /**
         * If the numbers are short enough, just multiplies them in regular fashion
         * In other words, this is the base case for recursive approach.
         */
        if(maxLength < 3){
            return x * y;
        }

        maxLength = (maxLength/2) + (maxLength%2);

        long multiplier = (long)Math.pow(10,maxLength);

        long b = x / multiplier;
        long a = x - (b * multiplier);
        long d = y / multiplier;
        long c = y - (d * multiplier);

        long z0 = multiply(a, c);
        long z1 = multiply(a+b, c+d);
        long z2 = multiply(b, d);

        return z0 + ((z1-z0-z2)*multiplier) + (z2*(long)(Math.pow(10,maxLength*2)));
    }

    /**
     * Basic method for calculating the number of digits in the given number
     *
     * @param number is number to determine the number of digits
     * @return how many digits that input number has
     */

    public static int numLength(long number){
        int length;
        for(length = 0; number != 0; length++){
            number /= 10;
        }
        return length;
    }

    public static void main(String[]args){
        long x = 1234123412;
        long y = 1876987698;
        long startRecur = System.nanoTime(); // starting the measuring time for recursive multiplication
        long resultRecursive = multiply(x,y); // recursive karatsuba multiplication
        long elapsedRecur = System.nanoTime() - startRecur; // measuring elapsed time for recursive multiplication

        System.out.println("Recursive multiplication result: " + resultRecursive + "  TIME: " + elapsedRecur);
        long startNormal = System.nanoTime(); // starting the measuring time for normal multiplication
        long resultNormal = x*y;  // simple multiplication
        long elapsedNormal = System.nanoTime() - startNormal; // measuring elapsed time for normal multiplication
        System.out.println("Normal multiplication result: " + resultNormal + "  TIME: " + elapsedNormal);
    }
}

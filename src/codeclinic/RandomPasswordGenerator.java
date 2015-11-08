/**
 * Created by Ebrar on 08/11/15.
 */
package codeclinic;

import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {
    static Random randomNumberGenerator = new Random();
    public static String genRandPass(String input, int n){
        String output = "";
        for(int i = 0; i < n; i++){
            output += input.charAt(randomNumberGenerator.nextInt(input.length()));
        }
        output += randomNumberGenerator.nextInt(10) + "" + randomNumberGenerator.nextInt(10);
        return output;
    }

    public static void main(String[]args){
        Scanner stringScan = new Scanner(System.in);
        Scanner integerScan = new Scanner(System.in);

        System.out.print("Enter the string input: ");
        String input = stringScan.nextLine();
        System.out.print("Enter the integer n: ");
        int n = integerScan.nextInt();

        System.out.println("Your password is " + genRandPass(input, n));
    }
}

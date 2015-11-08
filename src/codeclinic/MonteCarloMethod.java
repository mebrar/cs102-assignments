/**
 * Created by Ebrar on 08/11/15.
 */
package codeclinic;

import java.util.Random;
import java.util.Scanner;

public class MonteCarloMethod {

    public static void main(String[]args){
        Random randomGenerator = new Random();
        Scanner integerScan = new Scanner(System.in);
        int hitCount = 0;
        int tryCount;

        System.out.print("Enter an integer to try: ");
        tryCount = integerScan.nextInt();

        for(int currentTry = 0; currentTry < tryCount; currentTry++){
            if(isHit()){
                hitCount++;
            }
        }

        System.out.println("Calculated pi is " + (4*((double)hitCount/tryCount)));
    }

    public static boolean isHit(){
        return Math.pow(Math.random()*2-1,2) + Math.pow(Math.random()*2-1,2) < 1;
    }
}

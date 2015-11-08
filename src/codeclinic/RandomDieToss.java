/**
 * Created by Ebrar on 08/11/15.
 */
package codeclinic;

import java.util.Random;

public class RandomDieToss {
    static Random dieTosser = new Random();

    public static int[] tossDie(int tossLimit){
        int[] tossValues = new int[tossLimit];
        for(int index = 0; index < tossLimit; index++){
            tossValues[index] = dieTosser.nextInt(6)+1;
        }
        return tossValues;
    }

    public static void markLongestRun(int[] input){
        int lastValue;
        int runCount = 0;
        for(int index = 1; index < input.length-1; index++){
            lastValue = input[index-1];
            if(lastValue == input[index]){
                runCount++;
            }
            else{
                runCount = 0;
            }
        }
    }

    public static void main(String[]args){
        int[] tossedValues = tossDie(50);
        for(int i = 0; i < tossedValues.length; i++){
            System.out.print(tossedValues[i] + " ");
        }
    }
}

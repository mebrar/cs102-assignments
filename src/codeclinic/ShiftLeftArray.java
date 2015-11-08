/**
 * Created by Ebrar on 08/11/15.
 */
package codeclinic;

public class ShiftLeftArray {

    public static void shiftLeft(int[] input, int n){
        int firstValue;
        for(int cycleCount = 0; cycleCount < n; cycleCount++){
            firstValue = input[0];
            for(int index = 1; index < input.length; index++){
                input[index-1] = input[index];
            }
            input[input.length-1] = firstValue;
        }
    }

    public static void printArray(int[] array){
        System.out.print("[");
        for(int index = 0; index < array.length; index++){
            System.out.print(" " + array[index]+ ",");
        }
        System.out.println("]");
    }

    public static void main(String[]args){
        int[] array = {2,3,5,7,11,13};
        printArray(array);
        shiftLeft(array,2);
        printArray(array);
    }
}

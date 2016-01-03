package codeclinic;

/**
 * Created by Ebrar on 01/01/16.
 */
public class BinarySearch {

    public static int binarySearch(int[] sortedInput, int toBeSearched){
        return recursiveSearch(sortedInput,toBeSearched,0,sortedInput.length-1);
    }

    public static int recursiveSearch(int[] sortedInput, int toBeSearched, int startPosition, int endPosition){
        int middlePoint = (startPosition + endPosition) /2;
        if(endPosition < startPosition){
            return -1;
        }

        if(toBeSearched == sortedInput[middlePoint]){
            return middlePoint;
        }
        else if(toBeSearched < sortedInput[middlePoint]){
            return recursiveSearch(sortedInput,toBeSearched,0,middlePoint-1);
        }
        else if(toBeSearched > sortedInput[middlePoint]){
            return recursiveSearch(sortedInput,toBeSearched,middlePoint+1,endPosition);
        }
        else{
            return -1;
        }
    }

    public static void main(String[]args){
        int[] test = new int[10000];
        for(int i = 0; i < test.length; i++){
            test[i] = i * 5;
        }
        System.out.println(binarySearch(test,10));
    }
}

package codeclinic;

/**
 * Created by Ebrar on 02/01/16.
 */
public class FindLargest {

    public static int findLargest(int[] input){
        if(input.length > 1){
            return findLargestRecursively(input,1,input[0]);
        }
        else if(input.length == 1){
            return input[0];
        }
        else{
            return -1;
        }
    }

    public static int findLargestRecursively(int[] input,int currentPosition, int currentLargest){
        if(currentPosition == input.length){
            return currentLargest;
        }
        else{
            currentLargest = currentLargest > input[currentPosition] ? currentLargest : input[currentPosition];
            return findLargestRecursively(input,currentPosition+1,currentLargest);
        }
    }

    public static void main(String[]args){
        int[] test = new int[10];
        for(int i = 0; i < test.length; i++){
            test[i] = (int)(Math.random()*1000);
        }
        System.out.println(findLargest(test));
    }
}

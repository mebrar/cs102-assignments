package codeclinic;

/**
 * Created by Ebrar on 02/01/16.
 */
public class MergeSort {


    public static void recursiveMergeSort(int[] input){
        if(input.length <= 1){
            return;
        }

        int[] leftHand = new int[input.length/2];
        int[] rightHand = new int[input.length - leftHand.length];

        for(int i = 0; i < leftHand.length; i++){
            leftHand[i] = input[i];
        }

        for(int i = 0; i < rightHand.length; i++){
            rightHand[i] = input[leftHand.length+i];
        }

        recursiveMergeSort(leftHand);
        recursiveMergeSort(rightHand);

        merge(leftHand,rightHand,input);

    }

    public static void merge(int[] leftHand, int[] rightHand, int[] input){
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;

        while(leftIndex < leftHand.length && rightIndex < rightHand.length){
            if(leftHand[leftIndex] < rightHand[rightIndex]){
                input[index++] = leftHand[leftIndex++];
            }
            else{
                input[index++] = rightHand[rightIndex++];
            }
        }

        while(leftIndex < leftHand.length){
            input[index++] = leftHand[leftIndex++];
        }

        while(rightIndex < rightHand.length){
            input[index++] = rightHand[rightIndex++];
        }
    }


    public static void main(String[]args){
        int[] test = new int[1000];
        for(int i = 0; i < test.length; i++){
            test[i] = (int)(Math.random()*100000);
        }
        recursiveMergeSort(test);
        ShiftLeftArray.printArray(test);
    }

}

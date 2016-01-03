package codeclinic;

/**
 * Created by Ebrar on 01/01/16.
 */
public class QuickSort {

    public static void quickSort(int[] input){
       qcksrt(input,0,input.length-1);
    }

    public static void recursiveQuickSort(int[] input,int startingIndex, int lastIndex){
        if(input.length < 2){
            return;
        }
        int pivotPosition = quickSortPartition(input,startingIndex,lastIndex);
        System.out.println("Pivot Position: " + pivotPosition);
        recursiveQuickSort(input,startingIndex,pivotPosition-1);
        recursiveQuickSort(input,pivotPosition+1,lastIndex);
    }

    public static int quickSortPartition(int[] input, int left, int right){
        int pivot = input[left];
        int i = 1;
        int temp;
        for(int j = i; j < right; j++){
            if(input[j] < pivot){
            }
            else{
                temp = input[j];
                input[j] = input[i];
                input[i] = temp;
                i++;
            }
        }
        input[left] = input[i-1];
        input[i-1] = pivot;
        return i-1;
    }

    public static int alternatePartition(int[] input, int left, int right){
        int pivot = input[left];
        while(true){
            while(input[left] < pivot){
                left++;
            }
            while(input[right] > pivot){
                right--;
            }
            if(left < right){
                int temp = input[right];
                input[right] = input[left];
                input[left] = temp;
            }
            else{
                return right;
            }
        }
    }


    public static void alternateRecursiveQuickSort(int[] input, int left, int right){
        if(left < right){
            int pivot = alternatePartition(input,left,right);

            if(pivot > 1){
                alternateRecursiveQuickSort(input,left,pivot-1);
            }
            if(pivot + 1 > right){
                alternateRecursiveQuickSort(input,pivot+1,right);
            }
        }
    }



    public static void qcksrt(int[] input, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = input[0];
        int i = left;
        int j = right;
        while(i <= j){
            while(input[i] < pivot){
                i++;
            }
            while(input[j] > pivot){
                j--;
            }
            if(i <= j){
                int temp = input[i];
                input[i++] = input[j];
                input[j--] = temp;
            }
        }
        if(left < j){
            qcksrt(input,left,j);
        }
        if(right > i){
            qcksrt(input,i,right);
        }
    }

    public static void main(String[]args){
        int[] test = new int[20];
        for(int i = 0; i < test.length; i++){
            test[i] = (int)(Math.random()*1000);
        }
        ShiftLeftArray.printArray(test);
        quickSort(test);
        ShiftLeftArray.printArray(test);
    }
}

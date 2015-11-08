/**
 * Created by Ebrar on 08/11/15.
 */
package codeclinic;

public class SwapArray {

    public static void swapRows(char[][] input, int x, int y){
        char[] temp = input[y];
        input[y] = input[x];
        input[x] = temp;
    }

    public static void swapColumn(char[][] input, int x, int y){
        char temp;
        for(int i = 0; i < input.length; i++){
            temp = input[i][x];
            input[i][x] = input[i][y];
            input[i][y] = temp;
        }
    }

    public static void main(String[]args){
        char[][] array = {{'a','b','c','d','e'},{'v','r','y','d','e'},{'t','y','u','ı','u'}};
        for(int i = 0; i < array.length; i++){
            printArray(array[i]);
        }
        swapRows(array,0,2);
        System.out.println();
        for(int i = 0; i < array.length; i++){
            printArray(array[i]);
        }
        swapColumn(array,0,1);
        System.out.println();
        for(int i = 0; i < array.length; i++){
            printArray(array[i]);
        }

    }

    public static void printArray(char[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

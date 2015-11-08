/**
 * Created by Ebrar on 08/11/15.
 */
package codeclinic;

import java.util.Random;

public class Shuffle2DArray {
    static Random randomNumberGenerator = new Random();

    public static void main(String[]args){
        int[][] array = {{1,2,3,4,5,6,7,8,9,10},{2,3,5,7,11,13,17,19,23,29},{1,1,2,3,5,8,13,21,34,55}};
        printArray(array);
        System.out.println();
        shuffle(array, 10);
        printArray(array);
    }

    public static void printArray(int[][] array){
        for(int row = 0; row < array.length; row++){
            for(int column = 0; column < array[row].length; column++){
                System.out.print(array[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static void shuffle(int[][] input,int shuffleLimit){
        int randomRow1;
        int randomRow2;
        int randomColumn1;
        int randomColumn2;
        int temp;
        for(int shuffleCount = 0; shuffleCount < shuffleLimit; shuffleCount++){
            randomRow1 = randomNumberGenerator.nextInt(input.length);
            randomRow2 = randomNumberGenerator.nextInt(input.length);
            randomColumn1 = randomNumberGenerator.nextInt(input[randomRow1].length);
            randomColumn2 = randomNumberGenerator.nextInt(input[randomRow2].length);
            temp = input[randomRow1][randomColumn1];
            input[randomRow1][randomColumn1] = input[randomRow2][randomColumn2];
            input[randomRow2][randomColumn2] = temp;
        }
    }

}

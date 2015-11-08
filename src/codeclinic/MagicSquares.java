/**
 * Created by Ebrar on 08/11/15.
 */
package codeclinic;

import java.util.Scanner;

public class MagicSquares {

    public static void main(String[]args){
        Scanner integerScan = new Scanner(System.in);
        int[][] magicSquare = new int[4][4];
        int number;
        for(int column = 0; column < 4; column++){
            for(int row = 0; row < 4; row++){
                System.out.print("Enter number: ");
                number = integerScan.nextInt();
                magicSquare[column][row] = number;
            }
        }
        if(checkNumbers(magicSquare) && checkMagic(magicSquare)){
            System.out.println("Your array is magic. Congratulations!!");
        }
        else{
            System.out.println("Your array is not magical... Poor you :(  ");
        }
    }

    public static boolean checkNumbers(int[][] magicArray) {
        for (int column = 0; column < 4; column++) {
            for (int row = 0; row < 4; row++) {
                if(!(magicArray[column][row] <17 && magicArray[column][row] > 0)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkMagic(int[][] magicArray){
        int sumToBe = (int)(magicArray.length*(Math.pow(magicArray.length,2)+1))/2;
        int rowSum;
        int columnSum;
        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        for(int column = 0; column < 4; column++){
            rowSum = 0;
            columnSum = 0;
            for(int row = 0; row < 4; row++){
                rowSum += magicArray[column][row];
                columnSum += magicArray[row][column];
            }
            if(rowSum != sumToBe || columnSum != sumToBe){
                return false;
            }
        }
        for(int diagonalCount = 0; diagonalCount < magicArray.length; diagonalCount++){
            diagonalSum1 += magicArray[diagonalCount][diagonalCount];
            diagonalSum2 += magicArray[diagonalCount][magicArray.length-1-diagonalCount];
        }
        if(diagonalSum1 != sumToBe || diagonalSum2 != sumToBe){
            return false;
        }
        return true;
    }
}

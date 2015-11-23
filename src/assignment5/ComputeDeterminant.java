/**
 * Created by Muhammed Ebrar Erdem on 18/11/15.
 */
package assignment5;

import java.io.*;
import java.util.Scanner;

public class ComputeDeterminant {

    static int recursionCount = 0;

    /**
     * Recursive approach for calculating the determinant for given matrix
     * Base case is 2x2 matrix, which can be calculated easily
     * Also handles the cases which matrix length is whether 0 or 1
     *
     * Solving the determinant of the nxn matrix with Laplace expansion
     * More information about Laplace expansion can be found here: https://en.wikipedia.org/wiki/Laplace_expansion
     *
     * @param matrix is the two dimensional array which determinant is going to be calculated
     * @return the determinant of the input matrix
     */

    public static int recursiveDeterminant(int[][] matrix){
        recursionCount++;
        System.out.println("Recursion Count is " + recursionCount + " with matrix length :" + matrix.length + " and matrix:");
        printMatrix(matrix);
        int determinant = 0;
        if(matrix.length == 0){
            determinant = -1;
        }
        else if(matrix.length == 1){
            determinant = matrix[0][0];
        }
        else if(matrix.length == 2){
            determinant = (matrix[0][0] * matrix[1][1]) - (matrix[0][1]*matrix[1][0]);
        }
        else {
            for (int column = 0; column < matrix.length; column++) {
                determinant += Math.pow(-1,column)* matrix[0][column] * recursiveDeterminant(formSmallerMatrix(matrix, column));
            }
        }
        return determinant;
    }

    /**
     * Forms a smaller matrix for calculating the determinant for matrix with Laplace expansion.
     *
     *
     * @param matrix is the two dimensional array which determinant is calculating currently
     * @param columnPosition is the position of the element that is used for calculating the matrix' current determinant
     * @return the smaller matrix formed for calcualting determinant
     */

    public static int[][] formSmallerMatrix(int[][] matrix, int columnPosition){
        int[][] smallerMatrix = new int[matrix.length-1][matrix.length-1];
        int originalColumnIndex;
        for(int row = 0; row < smallerMatrix.length; row++){
            originalColumnIndex = 0;
            for(int column = 0; column < smallerMatrix.length; column++){
                if((columnPosition == column)){
                    originalColumnIndex++;
                }
                System.out.println("smallerMatrix["+row+"]["+column+"] = matrix["+(row+1)+"]["+column+"]");
                smallerMatrix[row][column] = matrix[row+1][originalColumnIndex];
                originalColumnIndex++;
            }
        }
        System.out.println("Smaller Matrix:");
        printMatrix(smallerMatrix);
        return smallerMatrix;
    }

    /**
     * Reads the file with the name fileName that inputted
     * and returns the matrix notation in Java, which is array, for this file
     *
     * Assumes that first number in the first line of the file
     * will be always the length of the matrix
     *
     * @param fileName is the name for input file
     * @return the generated matrix from input file
     * @throws IOException
     */

    public static int[][] generateMatrix(String fileName) throws IOException{
        Scanner fileScan = new Scanner(new File(fileName));

        int matrixDimension = fileScan.nextInt();
        int[][] matrix = new int[matrixDimension][matrixDimension];

        String line;
        fileScan.nextLine();
        for(int lineCount = 0; lineCount < matrixDimension; lineCount++){
            line = fileScan.nextLine();
            System.out.println(line);
            for(int elementIndex = 0; elementIndex < matrixDimension; elementIndex++){
                matrix[lineCount][elementIndex] = Integer.parseInt(line.substring(elementIndex,elementIndex+1));
            }
        }
        return matrix;
        /**
        for(int row = 0; row < matrixDimension; row++){
            for(int column = 0; column < matrixDimension; column++){
                matrix[row][column] = fileScan.nextInt();
            }
        }
        return matrix;
        */
    }

    /**
     * Prints the inputted matrix,
     * just for automation issues
     *
     * @param matrix to be printed
     */

    public static void printMatrix (int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column < matrix[row].length; column++){
                System.out.print(matrix[row][column]);
            }
            System.out.println();
        }
    }



    public static void main(String[]args) throws IOException{

        Scanner stringScan = new Scanner(System.in);
        // System.out.print("Enter the file's name to be read:");
        // String fileName = stringScan.nextLine();
        int[][] matrix = generateMatrix("matrix.txt");
        printMatrix(matrix);
        System.out.println("Determinant is " + recursiveDeterminant(matrix));
    }


}

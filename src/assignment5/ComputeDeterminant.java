/**
 * Created by Muhammed Ebrar Erdem on 18/11/15.
 */
package assignment5;

import java.io.*;
import java.util.Scanner;

public class ComputeDeterminant {

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

    public static double recursiveDeterminant(double[][] matrix){
        double determinant = 0;
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
                determinant += Math.pow(-1,column)* matrix[0][column] * recursiveDeterminant(formSmallerMatrix(matrix, column,0));
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


    public static double[][] formSmallerMatrix(double[][] matrix, int columnPosition, int rowPosition){
        double[][] smallerMatrix = new double[matrix.length-1][matrix.length-1];
        int originalColumnIndex;
        int originalRowIndex = 0;
        for(int row = 0; row < smallerMatrix.length; row++, originalRowIndex++){
            originalColumnIndex = 0;
            if(originalRowIndex == rowPosition){
                originalRowIndex++;
            }
            for(int column = 0; column < smallerMatrix.length; column++, originalColumnIndex++){
                if((columnPosition == column)){
                    originalColumnIndex++;
                }
                smallerMatrix[row][column] = matrix[originalRowIndex][originalColumnIndex];
            }
        }
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

    public static double[][] generateMatrix(String fileName) throws IOException{
        Scanner fileScan = new Scanner(new File(fileName));

        int matrixDimension = fileScan.nextInt();
        double[][] matrix = new double[matrixDimension][matrixDimension];
        for(int row = 0; row < matrixDimension; row++){
            for(int column = 0; column < matrixDimension; column++){
                matrix[row][column] = fileScan.nextDouble();
            }
        }
        return matrix;
    }



    public static double[][] transposeOfMatrix(double[][] matrix){
        double[][] transposedMatrix = new double[matrix.length][matrix.length];
        double[] columnArray = new double[matrix.length];
        for(int column = 0; column < matrix.length; column++){
            for(int row = 0; row < matrix[column].length; row++){
                transposedMatrix[row][column] = matrix[column][row];
            }
            // transposedMatrix[column] = columnArray;
        }
        return transposedMatrix;
    }

    public static double[][] cofactorOfMatrix(double[][] matrix){
        double[][] cofactoredMatrix = new double[matrix.length][matrix.length];
        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column < matrix[row].length; column++){
                cofactoredMatrix[row][column] = Math.pow(-1,column+row)*recursiveDeterminant(formSmallerMatrix(matrix,column,row));
            }
        }
        System.out.println("COFACTORED");
        printMatrix(cofactoredMatrix);
        return cofactoredMatrix;
    }


    public static double[][] inverseMatrix(double[][] matrix){
        double[][] inversedMatrix = new double[matrix.length][matrix.length];
        double determinant = recursiveDeterminant(matrix);
        if(determinant == 0){
            System.out.println("Inverse cannot be calculated with a matrix with determinant is 0!\nReturning the empty matrix...");
            return inversedMatrix;
        }
        else {
            inversedMatrix = transposeOfMatrix(cofactorOfMatrix(matrix));
            printMatrix(inversedMatrix);
            for(int row = 0; row < matrix.length; row++){
                for(int column = 0; column < matrix[row].length; column++){
                    inversedMatrix[row][column] *= (1/determinant);
                }
            }
        }
        return inversedMatrix;
    }

    /**
     * Prints the inputted matrix,
     * just for automation issues
     *
     * @param matrix to be printed
     */

    public static void printMatrix (double[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column < matrix[row].length; column++){
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[]args) throws IOException{

        Scanner stringScan = new Scanner(System.in);
        System.out.print("Enter the file's name to be read:");
        String fileName = stringScan.nextLine();
        double[][] matrix = generateMatrix(fileName);
        printMatrix(matrix);
        System.out.println();
        double[][] inversedMatrix = inverseMatrix(matrix);
        printMatrix(inversedMatrix);
        System.out.println("Determinant is " + recursiveDeterminant(matrix));
    }

}

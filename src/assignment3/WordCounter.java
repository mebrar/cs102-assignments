/**
 * Created by Muhammed Ebrar Erdem on 14/10/15.
 */
package assignment3;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class WordCounter {

    static long startSortingTime;
    static long elapsedSortTime;
    
    public static void main(String[]args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        Scanner integerScan = new Scanner(System.in);
        ArrayList<String> wordList = new ArrayList<String>();
        ArrayList<Integer> wordCountList = new ArrayList<Integer>();

        int option;
        int tempCount;
        String inputFileName;
        String outputFileName = "";
        String currentWord;

        System.out.print("Enter the input file to be read :");
        inputFileName = keyboard.nextLine();
        Scanner fileScan = new Scanner(new File(inputFileName));


        while(fileScan.hasNext()){
            currentWord = fileScan.next().toLowerCase();
            currentWord = cleanString(currentWord);
            if(wordList.contains(currentWord)){
                tempCount = wordCountList.get(wordList.indexOf(currentWord)).intValue();
                wordCountList.set(wordList.indexOf(currentWord), tempCount+1);
            }
            else{
                wordList.add(currentWord);
                wordCountList.add(1);
            }
        }

        System.out.print("1- Sort as alphabetical order and write to a file\n" +
                "2- Sort by frequency of words and write to a file \n" +
                "Enter the option: ");
        option = integerScan.nextInt();
        switch(option){
            case 1:
                // alphabetical
                sortByAlphabetical(wordList, wordCountList);
                System.out.print("Enter the output file name: ");
                outputFileName = keyboard.nextLine();
                writeToFile(outputFileName, wordList, wordCountList);
                break;

            case 2:
                // frequency
                sortByFrequency(wordList, wordCountList);
                System.out.print("Enter the output file name: ");
                outputFileName = keyboard.nextLine();
                writeToFile(outputFileName, wordList, wordCountList);
                break;
            default:
                System.out.println("You've entered a wrong input...");
        }
        System.out.println("Output file created with name " + outputFileName);
    }

    /**
     *
     * @param word
     */

    public static String cleanString(String word){
        return word.replaceAll("\\p{Punct}", "");
    }



    /**
     * insörşın sort
     * @param words
     * @param wordCounts
     */

    public static void sortByFrequency(ArrayList<String> words, ArrayList<Integer> wordCounts){
        startSortingTime = System.nanoTime();
        boolean isInserted;
        for(int sortedIndex = 1; sortedIndex < wordCounts.size(); sortedIndex++){
            isInserted = false;
            for(int checkIndex = 0; checkIndex < sortedIndex && !isInserted; checkIndex++){
                if (wordCounts.get(sortedIndex).compareTo(wordCounts.get(checkIndex)) > 0){
                    wordCounts.add(checkIndex, wordCounts.get(sortedIndex));
                    words.add(checkIndex, words.get(sortedIndex));
                    wordCounts.remove(sortedIndex + 1);
                    words.remove(sortedIndex + 1);
                    isInserted = true;
                }
            }
        }
        elapsedSortTime = System.nanoTime() - startSortingTime;
        System.out.println("Sorted in " + elapsedSortTime + " nanoseconds...");
    }

    /**
     *
     * @param words
     * @param wordCounts
     */

    public static void sortByAlphabetical(ArrayList<String> words, ArrayList<Integer> wordCounts){
        startSortingTime = System.nanoTime();
        boolean isInserted;
        for(int sortedIndex = 1; sortedIndex < wordCounts.size(); sortedIndex++){
            isInserted = false;
            for(int checkIndex = 0; checkIndex < sortedIndex && !isInserted; checkIndex++){
                if (words.get(sortedIndex).compareTo(words.get(checkIndex)) < 0){
                    wordCounts.add(checkIndex, wordCounts.get(sortedIndex));
                    words.add(checkIndex, words.get(sortedIndex));
                    wordCounts.remove(sortedIndex + 1);
                    words.remove(sortedIndex + 1);
                    isInserted = true;
                }
            }
        }
        elapsedSortTime = System.nanoTime() - startSortingTime;
        System.out.println("Sorted in " + elapsedSortTime + " nanoseconds...");
    }



    public static int indexOfWord(ArrayList<String> words, String word){

            return -1;
    }

    /**
     *
     * @param outputFileName
     * @param words
     * @param wordCounts
     */

    public static void writeToFile(String outputFileName, ArrayList<String> words, ArrayList<Integer> wordCounts) throws IOException{
        PrintWriter outputFile = new PrintWriter(outputFileName);
        for (int index = 0; index < words.size(); index++){
            outputFile.println(words.get(index) + "\t" + wordCounts.get(index));
        }
        outputFile.close();
    }
}

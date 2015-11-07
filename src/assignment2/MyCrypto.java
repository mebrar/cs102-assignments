/**
 * This class provides simple encryption and decryption within user-defined key.
 *
 * Encryption as follows:
 * Every character shifted by this formula:
 * initial character + (key * (wordIndex + 1) + 1) [mod 26]
 * where "key" is user defined key and
 * "wordIndex" is
 *
 *
 *
 *
 *
 *
 * Created by Muhammed Ebrar Erdem on 29/09/15.
 */
package assignment2;

import java.util.Scanner;

public class MyCrypto {

    /**
     *
     * @param plainText a string to be encrypted
     * @param key a positive integer that used for character shifting
     * @return ciphered version of plainText with key
     */

    public static String encryptString(String plainText, int key){
        Scanner stringScan = new Scanner(plainText.toLowerCase()).useDelimiter(" ");
        String cipheredText = "";
        String currentWord;
        for(int wordCount = 0; stringScan.hasNext(); wordCount++){
            currentWord = stringScan.next();
            if (currentWord.isEmpty()) {
                cipheredText += " ";
                wordCount--;
                continue;
            }
            cipheredText += encryptWord(currentWord, key, wordCount) + " ";
        }
        return cipheredText;
    }

    /**
     *
     * @param plainWord
     * @param key a positive integer that used for character shifting
     * @param wordCount index of the plainWord at the plainText
     * @return ciphered version of plainWord with key
     */

    private static String encryptWord(String plainWord, int key, int wordCount){
        String cipheredWord = "";
        char cipheredChar;
        for(int charIndex = 0; charIndex < plainWord.length(); charIndex++){
            cipheredChar = (char) (plainWord.charAt(charIndex) + calculateShift(key, wordCount));
            cipheredChar = (char) (cipheredChar > 122 ? cipheredChar - 26 : cipheredChar);
            cipheredWord += cipheredChar;
        }
        return cipheredWord;
    }


    /**
     *
     * @param cipheredString a string to be deciphered
     * @param key a positive integer that used for character shifting to decipher the cipheredString
     * @return deciphered version of cipheredString
     */

    public static String decipherString(String cipheredString, int key){
        Scanner stringScan = new Scanner(cipheredString).useDelimiter(" ");
        String decipheredString = "";
        String currentWord;
        for(int wordCount = 0; stringScan.hasNext(); wordCount++){
            currentWord = stringScan.next();
            if (currentWord.isEmpty()) {
                decipheredString += " ";
                wordCount--;
                continue;
            }
            decipheredString += decipherWord(currentWord, key, wordCount) + " ";
        }
        return decipheredString;
    }

    /**
     *
     * @param cipheredWord
     * @param key a positive integer that used for character shifting to decipher the cipheredString
     * @param wordCount index of the cipheredWord at the cipheredString
     * @return deciphered version of cipheredWord
     */

    private static String decipherWord(String cipheredWord, int key, int wordCount){
        String decipheredWord = "";
        char decipheredChar;
        for(int charIndex = 0; charIndex < cipheredWord.length(); charIndex++){
            decipheredChar = (char) (cipheredWord.charAt(charIndex) - calculateShift(key, wordCount));
            decipheredChar = (char) (decipheredChar < 97 ? decipheredChar + 26 : decipheredChar);
            decipheredWord += decipheredChar;
        }
        return decipheredWord;
    }

    /**
     * Calculates the shifting for characters of the word
     * For working with both encryption and decryption, modulus operation handled in this method.
     * Implementation of encryptWord and decipherWord methods
     *
     * @param key a positive integer as a key
     * @param wordCount index of the word at the string
     * @return shifting value for characters as modulus 26
     */

    private static int calculateShift(int key, int wordCount){
        return (key * (wordCount + 1) +1) % 26;
    }

}
